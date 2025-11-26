package com.sec.chaton.p013a;

import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.AbstractBinderC0907i;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.a.s */
/* loaded from: classes.dex */
class BinderC0220s extends AbstractBinderC0907i {

    /* renamed from: a */
    final /* synthetic */ RunnableC0207f f531a;

    BinderC0220s(RunnableC0207f runnableC0207f) {
        this.f531a = runnableC0207f;
    }

    @Override // com.sec.chaton.push.InterfaceC0880c
    /* renamed from: a */
    public void mo805a(String str) {
        if (C1341p.f4579c) {
            C1341p.m4660c(String.format("deregistration Success. message : %s", str), C0219r.f530c);
        }
        GlobalApplication.f2407a = null;
        C1323bs.m4575a().edit().remove("get_version_push_reg_id").commit();
        this.f531a.f508a.m738e();
        if (this.f531a.f509b != null) {
            Message message = new Message();
            message.what = 1002;
            message.obj = true;
            this.f531a.f509b.sendMessage(message);
        }
    }

    @Override // com.sec.chaton.push.InterfaceC0880c
    /* renamed from: a */
    public void mo804a(int i, String str) {
        if (C1341p.f4581e) {
            C1341p.m4651a(String.format("deregistration Error. errorCode : %s, ErrorMessage : %s", Integer.valueOf(i), str), C0219r.f530c);
        }
        this.f531a.f508a.m738e();
        if (this.f531a.f509b != null) {
            Message message = new Message();
            message.what = 1002;
            message.obj = false;
            this.f531a.f509b.sendMessage(message);
        }
    }
}
