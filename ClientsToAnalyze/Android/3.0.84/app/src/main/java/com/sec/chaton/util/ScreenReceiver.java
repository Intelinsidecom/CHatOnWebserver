package com.sec.chaton.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.util.Log;
import android.widget.Toast;

/* loaded from: classes.dex */
public class ScreenReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Debug.waitForDebugger();
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            Log.i("Check", "Screen went OFF");
            Toast.makeText(context, "screen OFF", 1).show();
        }
    }
}
