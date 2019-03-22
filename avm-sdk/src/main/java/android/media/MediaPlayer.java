package android.media;

public class MediaPlayer implements VolumeAutomation, AudioRouting {
    public interface OnCompletionListener {
        void onCompletion(MediaPlayer mp);
    }

    public interface OnErrorListener {
        boolean onError(MediaPlayer mp, int what, int extra);
    }

    public interface OnPreparedListener {
        void onPrepare(MediaPlayer mp);
    }
}
