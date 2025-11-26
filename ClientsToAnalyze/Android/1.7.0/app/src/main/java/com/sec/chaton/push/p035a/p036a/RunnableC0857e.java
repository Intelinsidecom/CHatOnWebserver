package com.sec.chaton.push.p035a.p036a;

import org.jboss.netty.channel.Channel;

/* compiled from: MessageChannelHandler.java */
/* renamed from: com.sec.chaton.push.a.a.e */
/* loaded from: classes.dex */
class RunnableC0857e implements Runnable {

    /* renamed from: a */
    private Channel f2971a;

    public RunnableC0857e(Channel channel) {
        this.f2971a = channel;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2971a.close();
    }
}
