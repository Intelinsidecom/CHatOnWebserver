package com.sec.p007b.p008a.p011c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.p007b.p008a.C0111b;
import com.sec.p007b.p008a.p010b.C0114c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Callable;

/* compiled from: ResourceDispatcher.java */
/* renamed from: com.sec.b.a.c.b */
/* loaded from: classes.dex */
public class HandlerC0117b extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0119d f214a;

    /* renamed from: b */
    private final int f215b;

    /* renamed from: c */
    private final int f216c;

    /* renamed from: d */
    private final int f217d;

    /* renamed from: e */
    private final C0119d f218e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0117b(C0119d c0119d, C0119d c0119d2, Looper looper) {
        super(looper);
        this.f214a = c0119d;
        this.f215b = 0;
        this.f216c = 1;
        this.f217d = 100;
        this.f218e = c0119d2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        AbstractRunnableC0120e abstractRunnableC0120e;
        super.handleMessage(message);
        synchronized (this.f218e.f224e) {
            Callable callable = null;
            if (message.what == 100) {
                Object[] objArr = (Object[]) message.obj;
                abstractRunnableC0120e = (AbstractRunnableC0120e) objArr[0];
                callable = (Callable) objArr[1];
            } else {
                abstractRunnableC0120e = (AbstractRunnableC0120e) message.obj;
            }
            AbstractRunnableC0120e abstractRunnableC0120e2 = (AbstractRunnableC0120e) this.f218e.f221a.get(abstractRunnableC0120e.mo612e());
            if (abstractRunnableC0120e2 == null || !abstractRunnableC0120e2.equals(abstractRunnableC0120e)) {
                this.f214a.m600c(abstractRunnableC0120e);
            } else if (message.what == 100) {
                try {
                    callable.call();
                } catch (Exception e) {
                    if (C0111b.f208a.f212d) {
                        PrintWriter printWriter = new PrintWriter(new StringWriter());
                        e.printStackTrace(printWriter);
                        C0111b.f208a.m586d(C0119d.f220c, C0114c.m587a("Callable.call() method throws exception.", printWriter.toString()));
                    }
                }
            } else {
                this.f218e.f221a.remove(abstractRunnableC0120e.mo612e());
                if (message.what == 0) {
                    this.f214a.f227h.mo581a(abstractRunnableC0120e.m613f(), abstractRunnableC0120e.m614g());
                }
                if (this.f214a.f228i != null) {
                    if (abstractRunnableC0120e.m616i()) {
                        if (this.f214a.f228i != null) {
                            this.f214a.f228i.m590b(abstractRunnableC0120e.mo612e(), abstractRunnableC0120e);
                        }
                    } else if (this.f214a.f228i != null) {
                        this.f214a.f228i.m589a(abstractRunnableC0120e.mo612e(), abstractRunnableC0120e);
                    }
                }
                abstractRunnableC0120e.mo608a(abstractRunnableC0120e.m614g(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m592a(AbstractRunnableC0120e abstractRunnableC0120e, boolean z) {
        removeMessages(abstractRunnableC0120e.hashCode());
        if (z) {
            sendMessage(Message.obtain(this, 0, abstractRunnableC0120e));
        } else {
            sendMessage(Message.obtain(this, 1, abstractRunnableC0120e));
        }
    }
}
