package com.vlingo.sdk.internal.core;

import android.content.Context;
import com.vlingo.sdk.internal.recognizer.SRServerDetails;

/* loaded from: classes.dex */
public class ApplicationAdapter {
    protected static ApplicationAdapter instance = null;
    Context context = null;

    public Context getApplicationContext() {
        return this.context;
    }

    public static ApplicationAdapter getInstance() {
        if (instance == null) {
            instance = new ApplicationAdapter();
        }
        return instance;
    }

    public static void destroy() {
        instance = null;
    }

    public void init(Context context) {
        this.context = context;
    }

    public boolean isAudioStreamingEnabled() {
        return true;
    }

    public void DEBUG_errorLog(String errorCode, String errorMessage) {
    }

    public String getConnectionTestFieldID() {
        return null;
    }

    public SRServerDetails getConnectionTestServerDetails() {
        return null;
    }

    public void showFatalDialog(String message) {
    }
}
