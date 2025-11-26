package com.sec.common.p056b.p059c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.common.p056b.C1825d;
import com.sec.common.p056b.p060d.C1828c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Callable;

/* compiled from: ResourceDispatcher.java */
/* renamed from: com.sec.common.b.c.d */
/* loaded from: classes.dex */
public class HandlerC1823d extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1821b f6534a;

    /* renamed from: b */
    private final int f6535b;

    /* renamed from: c */
    private final int f6536c;

    /* renamed from: d */
    private final int f6537d;

    /* renamed from: e */
    private final C1821b f6538e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1823d(C1821b c1821b, C1821b c1821b2, Looper looper) {
        super(looper);
        this.f6534a = c1821b;
        this.f6535b = 0;
        this.f6536c = 1;
        this.f6537d = 100;
        this.f6538e = c1821b2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        AbstractRunnableC1820a abstractRunnableC1820a;
        super.handleMessage(message);
        synchronized (this.f6538e.f6530e) {
            Callable callable = null;
            if (message.what == 100) {
                Object[] objArr = (Object[]) message.obj;
                abstractRunnableC1820a = (AbstractRunnableC1820a) objArr[0];
                callable = (Callable) objArr[1];
            } else {
                abstractRunnableC1820a = (AbstractRunnableC1820a) message.obj;
            }
            AbstractRunnableC1820a abstractRunnableC1820a2 = (AbstractRunnableC1820a) this.f6538e.f6527a.get(abstractRunnableC1820a.mo3775i());
            if (abstractRunnableC1820a2 == null || !abstractRunnableC1820a2.equals(abstractRunnableC1820a)) {
                this.f6534a.m6189c(abstractRunnableC1820a);
            } else if (message.what == 100) {
                try {
                    callable.call();
                } catch (Exception e) {
                    if (C1825d.f6539a.f6543d) {
                        PrintWriter printWriter = new PrintWriter(new StringWriter());
                        e.printStackTrace(printWriter);
                        C1825d.f6539a.m6202b(C1821b.f6526c, C1828c.m6207a("Callable.call() method throws exception.", printWriter.toString()));
                    }
                }
            } else {
                if (message.what == 0) {
                    this.f6534a.f6532g.mo6167a(abstractRunnableC1820a.m6178j(), abstractRunnableC1820a.mo3774h());
                }
                if (this.f6534a.f6533h != null) {
                    if (abstractRunnableC1820a.m6181m()) {
                        if (this.f6534a.f6533h != null) {
                            this.f6534a.f6533h.mo3702b(abstractRunnableC1820a.mo3775i(), abstractRunnableC1820a);
                        }
                    } else if (this.f6534a.f6533h != null) {
                        this.f6534a.f6533h.mo3701a(abstractRunnableC1820a.mo3775i(), abstractRunnableC1820a);
                    }
                }
                abstractRunnableC1820a.mo3767a(abstractRunnableC1820a.mo3774h(), false);
            }
        }
    }

    /* renamed from: a */
    void m6198a(AbstractRunnableC1820a abstractRunnableC1820a, Callable callable) {
        m6199a(abstractRunnableC1820a, callable, 0L);
    }

    /* renamed from: a */
    void m6199a(AbstractRunnableC1820a abstractRunnableC1820a, Callable callable, long j) {
        removeMessages(abstractRunnableC1820a.hashCode());
        sendMessageDelayed(Message.obtain(this, 100, new Object[]{abstractRunnableC1820a, callable}), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6196a(AbstractRunnableC1820a abstractRunnableC1820a, boolean z) {
        removeMessages(abstractRunnableC1820a.hashCode());
        if (z) {
            sendMessage(Message.obtain(this, 0, abstractRunnableC1820a));
        } else {
            sendMessage(Message.obtain(this, 1, abstractRunnableC1820a));
        }
    }
}
