package android.content;

public interface ComponentCallbacks2 extends ComponentCallbacks {
    int TRIM_MEMORY_BACKGROUND          = 0x00000028;
    int TRIM_MEMORY_COMPLETE            = 0x00000050;
    int TRIM_MEMORY_MODERATE            = 0x0000003c;
    int TRIM_MEMORY_RUNNING_CRITICAL    = 0x0000000f;
    int TRIM_MEMORY_RUNNING_LOW         = 0x0000000a;
    int TRIM_MEMORY_RUNNING_MODERATE    = 0x00000005;
    int TRIM_MEMORY_UI_HIDDEN           = 0x00000014;

    void onTrimMemory(int level);
}
