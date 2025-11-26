package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class StorageStateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1341p.m4658b("onReceive : " + intent.getAction(), getClass().getSimpleName());
        if (intent.getAction() != null && intent.getAction().equals("android.intent.action.MEDIA_MOUNTED")) {
            C1341p.m4658b("ACTION_MEDIA_MOUNTED deleteFilesDirectory", getClass().getSimpleName());
            context.startService(new Intent(C0684a.f2333d));
        }
    }
}
