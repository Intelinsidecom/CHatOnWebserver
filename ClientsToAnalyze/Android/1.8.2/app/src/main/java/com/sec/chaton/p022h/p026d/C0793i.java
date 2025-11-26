package com.sec.chaton.p022h.p026d;

import android.os.PowerManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p022h.C0816z;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.execution.ExecutionHandler;

/* compiled from: TcpClientPipelineFactory.java */
/* renamed from: com.sec.chaton.h.d.i */
/* loaded from: classes.dex */
public class C0793i implements ChannelPipelineFactory {

    /* renamed from: a */
    protected C0816z f2914a;

    /* renamed from: b */
    protected C0791g f2915b;

    /* renamed from: c */
    protected PowerManager.WakeLock f2916c;

    /* renamed from: d */
    private ExecutionHandler f2917d = null;

    public C0793i(C0816z c0816z, C0791g c0791g) {
        this.f2914a = c0816z;
        this.f2915b = c0791g;
        if (GlobalApplication.m3260b() != null) {
            this.f2916c = ((PowerManager) GlobalApplication.m3260b().getSystemService("power")).newWakeLock(1, "ChatON");
        }
    }

    @Override // org.jboss.netty.channel.ChannelPipelineFactory
    public ChannelPipeline getPipeline() {
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        channelPipelinePipeline.addLast("StreamEnvelopeDecoder", new C0788d(this.f2916c));
        channelPipelinePipeline.addLast("EnvelopeStreamEncoder", new C0786b(this.f2916c));
        channelPipelinePipeline.addLast("TcpEnvelopeBicoder", new C0794j(this.f2914a, this.f2916c));
        if (this.f2917d != null) {
            channelPipelinePipeline.addLast("threadPoolHandler", this.f2917d);
        }
        channelPipelinePipeline.addLast("TcpClientPipelineFactory", this.f2915b);
        return channelPipelinePipeline;
    }
}
