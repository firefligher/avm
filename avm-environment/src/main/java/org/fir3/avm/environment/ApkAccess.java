package org.fir3.avm.environment;

import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ApkAccess {
    @Getter
    private final File physicalFile;
    private final ZipFile zipFile;

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
}
