package org.fir3.avm.environment.classloader.cache;

import lombok.extern.java.Log;
import org.apache.commons.codec.digest.DigestUtils;
import org.fir3.avm.environment.util.StreamUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;

@Log
public class DefaultCacheProvider implements CacheProvider {
    /**
     * The file extension of cache files (for the purpose of identification, cc = cached class).
     */
    private static final String FILE_EXTENSION = "cc";

    private static final FileFilter CACHE_FILE_FILTER = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            // We only accept real files or objects that act as real file (no directories)

            if (!pathname.isFile()) {
                return false;
            }

            // We only accept files that end with the FILE_EXTENSION

            String name = pathname.getName();
            int dotIdx = name.lastIndexOf('.');

            if (dotIdx == -1 || dotIdx + 1 >= name.length()) {
                return false;
            }

            return name.substring(dotIdx + 1).toLowerCase().equals(DefaultCacheProvider.FILE_EXTENSION);
        }
    };

    private static final Comparator<File> LAST_ACCESS_COMPARATOR = new Comparator<File>() {
        @Override
        public int compare(File a, File b) {
            BasicFileAttributes aAttr, bAttr;

            try {
                aAttr = Files.readAttributes(a.toPath(), BasicFileAttributes.class);
                bAttr = Files.readAttributes(b.toPath(), BasicFileAttributes.class);
            } catch (IOException ex) {
                log.log(Level.WARNING, "Cannot read file attributes of {0} or {1}", new Object[] {
                        a.getAbsolutePath(),
                        b.getAbsolutePath()
                });

                return 0;
            }

            return aAttr.lastAccessTime().compareTo(bAttr.lastAccessTime());
        }
    };

    private class DefaultCache implements Cache {
        private final File baseDirectory;
        private final String baseHash;

        DefaultCache(File baseDirectory, String baseHash) {
            this.baseDirectory = baseDirectory;
            this.baseHash = baseHash;
        }

        @Override
        public void setBinaryClass(String className, byte[] data) {
            // Check, if the cache provides enough free space for the class

            try {
                if (!DefaultCacheProvider.this.makeAvailable(data.length)) {
                    log.log(Level.INFO, "Cannot make {0} bytes available for {1} in cache", new Object[] {
                            data.length,
                            className
                    });

                    return;
                }
            } catch (IOException ex) {
                log.log(Level.WARNING, "Cannot make space available in cache directory", ex);
            }

            // Write the class to a physical file

            try (OutputStream out = new FileOutputStream(this.getPhysicalFile(className))) {
                out.write(data);
            } catch (IOException ex) {
                log.log(Level.WARNING, "Cannot write class to physical file", ex);
            }
        }

        @Override
        public byte[] getBinaryClass(String className) {
            File classFile = this.getPhysicalFile(className);

            if (classFile.isFile()) {
                try (InputStream in = new FileInputStream(classFile)) {
                    return StreamUtil.readFully(in);
                } catch (IOException ex) {
                    log.log(Level.WARNING, "Cannot access cached class {0} at {1}", new Object[]{
                            className,
                            classFile
                    });
                }
            }

            return null;
        }

        private File getPhysicalFile(String className) {
            String hashedName = DigestUtils.md5Hex(String.format("%s_%s_cached", this.baseHash, className));
            return new File(this.baseDirectory, hashedName);
        }
    }

    private final File baseDirectory;
    private final long maxCacheSize;

    public DefaultCacheProvider(File cacheDirectory, long maxCacheSize) throws IOException {
        this.baseDirectory = cacheDirectory;
        this.maxCacheSize = maxCacheSize;

        if (!this.baseDirectory.isDirectory() && !this.baseDirectory.mkdirs()) {
            throw new IOException("Cannot create the cache directory at " + cacheDirectory.getAbsolutePath());
        }
    }

    @Override
    public Cache getCache(byte[] dexData) {
        return new DefaultCache(this.baseDirectory, DigestUtils.md5Hex(dexData));
    }

    @Override
    public void reset() {
        // Simply remove all cache files

        File[] files = null;

        try {
            files = this.getCacheFiles();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }

        for (File file : files) {
            if (file.delete()) {
                continue;
            }

            log.log(Level.WARNING, "Cannot remove cache file at {0}", file.getAbsolutePath());
        }
    }

    private File[] getCacheFiles() throws IOException {
        File[] files = this.baseDirectory.listFiles(DefaultCacheProvider.CACHE_FILE_FILTER);

        if (files == null) {
            throw new IOException("Cannot collect all cache files inside the cache directory");
        }

        return files;
    }

    private long getCacheSize() throws IOException {
        File[] files = this.getCacheFiles();

        // Sum up all the sizes of a cache files

        long totalSize = 0L;

        for (File file : files) {
            totalSize += file.length();
        }

        return totalSize;
    }

    private boolean makeAvailable(long bytes) throws IOException {
        // Check, if the cache is able to provide that much bytes at all

        if (this.maxCacheSize < bytes) {
            return false;
        }

        // Remove cached elements until we have freed enough space to grant the request

        long occupiedSize = this.getCacheSize();

        // Sort the cacheFiles by their "lastAccess" date. The newest date is at the smallest index, the oldest date is
        // at the greatest index.

        List<File> cacheFiles = Arrays.asList(this.getCacheFiles());
        Collections.sort(cacheFiles, DefaultCacheProvider.LAST_ACCESS_COMPARATOR);

        while (this.maxCacheSize - occupiedSize < bytes) {
            if (cacheFiles.isEmpty()) {
                return false;
            }

            // Remove the last file of the cacheFiles list

            File cacheFile = cacheFiles.get(cacheFiles.size() - 1);
            long fileSize = cacheFile.length();

            // Remove it from the list as we have handled the item

            cacheFiles.remove(cacheFile);

            // Try to remove the physical file which may not succeed

            if (cacheFile.delete()) {
                occupiedSize -= fileSize;
            }
        }

        return true;
    }
}
