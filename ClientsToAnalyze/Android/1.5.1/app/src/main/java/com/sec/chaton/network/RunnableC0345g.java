package com.sec.chaton.network;

/* renamed from: com.sec.chaton.network.g */
/* loaded from: classes.dex */
class RunnableC0345g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ TcpClient f2544a;

    RunnableC0345g(TcpClient tcpClient) {
        this.f2544a = tcpClient;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2544a.f2461a.lock();
        try {
            if (this.f2544a.f2463c != null) {
                this.f2544a.f2463c.m2837c();
            }
        } finally {
            this.f2544a.f2461a.unlock();
        }
    }
}
