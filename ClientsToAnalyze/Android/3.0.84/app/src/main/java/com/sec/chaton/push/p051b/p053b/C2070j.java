package com.sec.chaton.push.p051b.p053b;

import android.content.Context;
import android.os.PowerManager;
import com.sec.chaton.push.p054c.C2084e;
import com.sec.chaton.push.util.C2116h;
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
public class C2070j implements ChannelPipelineFactory {

    /* renamed from: a */
    private static final String f7938a = C2070j.class.getSimpleName();

    /* renamed from: b */
    private Context f7939b;

    /* renamed from: c */
    private boolean f7940c;

    /* renamed from: d */
    private PowerManager.WakeLock f7941d;

    public C2070j(Context context, boolean z) {
        this.f7939b = context;
        this.f7940c = z;
        this.f7941d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, f7938a);
    }

    @Override // org.jboss.netty.channel.ChannelPipelineFactory
    public ChannelPipeline getPipeline() throws NoSuchAlgorithmException, KeyManagementException {
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        if (this.f7940c) {
            SSLContext sSLContext = SSLContext.getInstance("tls");
            sSLContext.init(C2116h.m8365a(this.f7939b).getKeyManagers(), C2116h.m8366b(this.f7939b).getTrustManagers(), null);
            SSLEngine sSLEngineCreateSSLEngine = sSLContext.createSSLEngine("samsung.com", 443);
            sSLEngineCreateSSLEngine.setUseClientMode(true);
            channelPipelinePipeline.addLast("ssl", new SslHandler(sSLEngineCreateSSLEngine));
        }
        channelPipelinePipeline.addLast("decoder", new C2065e(this.f7941d));
        channelPipelinePipeline.addLast("encoder", new C2068h(this.f7941d));
        C2063c c2063c = new C2063c();
        c2063c.m8188a(C2084e.m8219a());
        channelPipelinePipeline.addLast("message channel handler", c2063c);
        return channelPipelinePipeline;
    }
}
