package org.fir3.avm.cli;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import lombok.extern.java.Log;
import org.fir3.avm.cli.launcher.Launcher;
import org.fir3.avm.cli.launcher.Settings;
import org.fir3.avm.environment.classloader.cache.CacheProvider;
import org.fir3.avm.environment.classloader.cache.DefaultCacheProvider;
import org.fir3.avm.environment.classloader.cache.EmptyCacheProvider;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;

@Log
public class App {
    private static final long DEFAULT_CACHE_SIZE = 104857600; // 100 MiB
    private static final File DEFAULT_CACHE_PATH = new File(System.getProperty("user.home"), ".avm/class_cache");

    public static void main(String[] args) {
        // Load the i18n bundle for the current locale

        ResourceBundle i18n = ResourceBundle.getBundle("i18n/cli");

        // Setup of the command line arguments parser

        OptionParser parser = new OptionParser();

        OptionSpec<Void> optHelp = parser.acceptsAll(Arrays.asList("help", "h"),
                i18n.getString("args.option.help")).forHelp();

        OptionSpec<String> optActivity = parser.accepts("activity", i18n.getString("args.option.activity"))
                .withRequiredArg();

        OptionSpec<Boolean> optCache = parser.accepts("cache", i18n.getString("args.option.cache"))
                .withOptionalArg()
                .ofType(boolean.class)
                .defaultsTo(true);

        OptionSpec<Long> optCacheSize = parser.accepts("cache-size", i18n.getString("args.option.cacheSize"))
                .withRequiredArg()
                .ofType(long.class);

        OptionSpec<File> optCacheDirectory = parser.acceptsAll(Arrays.asList("cache-directory", "cache-dir"),
                i18n.getString("args.option.cacheDirectory"))
                .withRequiredArg()
                .ofType(File.class);

        OptionSpec<String> optApplication = parser.acceptsAll(Collections.singletonList("application"),
                i18n.getString("args.option.application")).withRequiredArg();

        OptionSpec<File> optApkFiles = parser.nonOptions(i18n.getString("args.option.nonOptions"))
                .ofType(File.class);

        // Validating the command line parameters

        OptionSet options = parser.parse(args);

        if (options.has(optHelp)) {
            try {
                parser.printHelpOn(System.err);
            } catch (IOException ignored) {
                // Ignoring this exception silently because we cannot do anything against it.
            }

            return;
        }

        if (!options.hasArgument(optApkFiles)) {
            log.severe("No APK specified, aborting.");
            System.exit(1);
            return;
        }

        String launcherActivity = null;

        if (options.has(optActivity)) {
            launcherActivity = optActivity.value(options);
        }

        boolean cacheEnabled = false;
        long cacheSize = App.DEFAULT_CACHE_SIZE;
        File cacheDir = App.DEFAULT_CACHE_PATH;

        if (options.has(optCache)) {
            cacheEnabled = optCache.value(options);

            if (options.has(optCacheSize)) {
                cacheSize = optCacheSize.value(options);
            }

            if (options.has(optCacheDirectory)) {
                cacheDir = optCacheDirectory.value(options);
            }
        }

        String application = null;

        if (options.has(optApplication)) {
            application = optApplication.value(options);
        }

        // Prepare the Settings instance

        Settings settings = new Settings();
        settings.setApkFile(optApkFiles.value(options));
        settings.setApplicationClassName(application);
        settings.setActivityClassName(launcherActivity);

        CacheProvider cacheProvider = EmptyCacheProvider.INSTANCE;

        try {
            if (cacheEnabled) {
                cacheProvider = new DefaultCacheProvider(cacheDir, cacheSize);
            }
        } catch (IOException ex) {
            log.log(Level.WARNING, "Cannot initialize the DefaultCacheProvider", ex);
        }

        settings.setCacheProvider(cacheProvider);

        // Launch the app with the specified settings

        if (!Launcher.launch(settings)) {
            System.exit(1);
        }
    }
}
