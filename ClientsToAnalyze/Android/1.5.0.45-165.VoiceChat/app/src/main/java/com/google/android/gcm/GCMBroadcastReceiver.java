package com.google.android.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes.dex */
public class GCMBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "GCMBroadcastReceiver";

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Log.v(TAG, "onReceive: " + intent.getAction());
        String className = getGCMIntentServiceClassName(context);
        Log.v(TAG, "GCM IntentService class: " + className);
        GCMBaseIntentService.runIntentInService(context, intent, className);
        setResult(-1, null, null);
    }

    protected String getGCMIntentServiceClassName(Context context) {
        String className = context.getPackageName() + GCMConstants.DEFAULT_INTENT_SERVICE_CLASS_NAME;
        return className;
    }
}
