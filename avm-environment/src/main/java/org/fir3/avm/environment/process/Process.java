package org.fir3.avm.environment.process;

import android.app.Activity;
import android.app.Application;
import lombok.Getter;
import lombok.extern.java.Log;
import org.fir3.avm.environment.AppContainer;

import java.util.logging.Level;

@Log
public class Process {
    @Getter
    private final AppContainer app;
    private final ThreadManager threads;

    private boolean launched;

    public Process(AppContainer app) {
        this.app = app;
        this.threads = new ThreadManager();
    }

    public void launch(final Class<Application> application, final Class<Activity> activity) {
        // Ensure that this process instance is only launched once.

        if (this.launched) {
            log.warning("Tried to launch a process that has been launched already!");
            return;
        }

        this.launched = true;

        // Start the main thread and switch into that thread's context.

        this.threads.getMainThread().execute(new Runnable() {
            @Override
            public void run() {
                Process.this.launchNow(application, activity);
            }
        });
    }

    private void launchNow(Class<Application> applicationClass, Class<Activity> activityClass) {
        // Instantiate the application class

        Application application;

        try {
            application = applicationClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.log(Level.SEVERE, "Cannot instantiate the application class", e);
            return;
        }

        // Call the onCreate method of the application to initialize its resources

        application.onCreate();
    }
}
