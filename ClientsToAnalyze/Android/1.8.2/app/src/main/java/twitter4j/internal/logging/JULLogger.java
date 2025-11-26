package twitter4j.internal.logging;

import java.util.logging.Level;

/* loaded from: classes.dex */
final class JULLogger extends Logger {
    private final java.util.logging.Logger LOGGER;

    JULLogger(java.util.logging.Logger logger) {
        this.LOGGER = logger;
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isDebugEnabled() {
        return this.LOGGER.isLoggable(Level.FINE);
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isInfoEnabled() {
        return this.LOGGER.isLoggable(Level.INFO);
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isWarnEnabled() {
        return this.LOGGER.isLoggable(Level.WARNING);
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isErrorEnabled() {
        return this.LOGGER.isLoggable(Level.SEVERE);
    }

    @Override // twitter4j.internal.logging.Logger
    public void debug(String str) {
        this.LOGGER.fine(str);
    }

    @Override // twitter4j.internal.logging.Logger
    public void debug(String str, String str2) {
        this.LOGGER.fine(new StringBuffer().append(str).append(str2).toString());
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
        this.LOGGER.warning(str);
    }

    @Override // twitter4j.internal.logging.Logger
    public void warn(String str, String str2) {
        this.LOGGER.warning(new StringBuffer().append(str).append(str2).toString());
    }

    @Override // twitter4j.internal.logging.Logger
    public void error(String str) {
        this.LOGGER.severe(str);
    }

    @Override // twitter4j.internal.logging.Logger
    public void error(String str, Throwable th) {
        this.LOGGER.severe(new StringBuffer().append(str).append(th.getMessage()).toString());
    }
}
