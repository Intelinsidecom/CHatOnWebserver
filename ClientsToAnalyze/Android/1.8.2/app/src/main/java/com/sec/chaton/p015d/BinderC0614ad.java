package com.sec.chaton.p015d;

import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.AbstractBinderC1083b;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.ad */
/* loaded from: classes.dex */
class BinderC0614ad extends AbstractBinderC1083b {

    /* renamed from: a */
    final /* synthetic */ RunnableC0613ac f2428a;

    BinderC0614ad(RunnableC0613ac runnableC0613ac) {
        this.f2428a = runnableC0613ac;
    }

    @Override // com.sec.chaton.push.InterfaceC1070a
    /* renamed from: a */
    public void mo2800a(String str) {
        if (C1786r.f6453c) {
            C1786r.m6063c(String.format("deregistration Success. message : %s", str), C0612ab.f2425c);
        }
        GlobalApplication.f2775a = null;
        C1789u.m6075a().edit().remove("get_version_push_reg_id").commit();
        this.f2428a.f2426a.m2843c();
        if (this.f2428a.f2427b != null) {
            Message message = new Message();
            message.what = 1002;
            message.obj = true;
            this.f2428a.f2427b.sendMessage(message);
        }
    }

    @Override // com.sec.chaton.push.InterfaceC1070a
    /* renamed from: a */
    public void mo2799a(int i, String str) {
        if (C1786r.f6455e) {
            C1786r.m6054a(String.format("deregistration Error. errorCode : %s, ErrorMessage : %s", Integer.valueOf(i), str), C0612ab.f2425c);
        }
        this.f2428a.f2426a.m2843c();
        if (this.f2428a.f2427b != null) {
            Message message = new Message();
            message.what = 1002;
            message.obj = false;
            this.f2428a.f2427b.sendMessage(message);
        }
    }
}
