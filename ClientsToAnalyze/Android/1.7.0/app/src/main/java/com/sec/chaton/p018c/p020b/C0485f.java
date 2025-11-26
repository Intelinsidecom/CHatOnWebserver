package com.sec.chaton.p018c.p020b;

import android.os.PowerManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0505l;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.execution.ExecutionHandler;

/* compiled from: TcpClientPipelineFactory.java */
/* renamed from: com.sec.chaton.c.b.f */
/* loaded from: classes.dex */
public class C0485f implements ChannelPipelineFactory {

    /* renamed from: a */
    protected C0505l f1559a;

    /* renamed from: b */
    protected C0484e f1560b;

    /* renamed from: c */
    protected PowerManager.WakeLock f1561c;

    /* renamed from: d */
    private ExecutionHandler f1562d = null;

    public C0485f(C0505l c0505l, C0484e c0484e) {
        this.f1559a = c0505l;
        this.f1560b = c0484e;
        if (GlobalApplication.m3100a() != null) {
            this.f1561c = ((PowerManager) GlobalApplication.m3100a().getSystemService("power")).newWakeLock(1, "ChatON");
        }
    }

    @Override // org.jboss.netty.channel.ChannelPipelineFactory
    public ChannelPipeline getPipeline() {
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        channelPipelinePipeline.addLast("StreamEnvelopeDecoder", new C0480a(this.f1561c));
        channelPipelinePipeline.addLast("EnvelopeStreamEncoder", new C0481b(this.f1561c));
        channelPipelinePipeline.addLast("TcpEnvelopeBicoder", new C0486g(this.f1559a, this.f1561c));
        if (this.f1562d != null) {
            channelPipelinePipeline.addLast("threadPoolHandler", this.f1562d);
        }
        channelPipelinePipeline.addLast("TcpClientPipelineFactory", this.f1560b);
        return channelPipelinePipeline;
    }
}
