package com.sec.chaton.push.p051b.p052a;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.p050a.C2044a;
import com.sec.chaton.push.p050a.C2054k;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.socket.oio.OioClientSocketChannelFactory;

/* compiled from: AbstractConnectionManager.java */
/* renamed from: com.sec.chaton.push.b.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC2057a {

    /* renamed from: a */
    protected Context f7910a;

    /* renamed from: b */
    protected ChannelFactory f7911b = new OioClientSocketChannelFactory(Executors.newCachedThreadPool());

    /* renamed from: c */
    protected ClientBootstrap f7912c = new ClientBootstrap(this.f7911b);

    /* renamed from: d */
    protected Channel f7913d;

    /* renamed from: e */
    private ConnectivityManager f7914e;

    /* renamed from: f */
    private ChannelFutureListener f7915f;

    /* renamed from: a */
    protected abstract ChannelPipelineFactory mo8181a();

    public AbstractC2057a(Context context) {
        this.f7910a = context;
        this.f7912c.setPipelineFactory(mo8181a());
        this.f7912c.setOption("connectTimeoutMillis", 30000L);
        this.f7913d = null;
        this.f7914e = (ConnectivityManager) this.f7910a.getSystemService("connectivity");
        this.f7915f = new C2058b(this);
    }

    /* renamed from: a */
    public synchronized Channel mo8180a(String str, int i, boolean z) {
        if (this.f7913d != null) {
            throw new C2044a("The connection is already connected.");
        }
        if (!m8179c()) {
            throw new C2054k("Network isn't available");
        }
        this.f7912c.setOption("connectTimeoutMillis", 30000L);
        ChannelFuture channelFutureConnect = this.f7912c.connect(new InetSocketAddress(str, i));
        channelFutureConnect.awaitUninterruptibly();
        if (channelFutureConnect.isDone() && channelFutureConnect.isSuccess()) {
            this.f7913d = channelFutureConnect.getChannel();
            this.f7913d.getCloseFuture().addListener(this.f7915f);
        } else {
            this.f7913d = null;
            throw new C2044a("Fail connect to server.", channelFutureConnect.getCause());
        }
        return this.f7913d;
    }

    /* renamed from: b */
    public synchronized void mo8184b() {
        if (this.f7913d == null) {
            throw new C2044a("Connection is already disconnected.");
        }
        this.f7913d.getCloseFuture().removeListener(this.f7915f);
        this.f7913d.disconnect().awaitUninterruptibly(5000L);
        this.f7913d = null;
    }

    /* renamed from: a */
    public boolean m8183a(boolean z) {
        boolean z2 = true;
        if (!z) {
            return this.f7913d != null && this.f7913d.isConnected();
        }
        synchronized (this) {
            if (this.f7913d == null || !this.f7913d.isConnected()) {
                z2 = false;
            }
        }
        return z2;
    }

    /* renamed from: a */
    public synchronized void m8182a(GeneratedMessageLite generatedMessageLite) {
        if (this.f7913d == null) {
            throw new C2054k("Connection hadn't been established.");
        }
        this.f7913d.write(generatedMessageLite);
    }

    /* renamed from: c */
    private boolean m8179c() {
        return this.f7914e.getActiveNetworkInfo() != null;
    }
}
