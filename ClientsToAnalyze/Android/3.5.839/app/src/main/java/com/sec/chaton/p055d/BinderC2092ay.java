package com.sec.chaton.p055d;

import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.AbstractBinderC3097i;
import com.sec.chaton.util.C4904y;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.ay */
/* loaded from: classes.dex */
class BinderC2092ay extends AbstractBinderC3097i {

    /* renamed from: a */
    final /* synthetic */ RunnableC2091ax f7603a;

    BinderC2092ay(RunnableC2091ax runnableC2091ax) {
        this.f7603a = runnableC2091ax;
    }

    @Override // com.sec.chaton.push.InterfaceC3095h
    /* renamed from: a */
    public void mo9336a(String str, String str2) {
        if (C4904y.f17873c) {
            C4904y.m18641c(String.format("registration Success. message : %s, regId : %s", str, str2), C2085ar.f7591c);
        }
        GlobalApplication.f8355a = str2;
        this.f7603a.f7601a.m9347c();
        if (this.f7603a.f7602b != null) {
            Message message = new Message();
            message.what = 1001;
            message.obj = true;
            this.f7603a.f7602b.sendMessage(message);
        }
    }

    @Override // com.sec.chaton.push.InterfaceC3095h
    /* renamed from: a */
    public void mo9335a(int i, String str) {
        if (C4904y.f17875e) {
            C4904y.m18634a(String.format("registration Error. errorCode : %s, ErrorMessage : %s", Integer.valueOf(i), str), C2085ar.f7591c);
        }
        this.f7603a.f7601a.m9347c();
        if (this.f7603a.f7602b != null) {
            Message message = new Message();
            message.what = 1001;
            message.obj = false;
            message.arg1 = i;
            this.f7603a.f7602b.sendMessage(message);
        }
    }
}
