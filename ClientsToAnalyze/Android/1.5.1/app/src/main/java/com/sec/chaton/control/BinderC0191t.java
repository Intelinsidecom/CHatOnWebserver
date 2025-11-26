package com.sec.chaton.control;

import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.IRegistrationCallbackListener;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.t */
/* loaded from: classes.dex */
class BinderC0191t extends IRegistrationCallbackListener.Stub {

    /* renamed from: a */
    final /* synthetic */ RunnableC0172aa f1452a;

    BinderC0191t(RunnableC0172aa runnableC0172aa) {
        this.f1452a = runnableC0172aa;
    }

    @Override // com.sec.chaton.push.IRegistrationCallbackListener
    /* renamed from: a */
    public void mo2105a(int i, String str) {
        ChatONLogWriter.m3508c("registration Error, errorCode : " + i + " ErrorMessage : " + str, getClass().getSimpleName());
        this.f1452a.f1405a.m1988e();
        if (this.f1452a.f1406b != null) {
            Message message = new Message();
            message.what = 1001;
            message.obj = false;
            this.f1452a.f1406b.sendMessage(message);
        }
    }

    @Override // com.sec.chaton.push.IRegistrationCallbackListener
    /* renamed from: a */
    public void mo2106a(String str, String str2) {
        ChatONLogWriter.m3508c("registration Success, message : " + str + " regId : " + str2, getClass().getSimpleName());
        GlobalApplication.f1895b = str2;
        this.f1452a.f1405a.m1988e();
        if (this.f1452a.f1406b != null) {
            Message message = new Message();
            message.what = 1001;
            message.obj = true;
            this.f1452a.f1406b.sendMessage(message);
        }
    }
}
