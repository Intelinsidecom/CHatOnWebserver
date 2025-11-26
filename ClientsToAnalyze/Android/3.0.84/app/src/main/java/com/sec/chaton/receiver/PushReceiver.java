package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.sec.chaton.chat.InterfaceC1091ff;
import com.sec.chaton.chat.background.ChatBackgroundService;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1423n;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.p037j.C1596x;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class PushReceiver extends BroadcastReceiver {

    /* renamed from: e */
    private static InterfaceC1091ff f8065e;

    /* renamed from: a */
    C1379w f8066a;

    /* renamed from: b */
    InterfaceC1413d f8067b = new C2120a(this);

    /* renamed from: c */
    private Context f8068c;

    /* renamed from: d */
    private PowerManager.WakeLock f8069d;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f8068c = context;
        if (intent.getAction().equals(Config.WIFI_PORT_CHANGE_NOTI_ACTION)) {
            if (C3250y.f11734b) {
                C3250y.m11450b("[received SPP WIFI_PORT_CHANGE_BR]", "NotificationReceiver");
            }
            if (C1493a.m6463a("wifi_80_port")) {
                C1596x.m6758c();
                C3159aa.m10962a().m10984b(Config.PROVIDER_PATH_WIFI_PORT, Integer.valueOf(C3194bi.f11542b));
                return;
            }
            return;
        }
        if (this.f8069d == null) {
            this.f8069d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "ChatON");
            this.f8069d.acquire();
        }
        String stringExtra = intent.getStringExtra(Config.NOTIFICATION_INTENT_NOTIID);
        String stringExtra2 = intent.getStringExtra(Config.NOTIFICATION_INTENT_MSG);
        boolean booleanExtra = intent.getBooleanExtra(Config.NOTIFICATION_INTENT_ACK, false);
        String stringExtra3 = intent.getStringExtra(Config.NOTIFICATION_INTENT_SENDER);
        String stringExtra4 = intent.getStringExtra(Config.NOTIFICATION_INTENT_APP_DATA);
        C3250y.m11453c("Push Received : Sender = " + stringExtra3 + ", appData : , notiId: " + stringExtra, getClass().getSimpleName());
        if (C3159aa.m10962a().m10987b("uid")) {
            Intent intent2 = new Intent(GlobalApplication.m11493l(), (Class<?>) ChatBackgroundService.class);
            intent2.putExtra("request", intent.getExtras());
            GlobalApplication.m11493l().startService(intent2);
            this.f8066a = new C1379w();
            C1379w.m6203a(this.f8066a, -1, new C1423n(this.f8067b, stringExtra, booleanExtra, stringExtra3, stringExtra2, stringExtra4));
        }
    }

    /* renamed from: a */
    public static void m8377a(InterfaceC1091ff interfaceC1091ff) {
        f8065e = interfaceC1091ff;
    }
}
