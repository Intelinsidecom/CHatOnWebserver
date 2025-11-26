package com.sec.chaton.push;

import android.os.RemoteException;
import com.sec.chaton.push.message.processer.ICallback;
import com.sec.chaton.push.registration.RegistrationManager;
import com.sec.chaton.push.util.PushLog;

/* renamed from: com.sec.chaton.push.h */
/* loaded from: classes.dex */
class C0360h implements ICallback {

    /* renamed from: a */
    final /* synthetic */ IRegistrationCallbackListener f2611a;

    /* renamed from: b */
    final /* synthetic */ BinderC0357e f2612b;

    C0360h(BinderC0357e binderC0357e, IRegistrationCallbackListener iRegistrationCallbackListener) {
        this.f2612b = binderC0357e;
        this.f2611a = iRegistrationCallbackListener;
    }

    @Override // com.sec.chaton.push.message.processer.ICallback
    /* renamed from: a */
    public void mo2865a(int i) {
        if (this.f2611a != null) {
            try {
                this.f2611a.mo2105a(5201, "Internal error code: " + i);
            } catch (RemoteException e) {
                PushLog.m3026a(this.f2612b.f2603a.f2592a, e.getMessage(), e);
            }
        }
    }

    @Override // com.sec.chaton.push.message.processer.ICallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2866a(Void r4) {
        if (this.f2611a != null) {
            try {
                this.f2611a.mo2106a("Registration success", RegistrationManager.m3015d(this.f2612b.f2603a));
            } catch (RemoteException e) {
                PushLog.m3026a(this.f2612b.f2603a.f2592a, e.getMessage(), e);
            }
        }
    }
}
