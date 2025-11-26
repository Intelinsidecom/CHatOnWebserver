package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.an */
/* loaded from: classes.dex */
class RunnableC2081an implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2078ak f7584a;

    /* renamed from: b */
    private Handler f7585b;

    public RunnableC2081an(C2078ak c2078ak, Handler handler) {
        this.f7584a = c2078ak;
        this.f7585b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2078ak c2078ak;
        try {
            try {
                boolean zIsPushAvailable = ((IPushClientService) this.f7584a.f7608b).isPushAvailable();
                if (this.f7585b != null) {
                    Message message = new Message();
                    message.what = 1003;
                    message.obj = Boolean.valueOf(zIsPushAvailable);
                    this.f7585b.sendMessage(message);
                }
                c2078ak = this.f7584a;
            } catch (RemoteException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, C2078ak.f7576c);
                }
                if (this.f7585b != null) {
                    Message message2 = new Message();
                    message2.what = 1003;
                    message2.obj = false;
                    this.f7585b.sendMessage(message2);
                }
                c2078ak = this.f7584a;
            }
            c2078ak.m9347c();
        } catch (Throwable th) {
            this.f7584a.m9347c();
            throw th;
        }
    }
}
