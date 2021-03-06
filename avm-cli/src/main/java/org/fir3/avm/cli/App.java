package org.fir3.avm.cli;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import lombok.extern.java.Log;
import org.fir3.avm.environment.AppContainer;
import org.fir3.avm.environment.classloader.cache.DefaultCacheProvider;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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
            return;
        }

        String launcherActivity = null;

        // TODO: Get the launcher activity from the AndroidManifest.xml

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

        // Setup of the AppContainer

        AppContainer container;

        try {
            container = new AppContainer(optApkFiles.value(options));
            ClassLoader loader;

            if (cacheEnabled) {
                loader = container.getApkAccess().getClassLoader(new DefaultCacheProvider(cacheDir, cacheSize));
            } else {
                loader = container.getApkAccess().getClassLoader();
            }

            loader.loadClass(launcherActivity);
        } catch (IOException ex) {
            log.log(Level.SEVERE, "Cannot create AppContainer!", ex);
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
