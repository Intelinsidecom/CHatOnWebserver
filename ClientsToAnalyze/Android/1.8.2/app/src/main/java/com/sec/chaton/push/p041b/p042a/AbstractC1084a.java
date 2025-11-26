package com.sec.chaton.push.p041b.p042a;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.p040a.C1071a;
import com.sec.chaton.push.p040a.C1081k;
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
public abstract class AbstractC1084a {

    /* renamed from: a */
    protected Context f4007a;

    /* renamed from: b */
    protected ChannelFactory f4008b = new OioClientSocketChannelFactory(Executors.newCachedThreadPool());

    /* renamed from: c */
    protected ClientBootstrap f4009c = new ClientBootstrap(this.f4008b);

    /* renamed from: d */
    protected Channel f4010d;

    /* renamed from: e */
    private ConnectivityManager f4011e;

    /* renamed from: f */
    private ChannelFutureListener f4012f;

    /* renamed from: a */
    protected abstract ChannelPipelineFactory mo4138a();

    public AbstractC1084a(Context context) {
        this.f4007a = context;
        this.f4009c.setPipelineFactory(mo4138a());
        this.f4010d = null;
        this.f4011e = (ConnectivityManager) this.f4007a.getSystemService("connectivity");
        this.f4012f = new C1085b(this);
    }

    /* renamed from: a */
    public synchronized Channel mo4137a(String str, int i, boolean z) {
        if (this.f4010d != null) {
            throw new C1071a("The connection is already connected.");
        }
        if (!m4136d()) {
            throw new C1081k("Network isn't available");
        }
        ChannelFuture channelFutureConnect = this.f4009c.connect(new InetSocketAddress(str, i));
        if (!channelFutureConnect.awaitUninterruptibly(30000L)) {
            channelFutureConnect.cancel();
        }
        if (channelFutureConnect.isDone() && channelFutureConnect.isSuccess()) {
            this.f4010d = channelFutureConnect.getChannel();
            this.f4010d.getCloseFuture().addListener(this.f4012f);
        } else {
            this.f4010d = null;
            throw new C1071a("Fail connect to server.", channelFutureConnect.getCause());
        }
        return this.f4010d;
    }

    /* renamed from: b */
    public synchronized void mo4140b() {
        if (this.f4010d == null) {
            throw new C1071a("Connection is already disconnected.");
        }
        this.f4010d.getCloseFuture().removeListener(this.f4012f);
        this.f4010d.disconnect().awaitUninterruptibly(5000L);
        this.f4010d = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean m4141c() {
        /*
            r1 = this;
            monitor-enter(r1)
            org.jboss.netty.channel.Channel r0 = r1.f4010d     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            org.jboss.netty.channel.Channel r0 = r1.f4010d     // Catch: java.lang.Throwable -> L12
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.push.p041b.p042a.AbstractC1084a.m4141c():boolean");
    }

    /* renamed from: a */
    public synchronized void m4139a(GeneratedMessageLite generatedMessageLite) {
        if (this.f4010d == null) {
            throw new C1081k("Connection hadn't been established.");
        }
        this.f4010d.write(generatedMessageLite);
    }

    /* renamed from: d */
    private boolean m4136d() {
        return this.f4011e.getActiveNetworkInfo() != null;
    }
}
