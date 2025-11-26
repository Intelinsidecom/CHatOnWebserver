package com.sec.chaton.p022h;

/* compiled from: TcpClient.java */
/* renamed from: com.sec.chaton.h.x */
/* loaded from: classes.dex */
class RunnableC0814x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0810t f2989a;

    RunnableC0814x(C0810t c0810t) {
        this.f2989a = c0810t;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2989a.f2973a.lock();
        try {
            if (this.f2989a.f2975c != null) {
                this.f2989a.f2975c.m3377c();
            }
        } finally {
            this.f2989a.f2973a.unlock();
        }
    }
}
