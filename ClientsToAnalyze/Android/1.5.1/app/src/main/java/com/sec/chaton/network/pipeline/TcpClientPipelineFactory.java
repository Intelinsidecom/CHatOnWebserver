package com.sec.chaton.network.pipeline;

import android.os.PowerManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.TcpContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.execution.ExecutionHandler;

/* loaded from: classes.dex */
public class TcpClientPipelineFactory implements ChannelPipelineFactory {

    /* renamed from: a */
    protected TcpContext f2563a;

    /* renamed from: b */
    protected TcpClientChannelHandler f2564b;

    /* renamed from: c */
    protected PowerManager.WakeLock f2565c;

    /* renamed from: d */
    private ExecutionHandler f2566d = null;

    public TcpClientPipelineFactory(TcpContext tcpContext, TcpClientChannelHandler tcpClientChannelHandler) {
        this.f2563a = tcpContext;
        this.f2564b = tcpClientChannelHandler;
        if (GlobalApplication.m2387e() != null) {
            this.f2565c = ((PowerManager) GlobalApplication.m2387e().getSystemService("power")).newWakeLock(1, "ChatON");
        }
    }

    @Override // org.jboss.netty.channel.ChannelPipelineFactory
    public ChannelPipeline getPipeline() {
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        channelPipelinePipeline.addLast("StreamEnvelopeDecoder", new StreamEnvelopeDecoder(this.f2565c));
        channelPipelinePipeline.addLast("EnvelopeStreamEncoder", new EnvelopeStreamEncoder(this.f2565c));
        channelPipelinePipeline.addLast("TcpEnvelopeBicoder", new TcpEnvelopeBicoder(this.f2563a, this.f2565c));
        if (this.f2566d != null) {
            channelPipelinePipeline.addLast("threadPoolHandler", this.f2566d);
        }
        channelPipelinePipeline.addLast("TcpClientPipelineFactory", this.f2564b);
        return channelPipelinePipeline;
    }
}
