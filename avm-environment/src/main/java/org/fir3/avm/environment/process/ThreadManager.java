package org.fir3.avm.environment.process;

class ThreadManager {
    private static final String THREAD_GROUP_NAME = "AndroidProcess";

    private final ThreadGroup threadGroup;
    private AndroidThread mainThread;

    ThreadManager() {
        this.threadGroup = new ThreadGroup(ThreadManager.THREAD_GROUP_NAME);
    }

    synchronized AndroidThread getMainThread() {
        if (this.mainThread == null) {
            this.mainThread = new AndroidThread(this.threadGroup, AndroidThread.Type.Main);
            this.mainThread.start();
        }

        return this.mainThread;
    }
}
