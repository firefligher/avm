package android.media;

import android.content.ServiceConnection;
import android.net.Uri;

public class MediaScannerConnection implements ServiceConnection {
    public interface MediaScannerConnectionClient extends MediaScannerConnection.OnScanCompletedListener {
        void onMediaScannerConnected();
        void onScanCompleted(String path, Uri uri);
    }

    public interface OnScanCompletedListener {
        void onScanCompleted(String path, Uri uri);
    }
}
