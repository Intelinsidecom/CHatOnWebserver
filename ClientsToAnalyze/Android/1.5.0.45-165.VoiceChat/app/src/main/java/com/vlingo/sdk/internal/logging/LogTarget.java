package com.vlingo.sdk.internal.logging;

/* loaded from: classes.dex */
public interface LogTarget {
    void close();

    void log(String str, boolean z);
}
