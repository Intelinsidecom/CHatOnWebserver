package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p025d.p026a.C0627g;
import com.sec.chaton.p025d.p027b.C0648k;
import com.sec.chaton.p025d.p027b.InterfaceC0641d;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class PushReceiver extends BroadcastReceiver {

    /* renamed from: d */
    private static PowerManager.WakeLock f3130d;

    /* renamed from: e */
    private static ChatFragment f3131e;

    /* renamed from: a */
    C0627g f3132a;

    /* renamed from: b */
    InterfaceC0641d f3133b = new C0926a(this);

    /* renamed from: c */
    private Context f3134c;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f3134c = context;
        if (f3130d == null) {
            f3130d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "ChatON");
        }
        String stringExtra = intent.getStringExtra(Config.NOTIFICATION_INTENT_NOTIID);
        String stringExtra2 = intent.getStringExtra(Config.NOTIFICATION_INTENT_MSG);
        boolean booleanExtra = intent.getBooleanExtra(Config.NOTIFICATION_INTENT_ACK, false);
        String stringExtra3 = intent.getStringExtra(Config.NOTIFICATION_INTENT_SENDER);
        String stringExtra4 = intent.getStringExtra(Config.NOTIFICATION_INTENT_APP_DATA);
        C1341p.m4660c("Push Received : Sender = " + stringExtra3 + ", appData : " + stringExtra4 + ", notiId: " + stringExtra, getClass().getSimpleName());
        if (C1323bs.m4575a().contains("uid")) {
            this.f3132a = new C0627g();
            C0627g.m2858a(this.f3132a, -1, new C0648k(this.f3133b, stringExtra, booleanExtra, stringExtra3, stringExtra2, stringExtra4));
        }
    }

    /* renamed from: a */
    public static void m3651a(ChatFragment chatFragment) {
        f3131e = chatFragment;
    }
}
