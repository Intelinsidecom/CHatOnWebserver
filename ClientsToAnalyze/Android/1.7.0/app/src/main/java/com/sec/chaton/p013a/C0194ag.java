package com.sec.chaton.p013a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.spp.push.Config;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.a.ag */
/* loaded from: classes.dex */
class C0194ag extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C0212k f486a;

    C0194ag(C0212k c0212k) {
        this.f486a = c0212k;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1341p.m4658b("[PublicPushServiceBroadcastReceiver] Action: " + intent.getAction(), C0212k.f514c);
        String stringExtra = intent.getStringExtra("appId");
        if (stringExtra == null) {
            C1341p.m4658b("App id is null", C0212k.f514c);
        }
        if (stringExtra.equals("db9fac80131928e1")) {
            C1341p.m4658b("App id: " + stringExtra, C0212k.f514c);
            switch (intent.getIntExtra(Config.EXTRA_PUSH_STATUS, 1)) {
                case 0:
                    Handler handler = (Handler) this.f486a.f516e.remove(0);
                    String stringExtra2 = intent.getStringExtra(Config.EXTRA_REGID);
                    C1341p.m4658b("Push registration success. RegId: " + stringExtra2, C0212k.f514c);
                    GlobalApplication.f2407a = stringExtra2;
                    if (handler == null) {
                        C1341p.m4661d("Handler is gone", C0212k.f514c);
                        break;
                    } else {
                        this.f486a.m738e();
                        Message message = new Message();
                        message.what = 1001;
                        message.obj = true;
                        handler.sendMessage(message);
                        break;
                    }
                case 1:
                    Handler handler2 = (Handler) this.f486a.f516e.remove(0);
                    if (handler2 == null) {
                        C1341p.m4661d("Handler is gone", C0212k.f514c);
                        break;
                    } else {
                        C1341p.m4651a("Push registration fail", C0212k.f514c);
                        this.f486a.m738e();
                        Message message2 = new Message();
                        message2.what = 1001;
                        message2.obj = false;
                        handler2.sendMessage(message2);
                        break;
                    }
                case 2:
                    Handler handler3 = (Handler) this.f486a.f516e.remove(1);
                    C1341p.m4660c("Push deregistration success", getClass().getSimpleName());
                    GlobalApplication.f2407a = null;
                    C1323bs.m4575a().edit().remove("get_version_push_reg_id").commit();
                    if (handler3 == null) {
                        C1341p.m4661d("Handler is gone", C0212k.f514c);
                        break;
                    } else {
                        this.f486a.m738e();
                        Message message3 = new Message();
                        message3.what = 1002;
                        message3.obj = true;
                        handler3.sendMessage(message3);
                        break;
                    }
                case 3:
                    Handler handler4 = (Handler) this.f486a.f516e.remove(1);
                    if (handler4 == null) {
                        C1341p.m4661d("Handler is gone", C0212k.f514c);
                        break;
                    } else {
                        this.f486a.m738e();
                        C1341p.m4660c("Push deregistration fail", getClass().getSimpleName());
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
