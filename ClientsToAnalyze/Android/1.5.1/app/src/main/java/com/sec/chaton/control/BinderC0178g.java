package com.sec.chaton.control;

import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.IDeregistrationCallbackListener;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.g */
/* loaded from: classes.dex */
class BinderC0178g extends IDeregistrationCallbackListener.Stub {

    /* renamed from: a */
    final /* synthetic */ RunnableC0175d f1415a;

    BinderC0178g(RunnableC0175d runnableC0175d) {
        this.f1415a = runnableC0175d;
    }

    @Override // com.sec.chaton.push.IDeregistrationCallbackListener
    /* renamed from: a */
    public void mo2099a(int i, String str) {
        this.f1415a.f1410a.m1988e();
        ChatONLogWriter.m3508c("deRegistration Fail, errorCode : " + i + " errorMessage : " + str, getClass().getSimpleName());
        if (this.f1415a.f1411b != null) {
            Message message = new Message();
            message.what = 1002;
            message.obj = false;
            this.f1415a.f1411b.sendMessage(message);
        }
    }

    @Override // com.sec.chaton.push.IDeregistrationCallbackListener
    /* renamed from: a */
    public void mo2100a(String str) {
        ChatONLogWriter.m3508c("deregistration Success, message : " + str, getClass().getSimpleName());
        GlobalApplication.f1895b = null;
        this.f1415a.f1410a.m1988e();
        if (this.f1415a.f1411b != null) {
            Message message = new Message();
            message.what = 1002;
            message.obj = true;
            this.f1415a.f1411b.sendMessage(message);
        }
    }
}
