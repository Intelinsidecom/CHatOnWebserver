package com.sec.chaton.p055d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.ap */
/* loaded from: classes.dex */
class C2083ap extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C2078ak f7588a;

    C2083ap(C2078ak c2078ak) {
        this.f7588a = c2078ak;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("[PublicPushServiceBroadcastReceiver] Action: " + intent.getAction(), C2078ak.f7576c);
        String stringExtra = intent.getStringExtra("appId");
        int intExtra = intent.getIntExtra(Config.EXTRA_ERROR, 0);
        if (stringExtra == null) {
            C4904y.m18639b("App id is null", C2078ak.f7576c);
        }
        if (stringExtra.equals("db9fac80131928e1")) {
            C4904y.m18639b("App id: " + stringExtra, C2078ak.f7576c);
            switch (intent.getIntExtra(Config.EXTRA_PUSH_STATUS, 1)) {
                case 0:
                    Handler handler = (Handler) this.f7588a.f7578e.remove(0);
                    String stringExtra2 = intent.getStringExtra(Config.EXTRA_REGID);
                    C4904y.m18639b("Push registration success. RegId: " + stringExtra2, C2078ak.f7576c);
                    GlobalApplication.f8355a = stringExtra2;
                    if (handler == null) {
                        C4904y.m18645d("Handler is gone", C2078ak.f7576c);
                        break;
                    } else {
                        this.f7588a.m9347c();
                        Message message = new Message();
                        message.what = 1001;
                        message.obj = true;
                        handler.sendMessage(message);
                        break;
                    }
                case 1:
                    Handler handler2 = (Handler) this.f7588a.f7578e.remove(0);
                    if (handler2 != null) {
                        C4904y.m18634a("Push registration fail. ErrorCode: " + intExtra, C2078ak.f7576c);
                        this.f7588a.m9347c();
                        Message message2 = new Message();
                        message2.what = 1001;
                        message2.obj = false;
                        message2.arg1 = intExtra;
                        handler2.sendMessage(message2);
                        break;
                    } else {
                        C4904y.m18645d("Handler is gone", C2078ak.f7576c);
                        break;
                    }
                case 2:
                    Handler handler3 = (Handler) this.f7588a.f7578e.remove(1);
                    C4904y.m18641c("Push deregistration success", getClass().getSimpleName());
                    GlobalApplication.f8355a = null;
                    C4809aa.m18104a().m18123a("get_version_push_reg_id");
                    if (handler3 == null) {
                        C4904y.m18645d("Handler is gone", C2078ak.f7576c);
                        break;
                    } else {
                        this.f7588a.m9347c();
                        Message message3 = new Message();
                        message3.what = 1002;
                        message3.obj = true;
                        handler3.sendMessage(message3);
                        break;
                    }
                case 3:
                    Handler handler4 = (Handler) this.f7588a.f7578e.remove(1);
                    if (handler4 == null) {
                        C4904y.m18645d("Handler is gone", C2078ak.f7576c);
                        break;
                    } else {
                        this.f7588a.m9347c();
                        C4904y.m18641c("Push deregistration fail", getClass().getSimpleName());
                        Message message4 = new Message();
                        message4.what = 1002;
                        message4.obj = false;
                        message4.arg1 = intExtra;
                        handler4.sendMessage(message4);
                        break;
                    }
            }
        }
    }
}
