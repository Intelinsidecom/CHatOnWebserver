package com.sec.common.p069e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.common.C3330f;
import com.sec.common.util.C3364o;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Callable;

/* compiled from: ResourceDispatcher.java */
/* renamed from: com.sec.common.e.e */
/* loaded from: classes.dex */
public class HandlerC3328e extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3326c f12028a;

    /* renamed from: b */
    private final int f12029b;

    /* renamed from: c */
    private final int f12030c;

    /* renamed from: d */
    private final int f12031d;

    /* renamed from: e */
    private final C3326c f12032e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC3328e(C3326c c3326c, C3326c c3326c2, Looper looper) {
        super(looper);
        this.f12028a = c3326c;
        this.f12029b = 0;
        this.f12030c = 1;
        this.f12031d = 100;
        this.f12032e = c3326c2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        AbstractRunnableC3324a<?> abstractRunnableC3324a;
        super.handleMessage(message);
        synchronized (this.f12032e.f12024e) {
            Callable callable = null;
            if (message.what == 100) {
                Object[] objArr = (Object[]) message.obj;
                abstractRunnableC3324a = (AbstractRunnableC3324a) objArr[0];
                callable = (Callable) objArr[1];
            } else {
                abstractRunnableC3324a = (AbstractRunnableC3324a) message.obj;
            }
            AbstractRunnableC3324a<?> abstractRunnableC3324a2 = this.f12032e.f12021a.get(abstractRunnableC3324a.mo4338h());
            if (abstractRunnableC3324a2 == null || !abstractRunnableC3324a2.equals(abstractRunnableC3324a)) {
                this.f12028a.m11729c(abstractRunnableC3324a);
            } else if (message.what == 100) {
                try {
                    callable.call();
                } catch (Exception e) {
                    if (C3330f.f12033a.f11974d) {
                        PrintWriter printWriter = new PrintWriter(new StringWriter());
                        e.printStackTrace(printWriter);
                        C3330f.f12033a.m11656c(C3326c.f12020c, C3364o.m11849a("Callable.call() method throws exception.", printWriter.toString()));
                    }
                }
            } else {
                if (message.what == 0) {
                    this.f12028a.f12026g.mo11650a(abstractRunnableC3324a.mo7454i(), abstractRunnableC3324a.mo4337g());
                }
                if (this.f12028a.f12027h != null) {
                    if (abstractRunnableC3324a.m11716m()) {
                        this.f12028a.f12027h.mo3722b(abstractRunnableC3324a.mo4338h(), abstractRunnableC3324a);
                    } else {
                        this.f12028a.f12027h.mo3713a(abstractRunnableC3324a.mo4338h(), abstractRunnableC3324a);
                    }
                }
                abstractRunnableC3324a.mo4331a(abstractRunnableC3324a.mo4337g(), false);
            }
        }
    }

    /* renamed from: a */
    void m11738a(AbstractRunnableC3324a<?> abstractRunnableC3324a, Callable<Void> callable) {
        m11739a(abstractRunnableC3324a, callable, 0L);
    }

    /* renamed from: a */
    void m11739a(AbstractRunnableC3324a<?> abstractRunnableC3324a, Callable<Void> callable, long j) {
        removeMessages(abstractRunnableC3324a.hashCode());
        sendMessageDelayed(Message.obtain(this, 100, new Object[]{abstractRunnableC3324a, callable}), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11736a(AbstractRunnableC3324a<?> abstractRunnableC3324a, boolean z) {
        removeMessages(abstractRunnableC3324a.hashCode());
        if (z) {
            sendMessage(Message.obtain(this, 0, abstractRunnableC3324a));
        } else {
            sendMessage(Message.obtain(this, 1, abstractRunnableC3324a));
        }
    }
}
