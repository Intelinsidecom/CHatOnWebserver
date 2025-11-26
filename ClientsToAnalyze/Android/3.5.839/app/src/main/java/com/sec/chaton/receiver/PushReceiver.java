package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.sec.chaton.chat.InterfaceC1762hh;
import com.sec.chaton.chat.background.ChatBackgroundService;
import com.sec.chaton.chat.notification.FeedNotificationService;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2253n;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.p067j.C2417af;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PushReceiver extends BroadcastReceiver {

    /* renamed from: e */
    private static InterfaceC1762hh f11518e;

    /* renamed from: a */
    C2212z f11519a;

    /* renamed from: b */
    InterfaceC2243d f11520b = new C3130a(this);

    /* renamed from: c */
    private Context f11521c;

    /* renamed from: d */
    private PowerManager.WakeLock f11522d;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && intent.getAction() != null) {
            this.f11521c = context;
            if (intent.getAction().equals(Config.WIFI_PORT_CHANGE_NOTI_ACTION)) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("[received SPP WIFI_PORT_CHANGE_BR]", "NotificationReceiver");
                }
                if (C2349a.m10301a("wifi_80_port")) {
                    C2417af.m10456c();
                    C4809aa.m18104a().m18126b(Config.PROVIDER_PATH_WIFI_PORT, Integer.valueOf(C4844bi.f17657b));
                    return;
                }
                return;
            }
            if (this.f11522d == null) {
                this.f11522d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "ChatON");
                this.f11522d.acquire();
            }
            String stringExtra = intent.getStringExtra(Config.NOTIFICATION_INTENT_NOTIID);
            String stringExtra2 = intent.getStringExtra(Config.NOTIFICATION_INTENT_MSG);
            boolean booleanExtra = intent.getBooleanExtra(Config.NOTIFICATION_INTENT_ACK, false);
            String stringExtra3 = intent.getStringExtra(Config.NOTIFICATION_INTENT_SENDER);
            String stringExtra4 = intent.getStringExtra(Config.NOTIFICATION_INTENT_APP_DATA);
            if (stringExtra.equals("gcm_noti_id")) {
                C4904y.m18641c("Push Received(GCM) : Sender = " + stringExtra3, getClass().getSimpleName());
            } else {
                C4904y.m18641c("Push Received(SPP) : Sender = " + stringExtra3 + ", notiId: " + stringExtra, getClass().getSimpleName());
            }
            if (!C4809aa.m18104a().m18129b("uid")) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Not registerd. Push never send messages in this case.", getClass().getSimpleName());
                }
                if (booleanExtra) {
                    C2093az.m9337a().mo9078a(stringExtra);
                    C4904y.m18641c("push.notiAck( ) - NotiID: " + stringExtra, getClass().getSimpleName());
                }
                if (this.f11522d != null) {
                    this.f11522d.release();
                    return;
                }
                return;
            }
            try {
                if (new JSONObject(stringExtra4).getString(FeedNotificationService.f6707a) != null) {
                    Intent intent2 = new Intent(CommonApplication.m18732r(), (Class<?>) FeedNotificationService.class);
                    intent2.putExtra(FeedNotificationService.f6708b, stringExtra4);
                    CommonApplication.m18732r().startService(intent2);
                    if (booleanExtra) {
                        C2093az.m9337a().mo9078a(stringExtra);
                        C4904y.m18641c("push.notiAck( ) - NotiID: " + stringExtra, getClass().getSimpleName());
                    }
                    if (this.f11522d != null) {
                        this.f11522d.release();
                        return;
                    }
                    return;
                }
            } catch (JSONException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, "NotificationReceiver");
                }
            }
            if (C4904y.f17873c) {
                C4904y.m18641c("Push Received : It is message push", getClass().getSimpleName());
            }
            Intent intent3 = new Intent(GlobalApplication.m18732r(), (Class<?>) ChatBackgroundService.class);
            intent3.putExtra("request", intent.getExtras());
            GlobalApplication.m18732r().startService(intent3);
            this.f11519a = new C2212z();
            C2212z.m10068a(this.f11519a, -1, new C2253n(this.f11520b, stringExtra, booleanExtra, stringExtra3, stringExtra2, stringExtra4));
        }
    }

    /* renamed from: a */
    public static void m12761a(InterfaceC1762hh interfaceC1762hh) {
        f11518e = interfaceC1762hh;
    }
}
