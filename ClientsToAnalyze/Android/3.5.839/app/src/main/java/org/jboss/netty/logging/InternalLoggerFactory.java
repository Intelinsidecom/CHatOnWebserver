package org.jboss.netty.logging;

import org.jboss.netty.util.internal.StackTraceSimplifier;

/* loaded from: classes.dex */
public abstract class InternalLoggerFactory {
    private static volatile InternalLoggerFactory defaultFactory = new JdkLoggerFactory();

    public abstract InternalLogger newInstance(String str);

    static {
        StackTraceSimplifier.simplify(new Exception());
    }

    public static InternalLoggerFactory getDefaultFactory() {
        return defaultFactory;
    }

    public static InternalLogger getInstance(Class<?> cls) {
        return getInstance(cls.getName());
    }

    public static InternalLogger getInstance(String str) {
        final InternalLogger internalLoggerNewInstance = getDefaultFactory().newInstance(str);
        return new InternalLogger() { // from class: org.jboss.netty.logging.InternalLoggerFactory.1
            @Override // org.jboss.netty.logging.InternalLogger
            public void debug(String str2) {
                internalLoggerNewInstance.debug(str2);
            }

            @Override // org.jboss.netty.logging.InternalLogger
            public void debug(String str2, Throwable th) {
                StackTraceSimplifier.simplify(th);
                internalLoggerNewInstance.debug(str2, th);
            }

            @Override // org.jboss.netty.logging.InternalLogger
            public void info(String str2) {
                internalLoggerNewInstance.info(str2);
            }

            @Override // org.jboss.netty.logging.InternalLogger
            public void warn(String str2) {
                internalLoggerNewInstance.warn(str2);
            }

            @Override // org.jboss.netty.logging.InternalLogger
            public void warn(String str2, Throwable th) {
                StackTraceSimplifier.simplify(th);
                internalLoggerNewInstance.warn(str2, th);
            }
        };
    }
}
