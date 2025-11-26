package twitter4j.internal.logging;

/* loaded from: classes.dex */
final class NullLogger extends Logger {
    NullLogger() {
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isDebugEnabled() {
        return false;
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isInfoEnabled() {
        return false;
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isWarnEnabled() {
        return false;
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isErrorEnabled() {
        return false;
    }

    @Override // twitter4j.internal.logging.Logger
    public void debug(String str) {
    }

    @Override // twitter4j.internal.logging.Logger
    public void debug(String str, String str2) {
    }

    @Override // twitter4j.internal.logging.Logger
    public void info(String str) {
    }

    @Override // twitter4j.internal.logging.Logger
    public void info(String str, String str2) {
    }

    @Override // twitter4j.internal.logging.Logger
    public void warn(String str) {
    }

    @Override // twitter4j.internal.logging.Logger
    public void warn(String str, String str2) {
    }

    @Override // twitter4j.internal.logging.Logger
    public void error(String str) {
    }

    @Override // twitter4j.internal.logging.Logger
    public void error(String str, Throwable th) {
    }
}
