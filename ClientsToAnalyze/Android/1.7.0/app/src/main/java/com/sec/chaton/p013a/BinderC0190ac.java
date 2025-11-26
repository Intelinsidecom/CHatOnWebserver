package com.sec.chaton.p013a;

import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.AbstractBinderC0901e;
import com.sec.chaton.util.C1341p;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.a.ac */
/* loaded from: classes.dex */
class BinderC0190ac extends AbstractBinderC0901e {

    /* renamed from: a */
    final /* synthetic */ RunnableC0201an f474a;

    BinderC0190ac(RunnableC0201an runnableC0201an) {
        this.f474a = runnableC0201an;
    }

    @Override // com.sec.chaton.push.InterfaceC0902f
    /* renamed from: a */
    public void mo728a(String str, String str2) {
        if (C1341p.f4579c) {
            C1341p.m4660c(String.format("registration Success. message : %s, regId : %s", str, str2), C0219r.f530c);
        }
        GlobalApplication.f2407a = str2;
        this.f474a.f497a.m738e();
        if (this.f474a.f498b != null) {
            Message message = new Message();
            message.what = 1001;
            message.obj = true;
            this.f474a.f498b.sendMessage(message);
        }
    }

    @Override // com.sec.chaton.push.InterfaceC0902f
    /* renamed from: a */
    public void mo727a(int i, String str) {
        if (C1341p.f4581e) {
            C1341p.m4651a(String.format("registration Error. errorCode : %s, ErrorMessage : %s", Integer.valueOf(i), str), C0219r.f530c);
        }
        this.f474a.f497a.m738e();
        if (this.f474a.f498b != null) {
            Message message = new Message();
            message.what = 1001;
            message.obj = false;
            this.f474a.f498b.sendMessage(message);
        }
    }
}
