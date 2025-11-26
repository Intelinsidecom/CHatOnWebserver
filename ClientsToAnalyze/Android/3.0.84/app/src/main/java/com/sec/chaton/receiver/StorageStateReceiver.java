package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class StorageStateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("onReceive : " + intent.getAction(), getClass().getSimpleName());
        if (intent.getAction() != null && intent.getAction().equals("android.intent.action.MEDIA_MOUNTED")) {
            C3250y.m11450b("ACTION_MEDIA_MOUNTED deleteFilesDirectory", getClass().getSimpleName());
            context.startService(new Intent(C0816a.f3114c));
        }
    }
}
