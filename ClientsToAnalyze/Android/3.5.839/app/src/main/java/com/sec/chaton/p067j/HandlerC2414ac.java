package com.sec.chaton.p067j;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p055d.C2142w;

/* compiled from: TcpBaseWorker.java */
/* renamed from: com.sec.chaton.j.ac */
/* loaded from: classes.dex */
class HandlerC2414ac extends Handler {
    public HandlerC2414ac() {
        super(C2142w.m9603b().getLooper());
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2413ab c2413ab = (C2413ab) message.obj;
        switch (message.what) {
            case 1:
                c2413ab.f8589a.m10696b((AbstractC2473x) c2413ab.f8590b[0]);
                break;
            case 3:
                c2413ab.f8589a.mo10476c();
                break;
        }
    }
}
