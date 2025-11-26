package org.jboss.netty.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
class JdkLogger extends AbstractInternalLogger {
    private final Logger logger;
    private final String loggerName;

    JdkLogger(Logger logger, String str) {
        this.logger = logger;
        this.loggerName = str;
    }

    @Override // org.jboss.netty.logging.InternalLogger
    public void debug(String str) {
        this.logger.logp(Level.FINE, this.loggerName, (String) null, str);
    }

    @Override // org.jboss.netty.logging.InternalLogger
    public void debug(String str, Throwable th) {
        this.logger.logp(Level.FINE, this.loggerName, (String) null, str, th);
    }

    @Override // org.jboss.netty.logging.InternalLogger
    public void info(String str) {
        this.logger.logp(Level.INFO, this.loggerName, (String) null, str);
    }

    @Override // org.jboss.netty.logging.InternalLogger
    public void warn(String str) {
        this.logger.logp(Level.WARNING, this.loggerName, (String) null, str);
    }

    @Override // org.jboss.netty.logging.InternalLogger
    public void warn(String str, Throwable th) {
        this.logger.logp(Level.WARNING, this.loggerName, (String) null, str, th);
    }

    public String toString() {
        return this.loggerName;
    }
}
