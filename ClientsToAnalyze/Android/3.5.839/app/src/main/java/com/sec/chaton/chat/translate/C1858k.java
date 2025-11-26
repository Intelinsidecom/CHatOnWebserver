package com.sec.chaton.chat.translate;

import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.p058a.C2204r;
import java.util.TimerTask;

/* compiled from: TTSSpeakEngine.java */
/* renamed from: com.sec.chaton.chat.translate.k */
/* loaded from: classes.dex */
class C1858k extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C1857j f7062a;

    C1858k(C1857j c1857j) {
        this.f7062a = c1857j;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (C1856i.f7056e.size() > 0 && C1856i.f7055d && C1856i.f7052a != null && !C1856i.f7052a.isSpeaking()) {
            C1859l c1859l = (C1859l) C1856i.f7056e.get(0);
            if (C1856i.m9054b(c1859l)) {
                if (C1856i.f7056e.size() > 0) {
                    C1856i.f7056e.remove(0);
                }
                C2204r.m10057f(GlobalApplication.m18732r().getContentResolver(), Long.valueOf(c1859l.f7063a));
            }
        }
    }
}
