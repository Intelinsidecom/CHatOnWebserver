package com.sec.chaton.push.p035a.p037b;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.p038b.C0872e;
import com.sec.chaton.push.p038b.C0874g;
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
/* renamed from: com.sec.chaton.push.a.b.c */
/* loaded from: classes.dex */
public abstract class AbstractC0865c {

    /* renamed from: a */
    protected Context f2989a;

    /* renamed from: b */
    protected ChannelFactory f2990b = new OioClientSocketChannelFactory(Executors.newCachedThreadPool());

    /* renamed from: c */
    protected ClientBootstrap f2991c = new ClientBootstrap(this.f2990b);

    /* renamed from: d */
    protected Channel f2992d;

    /* renamed from: e */
    private ConnectivityManager f2993e;

    /* renamed from: f */
    private ChannelFutureListener f2994f;

    /* renamed from: a */
    protected abstract ChannelPipelineFactory mo3456a();

    public AbstractC0865c(Context context) {
        this.f2989a = context;
        this.f2991c.setPipelineFactory(mo3456a());
        this.f2992d = null;
        this.f2993e = (ConnectivityManager) this.f2989a.getSystemService("connectivity");
        this.f2994f = new C0863a(this);
    }

    /* renamed from: a */
    public synchronized Channel mo3455a(String str, int i, boolean z) {
        if (this.f2992d != null) {
            throw new C0872e("The connection is already connected.");
        }
        if (!m3458d()) {
            throw new C0874g("Network isn't available");
        }
        ChannelFuture channelFutureConnect = this.f2991c.connect(new InetSocketAddress(str, i));
        if (!channelFutureConnect.awaitUninterruptibly(30000L)) {
            channelFutureConnect.cancel();
        }
        if (channelFutureConnect.isDone() && channelFutureConnect.isSuccess()) {
            this.f2992d = channelFutureConnect.getChannel();
            this.f2992d.getCloseFuture().addListener(this.f2994f);
        } else {
            this.f2992d = null;
            throw new C0872e("Fail connect to server.", channelFutureConnect.getCause());
        }
        return this.f2992d;
    }

    /* renamed from: b */
    public synchronized void mo3457b() {
        if (this.f2992d == null) {
            throw new C0872e("Connection is already disconnected.");
        }
        this.f2992d.getCloseFuture().removeListener(this.f2994f);
        this.f2992d.disconnect().awaitUninterruptibly(5000L);
        this.f2992d = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean m3460c() {
        /*
            r1 = this;
            monitor-enter(r1)
            org.jboss.netty.channel.Channel r0 = r1.f2992d     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            org.jboss.netty.channel.Channel r0 = r1.f2992d     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            r0 = 1
        Le:
            monitor-exit(r1)
            return r0
        L10:
            r0 = 0
            goto Le
        L12:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.push.p035a.p037b.AbstractC0865c.m3460c():boolean");
    }

    /* renamed from: a */
    public synchronized void m3459a(GeneratedMessageLite generatedMessageLite) {
        if (this.f2992d == null) {
            throw new C0874g("Connection hadn't been established.");
        }
        this.f2992d.write(generatedMessageLite);
    }

    /* renamed from: d */
    private boolean m3458d() {
        return this.f2993e.getActiveNetworkInfo() != null;
    }
}
