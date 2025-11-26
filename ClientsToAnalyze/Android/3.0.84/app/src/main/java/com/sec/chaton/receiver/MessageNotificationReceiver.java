package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class MessageNotificationReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private String f8063a = "MessageNotificationReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C3250y.f11735c) {
            C3250y.m11453c("***ChatON Received BOOT_COMPELETED***", this.f8063a);
        }
        if (C3159aa.m10962a().m10987b("uid")) {
            C1103a.m5432a(context).m5461b(C1103a.f4442d);
        }
    }
}
