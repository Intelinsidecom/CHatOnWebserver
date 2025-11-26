package com.sec.chaton.push.network.connection;

import com.sec.chaton.push.network.connection.AbstractConnectionManager;
import com.sec.chaton.push.util.PushLog;
import java.util.Iterator;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;

/* renamed from: com.sec.chaton.push.network.connection.a */
/* loaded from: classes.dex */
class C0394a implements ChannelFutureListener {

    /* renamed from: a */
    final /* synthetic */ AbstractConnectionManager f2750a;

    C0394a(AbstractConnectionManager abstractConnectionManager) {
        this.f2750a = abstractConnectionManager;
    }

    @Override // org.jboss.netty.channel.ChannelFutureListener
    public void operationComplete(ChannelFuture channelFuture) {
        synchronized (this.f2750a) {
            if (this.f2750a.f2746d == null) {
                return;
            }
            PushLog.m3025a(AbstractConnectionManager.f2742f, "Connection is closed by system.");
            this.f2750a.f2746d.getCloseFuture().removeListener(this.f2750a.f2749h);
            this.f2750a.f2746d = null;
            Iterator it = this.f2750a.f2747e.iterator();
            while (it.hasNext()) {
                try {
                    ((AbstractConnectionManager.OnConnectionChangedListener) it.next()).mo2961a();
                } catch (Exception e) {
                    PushLog.m3026a(AbstractConnectionManager.f2742f, "Unexcepted exception on onDisconnected() method.", e);
                }
            }
        }
    }
}
