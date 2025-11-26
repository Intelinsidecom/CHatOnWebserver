package com.sec.chaton.p025d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.Config;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.ae */
/* loaded from: classes.dex */
class C1292ae extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C1348z f4915a;

    C1292ae(C1348z c1348z) {
        this.f4915a = c1348z;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("[PublicPushServiceBroadcastReceiver] Action: " + intent.getAction(), C1348z.f5083c);
        String stringExtra = intent.getStringExtra("appId");
        int intExtra = intent.getIntExtra(Config.EXTRA_ERROR, 0);
        if (stringExtra == null) {
            C3250y.m11450b("App id is null", C1348z.f5083c);
        }
        if (stringExtra.equals("db9fac80131928e1")) {
            C3250y.m11450b("App id: " + stringExtra, C1348z.f5083c);
            switch (intent.getIntExtra(Config.EXTRA_PUSH_STATUS, 1)) {
                case 0:
                    Handler handler = (Handler) this.f4915a.f5085e.remove(0);
                    String stringExtra2 = intent.getStringExtra(Config.EXTRA_REGID);
                    C3250y.m11450b("Push registration success. RegId: " + stringExtra2, C1348z.f5083c);
                    GlobalApplication.f5511a = stringExtra2;
                    if (handler == null) {
                        C3250y.m11455d("Handler is gone", C1348z.f5083c);
                        break;
                    } else {
                        this.f4915a.m5669c();
                        Message message = new Message();
                        message.what = 1001;
                        message.obj = true;
                        handler.sendMessage(message);
                        break;
                    }
                case 1:
                    Handler handler2 = (Handler) this.f4915a.f5085e.remove(0);
                    if (handler2 != null) {
                        C3250y.m11442a("Push registration fail. ErrorCode: " + intExtra, C1348z.f5083c);
                        this.f4915a.m5669c();
                        Message message2 = new Message();
                        message2.what = 1001;
                        message2.obj = false;
                        message2.arg1 = intExtra;
                        handler2.sendMessage(message2);
                        break;
                    } else {
                        C3250y.m11455d("Handler is gone", C1348z.f5083c);
                        break;
                    }
                case 2:
                    Handler handler3 = (Handler) this.f4915a.f5085e.remove(1);
                    C3250y.m11453c("Push deregistration success", getClass().getSimpleName());
                    GlobalApplication.f5511a = null;
                    C3159aa.m10962a().m10981a("get_version_push_reg_id");
                    if (handler3 == null) {
                        C3250y.m11455d("Handler is gone", C1348z.f5083c);
                        break;
                    } else {
                        this.f4915a.m5669c();
                        Message message3 = new Message();
                        message3.what = 1002;
                        message3.obj = true;
                        handler3.sendMessage(message3);
                        break;
                    }
                case 3:
                    Handler handler4 = (Handler) this.f4915a.f5085e.remove(1);
                    if (handler4 == null) {
                        C3250y.m11455d("Handler is gone", C1348z.f5083c);
                        break;
                    } else {
                        this.f4915a.m5669c();
                        C3250y.m11453c("Push deregistration fail", getClass().getSimpleName());
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
