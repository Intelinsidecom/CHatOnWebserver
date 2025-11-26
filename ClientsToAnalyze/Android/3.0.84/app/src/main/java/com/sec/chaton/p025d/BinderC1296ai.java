package com.sec.chaton.p025d;

import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.AbstractBinderC2071c;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.ai */
/* loaded from: classes.dex */
class BinderC1296ai extends AbstractBinderC2071c {

    /* renamed from: a */
    final /* synthetic */ RunnableC1295ah f4921a;

    BinderC1296ai(RunnableC1295ah runnableC1295ah) {
        this.f4921a = runnableC1295ah;
    }

    @Override // com.sec.chaton.push.InterfaceC2056b
    /* renamed from: a */
    public void mo5590a(String str) {
        if (C3250y.f11735c) {
            C3250y.m11453c(String.format("deregistration Success. message : %s", str), C1294ag.f4918c);
        }
        GlobalApplication.f5511a = null;
        C3159aa.m10962a().m10981a("get_version_push_reg_id");
        this.f4921a.f4919a.m5669c();
        if (this.f4921a.f4920b != null) {
            Message message = new Message();
            message.what = 1002;
            message.obj = true;
            this.f4921a.f4920b.sendMessage(message);
        }
    }

    @Override // com.sec.chaton.push.InterfaceC2056b
    /* renamed from: a */
    public void mo5589a(int i, String str) {
        if (C3250y.f11737e) {
            C3250y.m11442a(String.format("deregistration Error. errorCode : %s, ErrorMessage : %s", Integer.valueOf(i), str), C1294ag.f4918c);
        }
        this.f4921a.f4919a.m5669c();
        if (this.f4921a.f4920b != null) {
            Message message = new Message();
            message.what = 1002;
            message.obj = false;
            message.arg1 = i;
            this.f4921a.f4920b.sendMessage(message);
        }
    }
}
