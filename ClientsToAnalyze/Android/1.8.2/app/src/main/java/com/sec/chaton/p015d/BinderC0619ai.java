package com.sec.chaton.p015d;

import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.AbstractBinderC1122h;
import com.sec.chaton.util.C1786r;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.ai */
/* loaded from: classes.dex */
class BinderC0619ai extends AbstractBinderC1122h {

    /* renamed from: a */
    final /* synthetic */ RunnableC0618ah f2437a;

    BinderC0619ai(RunnableC0618ah runnableC0618ah) {
        this.f2437a = runnableC0618ah;
    }

    @Override // com.sec.chaton.push.InterfaceC1121g
    /* renamed from: a */
    public void mo2803a(String str, String str2) {
        if (C1786r.f6453c) {
            C1786r.m6063c(String.format("registration Success. message : %s, regId : %s", str, str2), C0612ab.f2425c);
        }
        GlobalApplication.f2775a = str2;
        this.f2437a.f2435a.m2843c();
        if (this.f2437a.f2436b != null) {
            Message message = new Message();
            message.what = 1001;
            message.obj = true;
            this.f2437a.f2436b.sendMessage(message);
        }
    }

    @Override // com.sec.chaton.push.InterfaceC1121g
    /* renamed from: a */
    public void mo2802a(int i, String str) {
        if (C1786r.f6455e) {
            C1786r.m6054a(String.format("registration Error. errorCode : %s, ErrorMessage : %s", Integer.valueOf(i), str), C0612ab.f2425c);
        }
        this.f2437a.f2435a.m2843c();
        if (this.f2437a.f2436b != null) {
            Message message = new Message();
            message.what = 1001;
            message.obj = false;
            this.f2437a.f2436b.sendMessage(message);
        }
    }
}
