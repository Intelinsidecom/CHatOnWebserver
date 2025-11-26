package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.sec.chaton.chat.InterfaceC0495bi;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0684k;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class PushReceiver extends BroadcastReceiver {

    /* renamed from: d */
    private static PowerManager.WakeLock f4152d;

    /* renamed from: e */
    private static InterfaceC0495bi f4153e;

    /* renamed from: a */
    C0668l f4154a;

    /* renamed from: b */
    InterfaceC0677d f4155b = new C1144a(this);

    /* renamed from: c */
    private Context f4156c;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f4156c = context;
        if (f4152d == null) {
            f4152d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "ChatON");
        }
        String stringExtra = intent.getStringExtra(Config.NOTIFICATION_INTENT_NOTIID);
        String stringExtra2 = intent.getStringExtra(Config.NOTIFICATION_INTENT_MSG);
        boolean booleanExtra = intent.getBooleanExtra(Config.NOTIFICATION_INTENT_ACK, false);
        String stringExtra3 = intent.getStringExtra(Config.NOTIFICATION_INTENT_SENDER);
        String stringExtra4 = intent.getStringExtra(Config.NOTIFICATION_INTENT_APP_DATA);
        C1786r.m6063c("Push Received : Sender = " + stringExtra3 + ", appData : " + stringExtra4 + ", notiId: " + stringExtra, getClass().getSimpleName());
        if (C1789u.m6075a().contains("uid")) {
            this.f4154a = new C0668l();
            C0668l.m3077a(this.f4154a, -1, new C0684k(this.f4155b, stringExtra, booleanExtra, stringExtra3, stringExtra2, stringExtra4));
        }
    }

    /* renamed from: a */
    public static void m4324a(InterfaceC0495bi interfaceC0495bi) {
        f4153e = interfaceC0495bi;
    }
}
