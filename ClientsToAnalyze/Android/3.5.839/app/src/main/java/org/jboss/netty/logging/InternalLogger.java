package org.jboss.netty.logging;

/* loaded from: classes.dex */
public interface InternalLogger {
    void debug(String str);

    void debug(String str, Throwable th);

    void info(String str);

    void warn(String str);

    void warn(String str, Throwable th);
}
