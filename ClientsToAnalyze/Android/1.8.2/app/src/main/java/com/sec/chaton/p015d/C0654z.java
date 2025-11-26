package com.sec.chaton.p015d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.spp.push.Config;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.z */
/* loaded from: classes.dex */
class C0654z extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C0649u f2528a;

    C0654z(C0649u c0649u) {
        this.f2528a = c0649u;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1786r.m6061b("[PublicPushServiceBroadcastReceiver] Action: " + intent.getAction(), C0649u.f2516c);
        String stringExtra = intent.getStringExtra("appId");
        if (stringExtra == null) {
            C1786r.m6061b("App id is null", C0649u.f2516c);
        }
        if (stringExtra.equals("db9fac80131928e1")) {
            C1786r.m6061b("App id: " + stringExtra, C0649u.f2516c);
            switch (intent.getIntExtra(Config.EXTRA_PUSH_STATUS, 1)) {
                case 0:
                    Handler handler = (Handler) this.f2528a.f2518e.remove(0);
                    String stringExtra2 = intent.getStringExtra(Config.EXTRA_REGID);
                    C1786r.m6061b("Push registration success. RegId: " + stringExtra2, C0649u.f2516c);
                    GlobalApplication.f2775a = stringExtra2;
                    if (handler == null) {
                        C1786r.m6065d("Handler is gone", C0649u.f2516c);
                        break;
                    } else {
                        this.f2528a.m2843c();
                        Message message = new Message();
                        message.what = 1001;
                        message.obj = true;
                        handler.sendMessage(message);
                        break;
                    }
                case 1:
                    Handler handler2 = (Handler) this.f2528a.f2518e.remove(0);
                    if (handler2 == null) {
                        C1786r.m6065d("Handler is gone", C0649u.f2516c);
                        break;
                    } else {
                        C1786r.m6054a("Push registration fail", C0649u.f2516c);
                        this.f2528a.m2843c();
                        Message message2 = new Message();
                        message2.what = 1001;
                        message2.obj = false;
                        handler2.sendMessage(message2);
                        break;
                    }
                case 2:
                    Handler handler3 = (Handler) this.f2528a.f2518e.remove(1);
                    C1786r.m6063c("Push deregistration success", getClass().getSimpleName());
                    GlobalApplication.f2775a = null;
                    C1789u.m6075a().edit().remove("get_version_push_reg_id").commit();
                    if (handler3 == null) {
                        C1786r.m6065d("Handler is gone", C0649u.f2516c);
                        break;
                    } else {
                        this.f2528a.m2843c();
                        Message message3 = new Message();
                        message3.what = 1002;
                        message3.obj = true;
                        handler3.sendMessage(message3);
                        break;
                    }
                case 3:
                    Handler handler4 = (Handler) this.f2528a.f2518e.remove(1);
                    if (handler4 == null) {
                        C1786r.m6065d("Handler is gone", C0649u.f2516c);
                        break;
                    } else {
                        this.f2528a.m2843c();
                        C1786r.m6063c("Push deregistration fail", getClass().getSimpleName());
                        Message message4 = new Message();
                        message4.what = 1002;
                        message4.obj = false;
                        handler4.sendMessage(message4);
                        break;
                    }
            }
        }
    }
}
