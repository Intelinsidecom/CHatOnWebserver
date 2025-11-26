package com.sec.chaton.p018c;

/* compiled from: TcpClient.java */
/* renamed from: com.sec.chaton.c.v */
/* loaded from: classes.dex */
class RunnableC0515v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0477ab f1678a;

    RunnableC0515v(C0477ab c0477ab) {
        this.f1678a = c0477ab;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1678a.f1535a.lock();
        try {
            if (this.f1678a.f1537c != null) {
                this.f1678a.f1537c.m2476c();
            }
        } finally {
            this.f1678a.f1535a.unlock();
        }
    }
}
