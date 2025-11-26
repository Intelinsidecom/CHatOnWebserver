package org.jboss.netty.util;

/* loaded from: classes.dex */
public interface Timeout {
    void cancel();

    TimerTask getTask();

    Timer getTimer();

    boolean isCancelled();

    boolean isExpired();
}
