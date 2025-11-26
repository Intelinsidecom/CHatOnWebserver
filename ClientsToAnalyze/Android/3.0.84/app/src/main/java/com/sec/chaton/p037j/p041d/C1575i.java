package com.sec.chaton.p037j.p041d;

import android.os.PowerManager;
import com.sec.chaton.p037j.C1544ac;
import com.sec.common.CommonApplication;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.execution.ExecutionHandler;

/* compiled from: TcpClientPipelineFactory.java */
/* renamed from: com.sec.chaton.j.d.i */
/* loaded from: classes.dex */
public class C1575i implements ChannelPipelineFactory {

    /* renamed from: a */
    protected C1544ac f5848a;

    /* renamed from: b */
    protected C1573g f5849b;

    /* renamed from: c */
    protected PowerManager.WakeLock f5850c;

    /* renamed from: d */
    private ExecutionHandler f5851d = null;

    public C1575i(C1544ac c1544ac, C1573g c1573g) {
        this.f5848a = c1544ac;
        this.f5849b = c1573g;
        if (CommonApplication.m11493l() != null) {
            this.f5850c = ((PowerManager) CommonApplication.m11493l().getSystemService("power")).newWakeLock(1, "ChatON");
        }
    }

    @Override // org.jboss.netty.channel.ChannelPipelineFactory
    public ChannelPipeline getPipeline() {
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        channelPipelinePipeline.addLast("StreamEnvelopeDecoder", new C1570d(this.f5850c));
        channelPipelinePipeline.addLast("EnvelopeStreamEncoder", new C1568b(this.f5850c));
        channelPipelinePipeline.addLast("TcpEnvelopeBicoder", new C1576j(this.f5848a, this.f5850c));
        if (this.f5851d != null) {
            channelPipelinePipeline.addLast("threadPoolHandler", this.f5851d);
        }
        channelPipelinePipeline.addLast("TcpClientPipelineFactory", this.f5849b);
        return channelPipelinePipeline;
    }
}
