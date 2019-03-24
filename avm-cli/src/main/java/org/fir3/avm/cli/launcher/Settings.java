package org.fir3.avm.cli.launcher;

import lombok.Data;
import org.fir3.avm.environment.classloader.cache.CacheProvider;

import java.io.File;

@Data
public class Settings {
    private File apkFile;
    private String applicationClassName;
    private String activityClassName;
    private CacheProvider cacheProvider;
}
