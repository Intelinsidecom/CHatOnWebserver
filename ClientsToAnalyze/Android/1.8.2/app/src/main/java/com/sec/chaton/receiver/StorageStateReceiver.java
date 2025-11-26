package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class StorageStateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1786r.m6061b("onReceive : " + intent.getAction(), getClass().getSimpleName());
        if (intent.getAction() != null && intent.getAction().equals("android.intent.action.MEDIA_MOUNTED")) {
            C1786r.m6061b("ACTION_MEDIA_MOUNTED deleteFilesDirectory", getClass().getSimpleName());
            context.startService(new Intent(C0452a.f1725d));
        }
    }
}
