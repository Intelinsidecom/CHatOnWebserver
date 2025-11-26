package com.sec.chaton.chat;

import com.sec.chaton.p057e.C2306z;

/* compiled from: MessageLoader.java */
/* renamed from: com.sec.chaton.chat.hj */
/* loaded from: classes.dex */
class RunnableC1764hj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f6635a;

    /* renamed from: b */
    final /* synthetic */ int f6636b;

    /* renamed from: c */
    final /* synthetic */ C1763hi f6637c;

    RunnableC1764hj(C1763hi c1763hi, int i, int i2) {
        this.f6637c = c1763hi;
        this.f6635a = i;
        this.f6636b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6637c.m8760b(EnumC1769ho.NONE);
        if (this.f6637c.m8760b(EnumC1769ho.LOADING_SELECTION)) {
            this.f6637c.f6624g.startQuery(1, String.valueOf(this.f6636b), C2306z.m10214a(this.f6635a < 100 ? 100 : this.f6635a), null, "message_inbox_no=?", new String[]{this.f6637c.f6625h}, null);
        }
    }
}
