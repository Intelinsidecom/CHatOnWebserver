package com.sec.chaton.push.network.connection;

import android.content.Context;
import android.net.ConnectivityManager;
import com.sec.chaton.push.exception.ConnectionException;
import com.sec.chaton.push.exception.NetworkNotAvailableException;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.util.PushLog;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.socket.oio.OioClientSocketChannelFactory;

/* loaded from: classes.dex */
public abstract class AbstractConnectionManager {

    /* renamed from: f */
    private static final String f2742f = AbstractConnectionManager.class.getSimpleName();

    /* renamed from: a */
    protected Context f2743a;

    /* renamed from: b */
    protected ChannelFactory f2744b = new OioClientSocketChannelFactory(Executors.newCachedThreadPool());

    /* renamed from: c */
    protected ClientBootstrap f2745c = new ClientBootstrap(this.f2744b);

    /* renamed from: d */
    protected Channel f2746d;

    /* renamed from: e */
    protected ArrayList f2747e;

    /* renamed from: g */
    private ConnectivityManager f2748g;

    /* renamed from: h */
    private ChannelFutureListener f2749h;

    public interface OnConnectionChangedListener {
        /* renamed from: a */
        void mo2961a();

        /* renamed from: b */
        void mo2962b();
    }

    public AbstractConnectionManager(Context context) {
        this.f2743a = context;
        this.f2745c.setPipelineFactory(mo2978a());
        this.f2746d = null;
        this.f2748g = (ConnectivityManager) this.f2743a.getSystemService("connectivity");
        this.f2747e = new ArrayList();
        this.f2749h = new C0394a(this);
    }

    /* renamed from: f */
    private boolean m2977f() {
        return this.f2748g.getActiveNetworkInfo() != null;
    }

    /* renamed from: a */
    protected abstract ChannelPipelineFactory mo2978a();

    /* renamed from: a */
    public synchronized void m2979a(MessageContext messageContext) {
        if (this.f2746d == null) {
            messageContext.m2970a(-2);
        } else {
            this.f2746d.write(messageContext);
        }
    }

    /* renamed from: a */
    public void m2980a(OnConnectionChangedListener onConnectionChangedListener) {
        this.f2747e.add(onConnectionChangedListener);
    }

    /* renamed from: a */
    public synchronized void m2981a(String str, int i, boolean z) {
        if (this.f2746d != null) {
            throw new ConnectionException("The connection is already connected.");
        }
        if (!m2977f()) {
            throw new NetworkNotAvailableException("Network isn't available");
        }
        ChannelFuture channelFutureConnect = this.f2745c.connect(new InetSocketAddress(str, i));
        if (!channelFutureConnect.awaitUninterruptibly(30000L)) {
            channelFutureConnect.cancel();
        }
        if (!channelFutureConnect.isDone() || !channelFutureConnect.isSuccess()) {
            this.f2746d = null;
            throw new ConnectionException("Fail connect to server.", channelFutureConnect.getCause());
        }
        this.f2746d = channelFutureConnect.getChannel();
        this.f2746d.getCloseFuture().addListener(this.f2749h);
        Iterator it = this.f2747e.iterator();
        while (it.hasNext()) {
            try {
                ((OnConnectionChangedListener) it.next()).mo2962b();
            } catch (Exception e) {
                PushLog.m3026a(f2742f, "Unexcepted exception on onConnected() method.", e);
            }
        }
    }

    /* renamed from: b */
    public synchronized void m2982b() {
        if (this.f2746d == null) {
            throw new ConnectionException("Connection is already disconnected.");
        }
        this.f2746d.getCloseFuture().removeListener(this.f2749h);
        this.f2746d.disconnect().awaitUninterruptibly(5000L);
        this.f2746d = null;
        Iterator it = this.f2747e.iterator();
        while (it.hasNext()) {
            try {
                ((OnConnectionChangedListener) it.next()).mo2961a();
            } catch (Exception e) {
                PushLog.m3026a(f2742f, "Unexcepted exception on onDisconnected() method.", e);
            }
        }
    }

    /* renamed from: c */
    public synchronized Channel m2983c() {
        return this.f2746d;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean m2984d() {
        /*
            r1 = this;
            monitor-enter(r1)
            org.jboss.netty.channel.Channel r0 = r1.f2746d     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            org.jboss.netty.channel.Channel r0 = r1.f2746d     // Catch: java.lang.Throwable -> L12
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.push.network.connection.AbstractConnectionManager.m2984d():boolean");
    }
}
