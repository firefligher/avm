package android.os;

import java.io.FileDescriptor;
import lombok.extern.java.Log;

@Log
public final class MessageQueue {
    public interface IdleHandler {
        boolean queueIdle();
    }
    
    public interface OnFileDescriptorEventListener {
        int EVENT_INPUT = 0x00000001;
        int EVENT_OUTPUT = 0x00000002;
        int EVENT_ERROR = 0x00000004;
        
        int onFileDescriptorEvents(FileDescriptor fd, int events);
    }
    
    public void addIdleHandler(IdleHandler handler) {
        log.warning("Unimplemented method: android.os.MessageQueue.addIdleHandler("
                + "android.os.MessageQueue.IdleHandler)");
    }
    
    public void addOnFileDescriptorEventListener(FileDescriptor fd, int events,
            OnFileDescriptorEventListener listener) {
        log.warning("Unimplemented method: android.os.MessageQueue.addOnFileDescriptorEventListener("
                + "java.io.FileDescriptor, int, android.os.MessageQueue.OnFileDescriptorEventListener)");
    }
    
    public boolean isIdle() {
        log.warning("Unimplemented method: android.os.MessageQueue.isIdle()");
        return false;
    }
    
    public void removeIdleHandler(IdleHandler handler) {
        log.warning("Unimplemented method: android.os.MessageQueue.removeIdleHandler("
                + "android.os.MessageQueue.IdleHandler)");
    }
    
    public void removeOnFileDescriptorEventListener(FileDescriptor fd) {
        log.warning("Unimplemented method: android.os.MessageQueue.removeOnFileDescriptorEventListener("
                + "java.io.FileDescriptor)");
    }
}
