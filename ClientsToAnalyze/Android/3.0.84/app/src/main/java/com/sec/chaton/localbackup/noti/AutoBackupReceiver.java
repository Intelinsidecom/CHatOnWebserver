package com.sec.chaton.localbackup.noti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* loaded from: classes.dex */
public class AutoBackupReceiver extends BroadcastReceiver {

    /* renamed from: a */
    Intent f6121a;

    /* renamed from: b */
    Context f6122b;

    /* renamed from: c */
    private Handler f6123c = new HandlerC1655c(this);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f6121a = intent;
        this.f6122b = context;
        new Thread(new RunnableC1654b(this)).start();
    }
}
