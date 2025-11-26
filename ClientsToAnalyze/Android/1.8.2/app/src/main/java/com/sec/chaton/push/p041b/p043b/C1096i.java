package com.sec.chaton.push.p041b.p043b;

import android.content.Context;
import android.os.PowerManager;
import com.sec.chaton.push.p044c.C1111e;
import com.sec.chaton.push.util.C1140h;
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
public class C1096i implements ChannelPipelineFactory {

    /* renamed from: a */
    private static final String f4031a = C1096i.class.getSimpleName();

    /* renamed from: b */
    private Context f4032b;

    /* renamed from: c */
    private boolean f4033c;

    /* renamed from: d */
    private PowerManager.WakeLock f4034d;

    public C1096i(Context context, boolean z) {
        this.f4032b = context;
        this.f4033c = z;
        this.f4034d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, f4031a);
    }

    @Override // org.jboss.netty.channel.ChannelPipelineFactory
    public ChannelPipeline getPipeline() throws NoSuchAlgorithmException, KeyManagementException {
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        if (this.f4033c) {
            SSLContext sSLContext = SSLContext.getInstance("tls");
            sSLContext.init(C1140h.m4314a(this.f4032b).getKeyManagers(), C1140h.m4315b(this.f4032b).getTrustManagers(), null);
            SSLEngine sSLEngineCreateSSLEngine = sSLContext.createSSLEngine("samsung.com", 443);
            sSLEngineCreateSSLEngine.setUseClientMode(true);
            channelPipelinePipeline.addLast("ssl", new SslHandler(sSLEngineCreateSSLEngine));
        }
        channelPipelinePipeline.addLast("decoder", new C1092e(this.f4034d));
        channelPipelinePipeline.addLast("encoder", new C1095h(this.f4034d));
        C1090c c1090c = new C1090c();
        c1090c.m4145a(C1111e.m4174a());
        channelPipelinePipeline.addLast("message channel handler", c1090c);
        return channelPipelinePipeline;
    }
}
