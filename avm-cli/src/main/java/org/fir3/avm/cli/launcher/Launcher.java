package org.fir3.avm.cli.launcher;

import android.app.Activity;
import android.app.Application;
import lombok.extern.java.Log;
import org.fir3.avm.environment.AppContainer;
import org.fir3.avm.environment.process.Process;
import org.fir3.avm.environment.resource.manifest.AndroidManifest;

import java.io.IOException;
import java.util.logging.Level;

@Log
public class Launcher {
    public static boolean launch(Settings settings) {
        // Setup of the AppContainer

        AppContainer app;

        try {
            app = new AppContainer(settings.getApkFile());
        } catch (IOException ex) {
            log.log(Level.SEVERE, "Cannot create the AppContainer!", ex);
            return false;
        }

        // Initialize the required settings for the launch, if they have not been specified via the command line
        // interface yet

        Launcher.discoverMissingSettings(app, settings);

        // Resolve the actual classes of the launcher activity and the app's application class

        ClassLoader appClassLoader;

        try {
            appClassLoader = app.getApkAccess().getClassLoader();
        } catch (IOException ex) {
            log.log(Level.SEVERE, "Cannot access the classes of the launched app", ex);
            return false;
        }

        Class<Application> applicationClass;
        Class<Activity> launcherActivityClass;

        try {
            applicationClass = (Class<Application>) appClassLoader.loadClass(settings.getApplicationClassName());
            launcherActivityClass = (Class<Activity>) appClassLoader.loadClass(settings.getActivityClassName());
        } catch (ClassNotFoundException ex) {
            log.log(Level.SEVERE, "Cannot resolve the application and/or launcher activity classes", ex);
            return false;
        }

        // Spawn the new process

        new Process(app).launch(applicationClass, launcherActivityClass);
        return true;
    }

    private static void discoverMissingSettings(AppContainer app, Settings settings) {
        AndroidManifest manifest;

        try {
            manifest = app.getManifest();
        } catch (IOException ex) {
            log.log(Level.SEVERE, "Cannot read the AndroidManifest.xml", ex);
            return;
        }

        if (settings.getApplicationClassName() == null) {
            settings.setApplicationClassName(manifest.getApplication().getName());
        }

        // TODO: Find the launcher activity
    }
}
