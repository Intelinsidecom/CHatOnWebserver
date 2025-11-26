package com.sec.chaton.push.p051b.p053b;

import org.jboss.netty.channel.Channel;

/* compiled from: MessageChannelHandler.java */
/* renamed from: com.sec.chaton.push.b.b.d */
/* loaded from: classes.dex */
class RunnableC2064d implements Runnable {

    /* renamed from: a */
    private Channel f7920a;

    public RunnableC2064d(Channel channel) {
        this.f7920a = channel;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7920a.close();
    }
}
