package com.sec.chaton.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.v */
/* loaded from: classes.dex */
class C0207v extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ PublicPushControl f1701a;

    C0207v(PublicPushControl publicPushControl) {
        this.f1701a = publicPushControl;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ChatONLogWriter.m3506b("[PublicPushServiceBroadcastReceiver] Action: " + intent.getAction(), PublicPushControl.f1381c);
        String stringExtra = intent.getStringExtra("appId");
        if (stringExtra == null) {
            ChatONLogWriter.m3506b("App id is null", PublicPushControl.f1381c);
        }
        if (stringExtra.equals("db9fac80131928e1")) {
            ChatONLogWriter.m3506b("App id: " + stringExtra, PublicPushControl.f1381c);
            switch (intent.getIntExtra("com.sec.spp.Status", 1)) {
                case 0:
                    Handler handler = (Handler) this.f1701a.f1383e.remove(0);
                    String stringExtra2 = intent.getStringExtra("RegistrationID");
                    ChatONLogWriter.m3506b("Push registration success. RegId: " + stringExtra2, PublicPushControl.f1381c);
                    GlobalApplication.f1895b = stringExtra2;
                    if (handler != null) {
                        this.f1701a.m1988e();
                        Message message = new Message();
                        message.what = 1001;
                        message.obj = true;
                        handler.sendMessage(message);
                        break;
                    } else {
                        ChatONLogWriter.m3510d("Handler is gone", PublicPushControl.f1381c);
                        break;
                    }
                case 1:
                    Handler handler2 = (Handler) this.f1701a.f1383e.remove(0);
                    if (handler2 != null) {
                        ChatONLogWriter.m3499a("Push registration fail", PublicPushControl.f1381c);
                        this.f1701a.m1988e();
                        Message message2 = new Message();
                        message2.what = 1001;
                        message2.obj = false;
                        handler2.sendMessage(message2);
                        break;
                    } else {
                        ChatONLogWriter.m3510d("Handler is gone", PublicPushControl.f1381c);
                        break;
                    }
                case 2:
                    Handler handler3 = (Handler) this.f1701a.f1383e.remove(1);
                    ChatONLogWriter.m3508c("Push deregistration success", getClass().getSimpleName());
                    GlobalApplication.f1895b = null;
                    if (handler3 != null) {
                        this.f1701a.m1988e();
                        Message message3 = new Message();
                        message3.what = 1002;
                        message3.obj = true;
                        handler3.sendMessage(message3);
                        break;
                    } else {
                        ChatONLogWriter.m3510d("Handler is gone", PublicPushControl.f1381c);
                        break;
                    }
                case 3:
                    Handler handler4 = (Handler) this.f1701a.f1383e.remove(1);
                    if (handler4 != null) {
                        this.f1701a.m1988e();
                        ChatONLogWriter.m3508c("Push deregistration fail", getClass().getSimpleName());
                        Message message4 = new Message();
                        message4.what = 1002;
                        message4.obj = false;
                        handler4.sendMessage(message4);
                        break;
                    } else {
                        ChatONLogWriter.m3510d("Handler is gone", PublicPushControl.f1381c);
                        break;
                    }
            }
        }
    }
}
