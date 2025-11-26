package com.sec.chaton.p055d;

import com.sec.chaton.util.C4904y;
import java.util.TimerTask;

/* compiled from: MessageControl2.java */
/* renamed from: com.sec.chaton.d.aa */
/* loaded from: classes.dex */
class C2068aa extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C2142w f7548a;

    C2068aa(C2142w c2142w) {
        this.f7548a = c2142w;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (C4904y.f17873c) {
            C4904y.m18641c("(C_C)To close the connection, call closeConnection()", "MessageControl");
        }
        this.f7548a.mo9274d();
        this.f7548a.f7770y = null;
    }
}
