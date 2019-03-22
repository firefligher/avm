package org.fir3.avm.environment;

import lombok.Getter;
import org.fir3.avm.environment.resource.io.ResourceInputStream;
import org.fir3.avm.environment.resource.manifest.AndroidManifest;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public class AppContainer {
    @Getter
    private final ApkAccess apkAccess;

    private AndroidManifest cachedManifest;

    public AppContainer(File apkFile) throws IOException {
        this.apkAccess = new ApkAccess(apkFile);
    }

    public AndroidManifest getManifest() throws IOException {
        // Load the manifest, if it has not been cached yet

        if (this.cachedManifest == null) {
            try (ResourceInputStream src = new ResourceInputStream(this.apkAccess.getInputStream(
                    ApkAccess.PATH_ANDROID_MANIFEST))) {
                this.cachedManifest = AndroidManifest.deserialize(src.readChunk().getDocument());
            } catch (JAXBException ex) {
                throw new IOException(ex);
            }
        }

        return this.cachedManifest;
    }
}
