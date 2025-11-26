package com.sec.chaton.push;

import android.os.RemoteException;
import com.sec.chaton.push.message.processer.ICallback;
import com.sec.chaton.push.util.PushLog;

/* renamed from: com.sec.chaton.push.g */
/* loaded from: classes.dex */
class C0359g implements ICallback {

    /* renamed from: a */
    final /* synthetic */ IDeregistrationCallbackListener f2609a;

    /* renamed from: b */
    final /* synthetic */ BinderC0357e f2610b;

    C0359g(BinderC0357e binderC0357e, IDeregistrationCallbackListener iDeregistrationCallbackListener) {
        this.f2610b = binderC0357e;
        this.f2609a = iDeregistrationCallbackListener;
    }

    @Override // com.sec.chaton.push.message.processer.ICallback
    /* renamed from: a */
    public void mo2865a(int i) {
        if (this.f2609a != null) {
            try {
                this.f2609a.mo2099a(5202, "Internal error code: " + i);
            } catch (RemoteException e) {
                PushLog.m3026a(this.f2610b.f2603a.f2592a, e.getMessage(), e);
            }
        }
    }

    @Override // com.sec.chaton.push.message.processer.ICallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2866a(Void r4) {
        if (this.f2609a != null) {
            try {
                this.f2609a.mo2100a("Deregistration success");
            } catch (RemoteException e) {
                PushLog.m3026a(this.f2610b.f2603a.f2592a, e.getMessage(), e);
            }
        }
    }
}
