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

/* compiled from: PushConnectionPipelineFactory.java */
/* renamed from: com.sec.chaton.push.b.b.j */
/* loaded from: classes.dex */
public class C1097j implements ChannelPipelineFactory {

    /* renamed from: a */
    private static final String f4035a = C1097j.class.getSimpleName();

    /* renamed from: b */
    private Context f4036b;

    /* renamed from: c */
    private boolean f4037c;

    /* renamed from: d */
    private PowerManager.WakeLock f4038d;

    public C1097j(Context context, boolean z) {
        this.f4036b = context;
        this.f4037c = z;
        this.f4038d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, f4035a);
    }

    @Override // org.jboss.netty.channel.ChannelPipelineFactory
    public ChannelPipeline getPipeline() throws NoSuchAlgorithmException, KeyManagementException {
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        if (this.f4037c) {
            SSLContext sSLContext = SSLContext.getInstance("tls");
            sSLContext.init(C1140h.m4314a(this.f4036b).getKeyManagers(), C1140h.m4315b(this.f4036b).getTrustManagers(), null);
            SSLEngine sSLEngineCreateSSLEngine = sSLContext.createSSLEngine("samsung.com", 443);
            sSLEngineCreateSSLEngine.setUseClientMode(true);
            channelPipelinePipeline.addLast("ssl", new SslHandler(sSLEngineCreateSSLEngine));
        }
        channelPipelinePipeline.addLast("decoder", new C1092e(this.f4038d));
        channelPipelinePipeline.addLast("encoder", new C1095h(this.f4038d));
        C1090c c1090c = new C1090c();
        c1090c.m4145a(C1111e.m4174a());
        channelPipelinePipeline.addLast("message channel handler", c1090c);
        return channelPipelinePipeline;
    }
}
