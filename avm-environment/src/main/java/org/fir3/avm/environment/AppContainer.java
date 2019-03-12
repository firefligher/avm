package org.fir3.avm.environment;

import lombok.Getter;

import java.io.File;
import java.io.IOException;

public class AppContainer {
    @Getter
    private final ApkAccess apkAccess;

    public AppContainer(File apkFile) throws IOException {
        this.apkAccess = new ApkAccess(apkFile);
    }
}
