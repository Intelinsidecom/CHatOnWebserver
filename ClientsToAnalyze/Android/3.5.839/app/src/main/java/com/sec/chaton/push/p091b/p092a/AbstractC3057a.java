package com.sec.chaton.push.p091b.p092a;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.p090a.C3044a;
import com.sec.chaton.push.p090a.C3054k;
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
public abstract class AbstractC3057a {

    /* renamed from: a */
    protected Context f11320a;

    /* renamed from: b */
    protected ChannelFactory f11321b = new OioClientSocketChannelFactory(Executors.newCachedThreadPool());

    /* renamed from: c */
    protected ClientBootstrap f11322c = new ClientBootstrap(this.f11321b);

    /* renamed from: d */
    protected Channel f11323d;

    /* renamed from: e */
    private ConnectivityManager f11324e;

    /* renamed from: f */
    private ChannelFutureListener f11325f;

    /* renamed from: a */
    protected abstract ChannelPipelineFactory mo12524a();

    public AbstractC3057a(Context context) {
        this.f11320a = context;
        this.f11322c.setPipelineFactory(mo12524a());
        this.f11322c.setOption("connectTimeoutMillis", 30000L);
        this.f11323d = null;
        this.f11324e = (ConnectivityManager) this.f11320a.getSystemService("connectivity");
        this.f11325f = new C3058b(this);
    }

    /* renamed from: a */
    public synchronized Channel mo12523a(String str, int i, boolean z) {
        if (this.f11323d != null) {
            throw new C3044a("The connection is already connected.");
        }
        if (!m12522c()) {
            throw new C3054k("Network isn't available");
        }
        this.f11322c.setOption("connectTimeoutMillis", 30000L);
        ChannelFuture channelFutureConnect = this.f11322c.connect(new InetSocketAddress(str, i));
        channelFutureConnect.awaitUninterruptibly();
        if (channelFutureConnect.isDone() && channelFutureConnect.isSuccess()) {
            this.f11323d = channelFutureConnect.getChannel();
            this.f11323d.getCloseFuture().addListener(this.f11325f);
        } else {
            this.f11323d = null;
            throw new C3044a("Fail connect to server.", channelFutureConnect.getCause());
        }
        return this.f11323d;
    }

    /* renamed from: b */
    public synchronized void mo12527b() {
        if (this.f11323d == null) {
            throw new C3044a("Connection is already disconnected.");
        }
        this.f11323d.getCloseFuture().removeListener(this.f11325f);
        this.f11323d.disconnect().awaitUninterruptibly(5000L);
        this.f11323d = null;
    }

    /* renamed from: a */
    public boolean m12526a(boolean z) {
        boolean z2 = true;
        if (!z) {
            return this.f11323d != null && this.f11323d.isConnected();
        }
        synchronized (this) {
            if (this.f11323d == null || !this.f11323d.isConnected()) {
                z2 = false;
            }
        }
        return z2;
    }

    /* renamed from: a */
    public synchronized void m12525a(GeneratedMessageLite generatedMessageLite) {
        if (this.f11323d == null) {
            throw new C3054k("Connection hadn't been established.");
        }
        this.f11323d.write(generatedMessageLite);
    }

    /* renamed from: c */
    private boolean m12522c() {
        return this.f11324e.getActiveNetworkInfo() != null;
    }
}
