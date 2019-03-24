package org.fir3.avm.environment;

import lombok.Getter;
import org.fir3.avm.environment.classloader.CachedClassLoader;
import org.fir3.avm.environment.classloader.DexClassPool;
import org.fir3.avm.environment.classloader.cache.Cache;
import org.fir3.avm.environment.classloader.cache.EmptyCacheProvider;
import org.fir3.avm.environment.util.MultiClassLoader;
import org.fir3.avm.environment.util.StreamUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ApkAccess {
    @Getter
    private final File physicalFile;
    private final ZipFile zipFile;

    private ClassLoader classLoader;

    ApkAccess(File src) throws IOException {
        this.physicalFile = src;

        if (!this.physicalFile.isFile()) {
            throw new IOException("Physical file does not exist!");
        }

        this.zipFile = new ZipFile(this.physicalFile, ZipFile.OPEN_READ);
    }

    public InputStream getInputStream(String path) throws IOException {
        ZipEntry entry = this.zipFile.getEntry(path);

        if (entry == null) {
            throw new IOException("No APK entry with path: " + path);
        }

        return this.zipFile.getInputStream(entry);
    }

    public ClassLoader getClassLoader() throws IOException {
        // If the classLoader has been created already, use that instance.

        if (this.classLoader != null) {
            return this.classLoader;
        }

        // Otherwise setup a new ClassLoader that includes all classes*.dex files of the APK-file

        Enumeration<? extends ZipEntry> entries = this.zipFile.entries();
        MultiClassLoader parent = new MultiClassLoader();

        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();

            // Parse the name

            String fullPath = entry.getName();

            int lastSlash = fullPath.lastIndexOf('/');
            int lastDot = fullPath.lastIndexOf('.');

            if (lastDot < lastSlash) {
                continue;
            }

            String name = fullPath.substring(lastSlash + 1, lastDot);
            String extension = fullPath.substring(lastDot + 1);

            // Check, if the name matches "classes*.dex"

            if (!name.startsWith("classes") || !extension.equals("dex")) {
                continue;
            }

            // Create the class loader for the entry

            byte[] dexData = StreamUtil.readFully(this.zipFile.getInputStream(entry));
            DexClassPool classPool = new DexClassPool(dexData);
            Cache cache = EmptyCacheProvider.INSTANCE.getCache(dexData);

            parent.addChild(new CachedClassLoader(classPool, cache));
        }

        return (this.classLoader = parent);
    }
}
