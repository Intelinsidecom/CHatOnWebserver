package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class MessageNotificationReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private String f11515a = "MessageNotificationReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C4904y.f17873c) {
            C4904y.m18641c("***ChatON Received BOOT_COMPELETED***", this.f11515a);
        }
        if (C4809aa.m18104a().m18129b("uid") && C1813b.m8906b().m8943h()) {
            C1813b.m8906b().m8934b(C1813b.f6835d);
        }
    }
}
