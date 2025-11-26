package twitter4j.internal.logging;

import java.util.Date;
import twitter4j.conf.ConfigurationContext;

/* loaded from: classes.dex */
final class StdOutLogger extends Logger {
    private static final boolean DEBUG = ConfigurationContext.getInstance().isDebugEnabled();

    StdOutLogger() {
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isDebugEnabled() {
        return DEBUG;
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isWarnEnabled() {
        return true;
    }

    @Override // twitter4j.internal.logging.Logger
    public boolean isErrorEnabled() {
        return true;
    }

    @Override // twitter4j.internal.logging.Logger
    public void debug(String str) {
        if (DEBUG) {
            System.out.println(new StringBuffer().append("[").append(new Date()).append("]").append(str).toString());
        }
    }

    @Override // twitter4j.internal.logging.Logger
    public void debug(String str, String str2) {
        if (DEBUG) {
            debug(new StringBuffer().append(str).append(str2).toString());
        }
    }

    @Override // twitter4j.internal.logging.Logger
    public void info(String str) {
        System.out.println(new StringBuffer().append("[").append(new Date()).append("]").append(str).toString());
    }

    @Override // twitter4j.internal.logging.Logger
    public void info(String str, String str2) {
        info(new StringBuffer().append(str).append(str2).toString());
    }

    @Override // twitter4j.internal.logging.Logger
    public void warn(String str) {
        System.out.println(new StringBuffer().append("[").append(new Date()).append("]").append(str).toString());
    }

    @Override // twitter4j.internal.logging.Logger
    public void warn(String str, String str2) {
        warn(new StringBuffer().append(str).append(str2).toString());
    }

    @Override // twitter4j.internal.logging.Logger
    public void error(String str) {
        System.out.println(new StringBuffer().append("[").append(new Date()).append("]").append(str).toString());
    }

    @Override // twitter4j.internal.logging.Logger
    public void error(String str, Throwable th) {
        System.out.println(str);
        th.printStackTrace(System.err);
    }
}
