package com.sec.chaton.p055d;

import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.AbstractBinderC3071c;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.at */
/* loaded from: classes.dex */
class BinderC2087at extends AbstractBinderC3071c {

    /* renamed from: a */
    final /* synthetic */ RunnableC2086as f7594a;

    BinderC2087at(RunnableC2086as runnableC2086as) {
        this.f7594a = runnableC2086as;
    }

    @Override // com.sec.chaton.push.InterfaceC3056b
    /* renamed from: a */
    public void mo9333a(String str) {
        if (C4904y.f17873c) {
            C4904y.m18641c(String.format("deregistration Success. message : %s", str), C2085ar.f7591c);
        }
        GlobalApplication.f8355a = null;
        C4809aa.m18104a().m18123a("get_version_push_reg_id");
        this.f7594a.f7592a.m9347c();
        if (this.f7594a.f7593b != null) {
            Message message = new Message();
            message.what = 1002;
            message.obj = true;
            this.f7594a.f7593b.sendMessage(message);
        }
    }

    @Override // com.sec.chaton.push.InterfaceC3056b
    /* renamed from: a */
    public void mo9332a(int i, String str) {
        if (C4904y.f17875e) {
            C4904y.m18634a(String.format("deregistration Error. errorCode : %s, ErrorMessage : %s", Integer.valueOf(i), str), C2085ar.f7591c);
        }
        this.f7594a.f7592a.m9347c();
        if (this.f7594a.f7593b != null) {
            Message message = new Message();
            message.what = 1002;
            message.obj = false;
            message.arg1 = i;
            this.f7594a.f7593b.sendMessage(message);
        }
    }
}
