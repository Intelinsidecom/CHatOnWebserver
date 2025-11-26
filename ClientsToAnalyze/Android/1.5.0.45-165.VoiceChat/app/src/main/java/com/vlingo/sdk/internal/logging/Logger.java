package com.vlingo.sdk.internal.logging;

import android.util.Log;
import com.coolots.sso.util.ChatONVAPII;
import com.vlingo.sdk.internal.core.ApplicationAdapter;

/* loaded from: classes.dex */
public class Logger {
    private String m_ClassName;
    private boolean m_isEnabled;
    private String m_prefix;

    private Logger(String name, String prefix, boolean enabled) {
        this.m_isEnabled = true;
        int i = name.lastIndexOf(46);
        this.m_ClassName = name.substring(i + 1);
        this.m_prefix = prefix;
        this.m_isEnabled = enabled;
    }

    public static Logger getLogger(Class<?> class1) {
        return getLogger(class1, (String) null);
    }

    public static Logger getLogger(Class<?> class1, boolean enabled) {
        return getLogger(class1, null, true);
    }

    public static Logger getLogger(Class<?> class1, String prefix) {
        return getLogger(class1, prefix, true);
    }

    public static Logger getLogger(Class<?> class1, String prefix, boolean enabled) {
        if (class1 == null) {
            throw new NullPointerException();
        }
        if (prefix == null) {
            prefix = "VLGSDK_";
        }
        return new Logger(class1.getName(), prefix, enabled);
    }

    public void debug(String msg) {
        if (this.m_isEnabled) {
            Log.d(String.valueOf(this.m_ClassName) + ChatONVAPII.USERID_DELEMETER + getThread(), String.valueOf(this.m_prefix) + msg);
        }
    }

    public void warn(String msg) {
        if (this.m_isEnabled) {
            Log.w(String.valueOf(this.m_ClassName) + ChatONVAPII.USERID_DELEMETER + getThread(), String.valueOf(this.m_prefix) + msg);
        }
    }

    public void error(String tag, String code, String msg) {
        if (this.m_isEnabled) {
            ApplicationAdapter.getInstance().DEBUG_errorLog(code, msg);
            Log.e(String.valueOf(tag) + ChatONVAPII.USERID_DELEMETER + getThread(), String.valueOf(this.m_prefix) + msg);
        }
    }

    public void error(String code, String msg) {
        if (this.m_isEnabled) {
            ApplicationAdapter.getInstance().DEBUG_errorLog(code, msg);
            Log.e(String.valueOf(this.m_ClassName) + ChatONVAPII.USERID_DELEMETER + getThread(), String.valueOf(this.m_prefix) + msg);
        }
    }

    public void error(String msg) {
        if (this.m_isEnabled) {
            Log.e(String.valueOf(this.m_ClassName) + ChatONVAPII.USERID_DELEMETER + getThread(), String.valueOf(this.m_prefix) + msg);
        }
    }

    public void info(String msg) {
        if (this.m_isEnabled) {
            Log.i(String.valueOf(this.m_ClassName) + "-" + getThread(), String.valueOf(this.m_prefix) + msg);
        }
    }

    private String getThread() {
        return Thread.currentThread().getName();
    }
}
