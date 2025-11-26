package com.sec.chaton.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.sec.chaton.util.C1786r;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.ad */
/* loaded from: classes.dex */
class C1225ad extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f4764a;

    C1225ad(ActivityNoti activityNoti) {
        this.f4764a = activityNoti;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1786r.m6061b("onReceive()", getClass().getSimpleName());
        if (intent.getAction() == null) {
            C1786r.m6063c("onReceive() - getAction()=null", getClass().getSimpleName());
            return;
        }
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (!intent.getBooleanExtra("noConnectivity", false)) {
                this.f4764a.f4510q.sendMessageDelayed(Message.obtain(), 5000L);
            } else {
                C1786r.m6054a("onReceive() calling updatePushStatus()", getClass().getSimpleName());
                this.f4764a.m4519a();
            }
        }
    }
}
