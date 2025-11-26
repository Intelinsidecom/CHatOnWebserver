package com.sec.chaton.push.p035a.p036a;

import android.content.Context;
import android.os.PowerManager;
import com.sec.chaton.push.p039c.C0893e;
import com.sec.chaton.push.util.C0916b;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.ssl.SslHandler;

/* compiled from: PushConnectionPipelineFactory.java */
/* renamed from: com.sec.chaton.push.a.a.i */
/* loaded from: classes.dex */
public class C0861i implements ChannelPipelineFactory {

    /* renamed from: a */
    private static final String f2984a = C0861i.class.getSimpleName();

    /* renamed from: b */
    private Context f2985b;

    /* renamed from: c */
    private boolean f2986c;

    /* renamed from: d */
    private PowerManager.WakeLock f2987d;

    public C0861i(Context context, boolean z) {
        this.f2985b = context;
        this.f2986c = z;
        this.f2987d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, f2984a);
    }

    @Override // org.jboss.netty.channel.ChannelPipelineFactory
    public ChannelPipeline getPipeline() throws NoSuchAlgorithmException, KeyManagementException {
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        if (this.f2986c) {
            SSLContext sSLContext = SSLContext.getInstance("tls");
            sSLContext.init(C0916b.m3612a(this.f2985b).getKeyManagers(), C0916b.m3613b(this.f2985b).getTrustManagers(), null);
            SSLEngine sSLEngineCreateSSLEngine = sSLContext.createSSLEngine("samsung.com", 443);
            sSLEngineCreateSSLEngine.setUseClientMode(true);
            channelPipelinePipeline.addLast("ssl", new SslHandler(sSLEngineCreateSSLEngine));
        }
        channelPipelinePipeline.addLast("decoder", new C0856d(this.f2987d));
        channelPipelinePipeline.addLast("encoder", new C0854b(this.f2987d));
        C0859g c0859g = new C0859g();
        c0859g.m3453a(C0893e.m3502a());
        channelPipelinePipeline.addLast("message channel handler", c0859g);
        return channelPipelinePipeline;
    }
}
