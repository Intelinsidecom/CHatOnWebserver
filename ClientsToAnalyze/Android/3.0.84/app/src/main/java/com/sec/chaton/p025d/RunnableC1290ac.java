package com.sec.chaton.p025d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.ac */
/* loaded from: classes.dex */
class RunnableC1290ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1348z f4911a;

    /* renamed from: b */
    private Handler f4912b;

    public RunnableC1290ac(C1348z c1348z, Handler handler) {
        this.f4911a = c1348z;
        this.f4912b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1348z c1348z;
        try {
            try {
                boolean zIsPushAvailable = ((IPushClientService) this.f4911a.f4972b).isPushAvailable();
                if (this.f4912b != null) {
                    Message message = new Message();
                    message.what = 1003;
                    message.obj = Boolean.valueOf(zIsPushAvailable);
                    this.f4912b.sendMessage(message);
                }
                c1348z = this.f4911a;
            } catch (RemoteException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, C1348z.f5083c);
                }
                if (this.f4912b != null) {
                    Message message2 = new Message();
                    message2.what = 1003;
                    message2.obj = false;
                    this.f4912b.sendMessage(message2);
                }
                c1348z = this.f4911a;
            }
            c1348z.m5669c();
        } catch (Throwable th) {
            this.f4911a.m5669c();
            throw th;
        }
    }
}
