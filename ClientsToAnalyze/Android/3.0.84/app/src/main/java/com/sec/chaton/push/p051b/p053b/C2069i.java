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

/* compiled from: ProvConnectionPipelineFactory.java */
/* renamed from: com.sec.chaton.push.b.b.i */
/* loaded from: classes.dex */
public class C2069i implements ChannelPipelineFactory {

    /* renamed from: a */
    private static final String f7934a = C2069i.class.getSimpleName();

    /* renamed from: b */
    private Context f7935b;

    /* renamed from: c */
    private boolean f7936c;

    /* renamed from: d */
    private PowerManager.WakeLock f7937d;

    public C2069i(Context context, boolean z) {
        this.f7935b = context;
        this.f7936c = z;
        this.f7937d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, f7934a);
    }

    @Override // org.jboss.netty.channel.ChannelPipelineFactory
    public ChannelPipeline getPipeline() throws NoSuchAlgorithmException, KeyManagementException {
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        if (this.f7936c) {
            SSLContext sSLContext = SSLContext.getInstance("tls");
            sSLContext.init(C2116h.m8365a(this.f7935b).getKeyManagers(), C2116h.m8366b(this.f7935b).getTrustManagers(), null);
            SSLEngine sSLEngineCreateSSLEngine = sSLContext.createSSLEngine("samsung.com", 443);
            sSLEngineCreateSSLEngine.setUseClientMode(true);
            channelPipelinePipeline.addLast("ssl", new SslHandler(sSLEngineCreateSSLEngine));
        }
        channelPipelinePipeline.addLast("decoder", new C2065e(this.f7937d));
        channelPipelinePipeline.addLast("encoder", new C2068h(this.f7937d));
        C2063c c2063c = new C2063c();
        c2063c.m8188a(C2084e.m8219a());
        channelPipelinePipeline.addLast("message channel handler", c2063c);
        return channelPipelinePipeline;
    }
}
