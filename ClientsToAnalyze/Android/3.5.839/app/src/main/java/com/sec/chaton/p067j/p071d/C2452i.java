package com.sec.chaton.p067j.p071d;

import android.os.PowerManager;
import com.sec.chaton.p067j.C2422ak;
import com.sec.common.CommonApplication;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.execution.ExecutionHandler;

/* compiled from: TcpClientPipelineFactory.java */
/* renamed from: com.sec.chaton.j.d.i */
/* loaded from: classes.dex */
public class C2452i implements ChannelPipelineFactory {

    /* renamed from: a */
    protected C2422ak f8792a;

    /* renamed from: b */
    protected C2450g f8793b;

    /* renamed from: c */
    protected PowerManager.WakeLock f8794c;

    /* renamed from: d */
    private ExecutionHandler f8795d = null;

    public C2452i(C2422ak c2422ak, C2450g c2450g) {
        this.f8792a = c2422ak;
        this.f8793b = c2450g;
        if (CommonApplication.m18732r() != null) {
            this.f8794c = ((PowerManager) CommonApplication.m18732r().getSystemService("power")).newWakeLock(1, "ChatON");
        }
    }

    @Override // org.jboss.netty.channel.ChannelPipelineFactory
    public ChannelPipeline getPipeline() {
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        channelPipelinePipeline.addLast("StreamEnvelopeDecoder", new C2447d(this.f8794c));
        channelPipelinePipeline.addLast("EnvelopeStreamEncoder", new C2445b(this.f8794c));
        channelPipelinePipeline.addLast("TcpEnvelopeBicoder", new C2453j(this.f8792a, this.f8794c));
        if (this.f8795d != null) {
            channelPipelinePipeline.addLast("threadPoolHandler", this.f8795d);
        }
        channelPipelinePipeline.addLast("TcpClientPipelineFactory", this.f8793b);
        return channelPipelinePipeline;
    }
}
