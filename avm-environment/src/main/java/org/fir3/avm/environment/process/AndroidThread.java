package org.fir3.avm.environment.process;

import lombok.Getter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class AndroidThread extends Thread implements Executor {
    public enum Type {
        Main,
        Worker
    }

    @Getter
    private final Type type;
    private final BlockingQueue<Runnable> queuedTasks;

    @Getter
    private boolean terminated;

    AndroidThread(ThreadGroup group, Type type) {
        super(group, type.name());

        this.queuedTasks = new LinkedBlockingQueue<>();
        this.type = type;
    }

    @Override
    public void execute(Runnable runnable) {
        this.queuedTasks.add(runnable);
    }

    @Override
    public void run() {
        while (!this.terminated) {
            Runnable task;

            try {
                task = this.queuedTasks.take();
            } catch (InterruptedException ex) {
                continue;
            }

            task.run();
        }
    }

    public void terminate() throws InterruptedException {
        if (!this.terminated) {
            this.terminated = true;
            this.interrupt();
        }

        this.join();
    }
}
