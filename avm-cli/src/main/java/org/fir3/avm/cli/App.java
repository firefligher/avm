package org.fir3.avm.cli;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import lombok.extern.java.Log;
import org.fir3.avm.environment.AppContainer;
import org.fir3.avm.environment.resource.io.ResourceInputStream;
import org.fir3.avm.environment.resource.manifest.AndroidManifest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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

        // Setup of the AppContainer

        AppContainer container;

        try {
            container = new AppContainer(optApkFiles.value(options));

            /*
            try (ResourceInputStream stream = new ResourceInputStream(container.getApkAccess().getInputStream("resources.arsc"))) {
                System.out.println(stream.readChunk().getTable());
            }
            */

            try (ResourceInputStream stream = new ResourceInputStream(container.getApkAccess().getInputStream("AndroidManifest.xml"))) {
                /*DOMSource source = new DOMSource(stream.readChunk().getDocument());

                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                transformer.transform(source, new StreamResult(System.out));*/

                System.out.println(AndroidManifest.deserialize(stream.readChunk().getDocument()));
            }
        } catch (IOException ex) {
            log.log(Level.SEVERE, "Cannot create AppContainer!", ex);
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
