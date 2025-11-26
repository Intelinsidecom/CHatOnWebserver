package com.sec.chaton.push.p091b.p093b;

import org.jboss.netty.channel.Channel;

/* compiled from: MessageChannelHandler.java */
/* renamed from: com.sec.chaton.push.b.b.d */
/* loaded from: classes.dex */
class RunnableC3064d implements Runnable {

    /* renamed from: a */
    private Channel f11330a;

    public RunnableC3064d(Channel channel) {
        this.f11330a = channel;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f11330a.close();
    }
}
