package twitter4j.internal.logging;

import org.apache.commons.logging.Log;

/* loaded from: classes.dex */
final class CommonsLoggingLogger extends Logger {
    private final Log LOGGER;

    CommonsLoggingLogger(Log log) {
        this.LOGGER = log;
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isDebugEnabled() {
        return this.LOGGER.isDebugEnabled();
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isInfoEnabled() {
        return this.LOGGER.isInfoEnabled();
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isWarnEnabled() {
        return this.LOGGER.isWarnEnabled();
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isErrorEnabled() {
        return this.LOGGER.isErrorEnabled();
    }

    @Override // twitter4j.internal.logging.Logger
    public void debug(String str) {
        this.LOGGER.debug(str);
    }

    @Override // twitter4j.internal.logging.Logger
    public void debug(String str, String str2) {
        this.LOGGER.debug(new StringBuffer().append(str).append(str2).toString());
    }

    @Override // twitter4j.internal.logging.Logger
    public void info(String str) {
        this.LOGGER.info(str);
    }

    @Override // twitter4j.internal.logging.Logger
    public void info(String str, String str2) {
        this.LOGGER.info(new StringBuffer().append(str).append(str2).toString());
    }

    @Override // twitter4j.internal.logging.Logger
    public void warn(String str) {
        this.LOGGER.warn(str);
    }

    @Override // twitter4j.internal.logging.Logger
    public void warn(String str, String str2) {
        this.LOGGER.warn(new StringBuffer().append(str).append(str2).toString());
    }

    @Override // twitter4j.internal.logging.Logger
    public void error(String str) {
        this.LOGGER.error(str);
    }

    @Override // twitter4j.internal.logging.Logger
    public void error(String str, Throwable th) {
        this.LOGGER.error(str, th);
    }
}
