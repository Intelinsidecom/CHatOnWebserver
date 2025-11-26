package com.sec.chaton.push.p091b.p093b;

import android.content.Context;
import android.os.PowerManager;
import com.sec.chaton.push.p094c.C3084e;
import com.sec.chaton.push.util.C3116h;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.ssl.SslHandler;

/* compiled from: PushConnectionPipelineFactory.java */
/* renamed from: com.sec.chaton.push.b.b.j */
/* loaded from: classes.dex */
public class C3070j implements ChannelPipelineFactory {

    /* renamed from: a */
    private static final String f11348a = C3070j.class.getSimpleName();

    /* renamed from: b */
    private Context f11349b;

    /* renamed from: c */
    private boolean f11350c;

    /* renamed from: d */
    private PowerManager.WakeLock f11351d;

    public C3070j(Context context, boolean z) {
        this.f11349b = context;
        this.f11350c = z;
        this.f11351d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, f11348a);
    }

    @Override // org.jboss.netty.channel.ChannelPipelineFactory
    public ChannelPipeline getPipeline() throws NoSuchAlgorithmException, KeyManagementException {
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        if (this.f11350c) {
            SSLContext sSLContext = SSLContext.getInstance("tls");
            sSLContext.init(C3116h.m12707a(this.f11349b).getKeyManagers(), C3116h.m12708b(this.f11349b).getTrustManagers(), null);
            SSLEngine sSLEngineCreateSSLEngine = sSLContext.createSSLEngine("samsung.com", 443);
            sSLEngineCreateSSLEngine.setUseClientMode(true);
            channelPipelinePipeline.addLast("ssl", new SslHandler(sSLEngineCreateSSLEngine));
        }
        channelPipelinePipeline.addLast("decoder", new C3065e(this.f11351d));
        channelPipelinePipeline.addLast("encoder", new C3068h(this.f11351d));
        C3063c c3063c = new C3063c();
        c3063c.m12531a(C3084e.m12562a());
        channelPipelinePipeline.addLast("message channel handler", c3063c);
        return channelPipelinePipeline;
    }
}
