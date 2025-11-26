package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.aq */
/* loaded from: classes.dex */
class RunnableC2084aq implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2078ak f7589a;

    /* renamed from: b */
    private Handler f7590b;

    public RunnableC2084aq(C2078ak c2078ak, Handler handler) {
        this.f7589a = c2078ak;
        this.f7590b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f7589a.f7578e.put(0, this.f7590b);
            ((IPushClientService) this.f7589a.f7608b).registration("db9fac80131928e1", CommonApplication.m18732r().getPackageName());
        } catch (RemoteException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, C2078ak.f7576c);
            }
            this.f7589a.m9347c();
            if (this.f7590b != null) {
                Message message = new Message();
                message.what = 1001;
                message.obj = false;
                this.f7590b.sendMessage(message);
            }
        }
    }
}
