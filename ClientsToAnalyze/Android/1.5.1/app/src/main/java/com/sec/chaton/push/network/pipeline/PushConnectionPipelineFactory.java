package com.sec.chaton.push.network.pipeline;

import android.content.Context;
import android.os.PowerManager;
import com.sec.chaton.push.message.processer.MessageController;
import com.sec.chaton.push.util.SecurityUtil;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.ssl.SslHandler;

/* loaded from: classes.dex */
public class PushConnectionPipelineFactory implements ChannelPipelineFactory {

    /* renamed from: a */
    private static final String f2766a = PushConnectionPipelineFactory.class.getSimpleName();

    /* renamed from: b */
    private Context f2767b;

    /* renamed from: c */
    private boolean f2768c;

    /* renamed from: d */
    private PowerManager.WakeLock f2769d;

    public PushConnectionPipelineFactory(Context context, boolean z) {
        this.f2767b = context;
        this.f2768c = z;
        this.f2769d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, MessageController.class.getSimpleName());
    }

    @Override // org.jboss.netty.channel.ChannelPipelineFactory
    public ChannelPipeline getPipeline() throws NoSuchAlgorithmException, KeyManagementException {
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        if (this.f2768c) {
            SSLContext sSLContext = SSLContext.getInstance("tls");
            sSLContext.init(SecurityUtil.m3036a(this.f2767b).getKeyManagers(), SecurityUtil.m3037b(this.f2767b).getTrustManagers(), null);
            SSLEngine sSLEngineCreateSSLEngine = sSLContext.createSSLEngine("samsung.com", 443);
            sSLEngineCreateSSLEngine.setUseClientMode(true);
            channelPipelinePipeline.addLast("ssl", new SslHandler(sSLEngineCreateSSLEngine));
        }
        channelPipelinePipeline.addLast("decoder", new MessageDecoder(this.f2769d));
        channelPipelinePipeline.addLast("encoder", new MessageEncoder(this.f2769d));
        channelPipelinePipeline.addLast("message channel handler", new PushMessageChannelHandler());
        return channelPipelinePipeline;
    }
}
