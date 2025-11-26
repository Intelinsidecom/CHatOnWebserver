package com.sec.chaton.chat.p024b;

import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.C1373q;
import java.util.TimerTask;

/* compiled from: TTSSpeakEngine.java */
/* renamed from: com.sec.chaton.chat.b.k */
/* loaded from: classes.dex */
class C0960k extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C0959j f3949a;

    C0960k(C0959j c0959j) {
        this.f3949a = c0959j;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (C0958i.f3945e.size() > 0 && C0958i.f3944d && C0958i.f3941a != null && !C0958i.f3941a.isSpeaking()) {
            C0961l c0961l = (C0961l) C0958i.f3945e.get(0);
            if (C0958i.m5170b(c0961l)) {
                if (C0958i.f3945e.size() > 0) {
                    C0958i.f3945e.remove(0);
                }
                C1373q.m6197f(GlobalApplication.m11493l().getContentResolver(), Long.valueOf(c0961l.f3950a));
            }
        }
    }
}
