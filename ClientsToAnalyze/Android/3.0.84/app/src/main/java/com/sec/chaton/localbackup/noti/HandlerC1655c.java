package com.sec.chaton.localbackup.noti;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.util.C3159aa;

/* compiled from: AutoBackupReceiver.java */
/* renamed from: com.sec.chaton.localbackup.noti.c */
/* loaded from: classes.dex */
class HandlerC1655c extends Handler {

    /* renamed from: a */
    final /* synthetic */ AutoBackupReceiver f6126a;

    HandlerC1655c(AutoBackupReceiver autoBackupReceiver) {
        this.f6126a = autoBackupReceiver;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                C3159aa.m10962a().m10982a("auto_backup_start", Long.valueOf(System.currentTimeMillis()));
                C1653a.m6926a(this.f6126a.f6122b, false);
                break;
        }
    }
}
