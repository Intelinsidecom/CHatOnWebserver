package com.sec.chaton.localbackup.noti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class AutoBackupReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null && intent.getAction().equals("auto_alaram_backup")) {
            if (C4904y.f17875e) {
                C4904y.m18634a("autobackup request recieved : " + System.currentTimeMillis(), AutoBackupReceiver.class.getSimpleName());
            }
            context.startService(new Intent(context, (Class<?>) AutoBackupService.class));
        }
    }
}
