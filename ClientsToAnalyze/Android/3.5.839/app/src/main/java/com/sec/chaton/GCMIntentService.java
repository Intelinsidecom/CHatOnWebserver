package com.sec.chaton;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.google.android.gcm.GCMBaseIntentService;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class GCMIntentService extends GCMBaseIntentService {

    /* renamed from: a */
    private final String f1953a;

    public GCMIntentService() {
        super("256731395928");
        this.f1953a = "GCMIntentService";
    }

    @Override // com.google.android.gcm.GCMBaseIntentService
    /* renamed from: b */
    protected void mo2206b(Context context, String str) {
        if (C4904y.f17873c) {
            C4904y.m18641c("onError(), error : " + str, "GCMIntentService");
        }
    }

    @Override // com.google.android.gcm.GCMBaseIntentService
    /* renamed from: a */
    protected void mo2203a(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("payload");
        String stringExtra2 = intent.getStringExtra(Config.NOTIFICATION_INTENT_SENDER);
        String stringExtra3 = intent.getStringExtra(Config.NOTIFICATION_INTENT_APP_DATA);
        StringBuilder sb = new StringBuilder("onMessage(),");
        sb.append("payload : ").append(stringExtra).append(", sender : ").append(stringExtra2).append(", appData : ").append(stringExtra3);
        if (C4904y.f17873c) {
            C4904y.m18641c(sb.toString(), "GCMIntentService");
        }
        Intent intent2 = new Intent("com.sec.chaton.push.NOTIFICATION_ACTION");
        intent2.putExtra(Config.NOTIFICATION_INTENT_NOTIID, "gcm_noti_id");
        intent2.putExtra(Config.NOTIFICATION_INTENT_SENDER, stringExtra2);
        intent2.putExtra(Config.NOTIFICATION_INTENT_MSG, "");
        intent2.putExtra(Config.NOTIFICATION_INTENT_APP_DATA, stringExtra3);
        intent2.putExtra(Config.NOTIFICATION_INTENT_ACK, false);
        ((PowerManager) context.getSystemService("power")).newWakeLock(1, "ChatON").acquire(1000L);
        context.sendBroadcast(intent2, "com.sec.chaton.push.BROADCAST_PUSH_MESSAGE");
    }

    @Override // com.google.android.gcm.GCMBaseIntentService
    /* renamed from: c */
    protected void mo2207c(Context context, String str) {
        if (C4904y.f17873c) {
            C4904y.m18641c("onRegistered(), registrationId : " + str, "GCMIntentService");
        }
        GlobalApplication.f8356b = str;
        C4859bx.m18405e(str);
    }

    @Override // com.google.android.gcm.GCMBaseIntentService
    /* renamed from: d */
    protected void mo2208d(Context context, String str) {
        if (C4904y.f17873c) {
            C4904y.m18641c("onUnregistered(), registrationId : " + str, "GCMIntentService");
        }
    }
}
