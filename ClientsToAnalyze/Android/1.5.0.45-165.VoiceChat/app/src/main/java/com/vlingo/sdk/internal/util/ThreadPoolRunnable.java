package com.vlingo.sdk.internal.util;

/* loaded from: classes.dex */
public interface ThreadPoolRunnable extends Runnable {
    boolean isHighPriority();

    boolean isOrdered();

    boolean isRetry();
}
