package com.vlingo.sdk.internal.util;

import java.util.TimerTask;

/* loaded from: classes.dex */
public class Future {
    private final Runnable run;
    private TimerTask scheduleTask;
    private Thread thread;
    private boolean complete = false;
    private boolean cancelled = false;
    private boolean alive = false;

    Future(Runnable run) {
        this.run = run;
    }

    Runnable getRunnable() {
        return this.run;
    }

    synchronized void setScheduleTask(TimerTask scheduleTask) {
        this.scheduleTask = scheduleTask;
    }

    synchronized void setThread(Thread t) {
        this.thread = t;
        this.alive = true;
    }

    public synchronized boolean isAlive() {
        return this.alive;
    }

    public synchronized void cancel() {
        if (!this.complete && !this.cancelled) {
            if (this.scheduleTask != null) {
                this.scheduleTask.cancel();
                this.scheduleTask = null;
            }
            if (this.thread != null && Thread.currentThread() != this.thread) {
                this.thread.interrupt();
            }
            this.cancelled = true;
        }
    }

    synchronized boolean isCancelled() {
        return this.cancelled;
    }

    synchronized void complete() {
        this.complete = true;
        this.alive = false;
        this.thread = null;
    }
}
