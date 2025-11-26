package org.jboss.netty.logging;

/* loaded from: classes.dex */
public abstract class AbstractInternalLogger implements InternalLogger {
    protected AbstractInternalLogger() {
    }

    @Override // org.jboss.netty.logging.InternalLogger
    public boolean isEnabled(InternalLogLevel internalLogLevel) {
        switch (internalLogLevel) {
            case DEBUG:
                return isDebugEnabled();
            case INFO:
                return isInfoEnabled();
            case WARN:
                return isWarnEnabled();
            case ERROR:
                return isErrorEnabled();
            default:
                throw new Error();
        }
    }

    @Override // org.jboss.netty.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel, String str, Throwable th) {
        switch (internalLogLevel) {
            case DEBUG:
                debug(str, th);
                return;
            case INFO:
                info(str, th);
                return;
            case WARN:
                warn(str, th);
                return;
            case ERROR:
                error(str, th);
                return;
            default:
                throw new Error();
        }
    }

    @Override // org.jboss.netty.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel, String str) {
        switch (internalLogLevel) {
            case DEBUG:
                debug(str);
                return;
            case INFO:
                info(str);
                return;
            case WARN:
                warn(str);
                return;
            case ERROR:
                error(str);
                return;
            default:
                throw new Error();
        }
    }
}
