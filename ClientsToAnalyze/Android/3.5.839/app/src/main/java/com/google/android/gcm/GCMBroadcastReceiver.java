package com.google.android.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes.dex */
public class GCMBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static boolean f1634a = false;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Log.v("GCMBroadcastReceiver", "onReceive: " + intent.getAction());
        if (!f1634a) {
            f1634a = true;
            String name = getClass().getName();
            if (!name.equals(GCMBroadcastReceiver.class.getName())) {
                C0693a.m2217a(name);
            }
        }
        String strM2210a = m2210a(context);
        Log.v("GCMBroadcastReceiver", "GCM IntentService class: " + strM2210a);
        GCMBaseIntentService.m2200a(context, intent, strM2210a);
        setResult(-1, null, null);
    }

    /* renamed from: a */
    protected String m2210a(Context context) {
        return m2209b(context);
    }

    /* renamed from: b */
    static final String m2209b(Context context) {
        return context.getPackageName() + ".GCMIntentService";
    }
}
