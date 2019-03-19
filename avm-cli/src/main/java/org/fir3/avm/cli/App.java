package org.fir3.avm.cli;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import lombok.extern.java.Log;
import org.fir3.avm.environment.AppContainer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;

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

        // Setup of the AppContainer

        AppContainer container;

        try {
            container = new AppContainer(optApkFiles.value(options));

            container.getApkAccess().getClassLoader().loadClass(launcherActivity);
        } catch (IOException ex) {
            log.log(Level.SEVERE, "Cannot create AppContainer!", ex);
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
