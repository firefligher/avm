package org.fir3.avm.cli.launcher;

import lombok.Data;

import java.io.File;

@Data
public class Settings {
    private File apkFile;
    private String applicationClassName;
    private String activityClassName;
}
