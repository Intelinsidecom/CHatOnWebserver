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

/* compiled from: ProvConnectionPipelineFactory.java */
/* renamed from: com.sec.chaton.push.a.a.f */
/* loaded from: classes.dex */
public class C0858f implements ChannelPipelineFactory {

    /* renamed from: a */
    private static final String f2972a = C0858f.class.getSimpleName();

    /* renamed from: b */
    private Context f2973b;

    /* renamed from: c */
    private boolean f2974c;

    /* renamed from: d */
    private PowerManager.WakeLock f2975d;

    public C0858f(Context context, boolean z) {
        this.f2973b = context;
        this.f2974c = z;
        this.f2975d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, f2972a);
    }

    @Override // org.jboss.netty.channel.ChannelPipelineFactory
    public ChannelPipeline getPipeline() throws NoSuchAlgorithmException, KeyManagementException {
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        if (this.f2974c) {
            SSLContext sSLContext = SSLContext.getInstance("tls");
            sSLContext.init(C0916b.m3612a(this.f2973b).getKeyManagers(), C0916b.m3613b(this.f2973b).getTrustManagers(), null);
            SSLEngine sSLEngineCreateSSLEngine = sSLContext.createSSLEngine("samsung.com", 443);
            sSLEngineCreateSSLEngine.setUseClientMode(true);
            channelPipelinePipeline.addLast("ssl", new SslHandler(sSLEngineCreateSSLEngine));
        }
        channelPipelinePipeline.addLast("decoder", new C0856d(this.f2975d));
        channelPipelinePipeline.addLast("encoder", new C0854b(this.f2975d));
        C0859g c0859g = new C0859g();
        c0859g.m3453a(C0893e.m3502a());
        channelPipelinePipeline.addLast("message channel handler", c0859g);
        return channelPipelinePipeline;
    }
}
