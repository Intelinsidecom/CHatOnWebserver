package com.sec.chaton.p025d;

import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.AbstractBinderC2097i;
import com.sec.chaton.util.C3250y;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.an */
/* loaded from: classes.dex */
class BinderC1301an extends AbstractBinderC2097i {

    /* renamed from: a */
    final /* synthetic */ RunnableC1300am f4930a;

    BinderC1301an(RunnableC1300am runnableC1300am) {
        this.f4930a = runnableC1300am;
    }

    @Override // com.sec.chaton.push.InterfaceC2095h
    /* renamed from: a */
    public void mo5593a(String str, String str2) {
        if (C3250y.f11735c) {
            C3250y.m11453c(String.format("registration Success. message : %s, regId : %s", str, str2), C1294ag.f4918c);
        }
        GlobalApplication.f5511a = str2;
        this.f4930a.f4928a.m5669c();
        if (this.f4930a.f4929b != null) {
            Message message = new Message();
            message.what = 1001;
            message.obj = true;
            this.f4930a.f4929b.sendMessage(message);
        }
    }

    @Override // com.sec.chaton.push.InterfaceC2095h
    /* renamed from: a */
    public void mo5592a(int i, String str) {
        if (C3250y.f11737e) {
            C3250y.m11442a(String.format("registration Error. errorCode : %s, ErrorMessage : %s", Integer.valueOf(i), str), C1294ag.f4918c);
        }
        this.f4930a.f4928a.m5669c();
        if (this.f4930a.f4929b != null) {
            Message message = new Message();
            message.what = 1001;
            message.obj = false;
            message.arg1 = i;
            this.f4930a.f4929b.sendMessage(message);
        }
    }
}
