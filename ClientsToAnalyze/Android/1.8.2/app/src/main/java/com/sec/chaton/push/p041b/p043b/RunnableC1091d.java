package com.sec.chaton.push.p041b.p043b;

import org.jboss.netty.channel.Channel;

/* compiled from: MessageChannelHandler.java */
/* renamed from: com.sec.chaton.push.b.b.d */
/* loaded from: classes.dex */
class RunnableC1091d implements Runnable {

    /* renamed from: a */
    private Channel f4017a;

    public RunnableC1091d(Channel channel) {
        this.f4017a = channel;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4017a.close();
    }
}
