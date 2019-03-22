package org.fir3.avm.cli;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import lombok.extern.java.Log;
import org.fir3.avm.cli.launcher.Launcher;
import org.fir3.avm.cli.launcher.Settings;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

@Log
public class App {
    public static void main(String[] args) {
        // Load the i18n bundle for the current locale

        ResourceBundle i18n = ResourceBundle.getBundle("i18n/cli");

        // Setup of the command line arguments parser

        OptionParser parser = new OptionParser();

        OptionSpec<Void> optHelp = parser.acceptsAll(Arrays.asList("help", "h"),
                i18n.getString("args.option.help")).forHelp();

        OptionSpec<String> optActivity = parser.acceptsAll(Collections.singletonList("activity"),
                i18n.getString("args.option.activity")).withRequiredArg();

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

        String application = null;

        if (options.has(optApplication)) {
            application = optApplication.value(options);
        }

        // Launch the application with the specified settings

        Settings settings = new Settings();
        settings.setApkFile(optApkFiles.value(options));
        settings.setApplicationClassName(application);
        settings.setActivityClassName(launcherActivity);

        if (!Launcher.launch(settings)) {
            System.exit(1);
        }
    }
}
