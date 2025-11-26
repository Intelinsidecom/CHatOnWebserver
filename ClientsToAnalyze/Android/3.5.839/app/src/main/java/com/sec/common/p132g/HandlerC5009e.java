package com.sec.common.p132g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.sec.common.C4996f;
import com.sec.common.util.C5052r;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Callable;

/* compiled from: ResourceDispatcher.java */
/* renamed from: com.sec.common.g.e */
/* loaded from: classes.dex */
public class HandlerC5009e extends Handler {

    /* renamed from: a */
    final /* synthetic */ C5007c f18277a;

    /* renamed from: b */
    private final C5007c f18278b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC5009e(C5007c c5007c, C5007c c5007c2, Looper looper) {
        super(looper);
        this.f18277a = c5007c;
        this.f18278b = c5007c2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Callable callable;
        AbstractRunnableC5005a<?> abstractRunnableC5005a;
        super.handleMessage(message);
        synchronized (this.f18278b.f18273e) {
            if (message.what == 100) {
                Object[] objArr = (Object[]) message.obj;
                abstractRunnableC5005a = (AbstractRunnableC5005a) objArr[0];
                callable = (Callable) objArr[1];
            } else {
                callable = null;
                abstractRunnableC5005a = (AbstractRunnableC5005a) message.obj;
            }
            View viewMo7449h = abstractRunnableC5005a.mo7449h();
            AbstractRunnableC5005a<?> abstractRunnableC5005a2 = viewMo7449h != null ? this.f18278b.f18270a.get(viewMo7449h) : null;
            if (abstractRunnableC5005a2 == null || !abstractRunnableC5005a2.equals(abstractRunnableC5005a)) {
                this.f18277a.m19013c(abstractRunnableC5005a);
            } else if (message.what == 100) {
                try {
                    callable.call();
                } catch (Exception e) {
                    if (C4996f.f18229a.f18173e) {
                        PrintWriter printWriter = new PrintWriter(new StringWriter());
                        e.printStackTrace(printWriter);
                        C4996f.f18229a.m18894h(C5007c.f18269c, C5052r.m19199a("Callable.call() method throws exception.", printWriter.toString()));
                    }
                }
            } else {
                if (message.what == 0) {
                    this.f18277a.f18275g.mo18889a(abstractRunnableC5005a.m18996j(), abstractRunnableC5005a.mo7448g());
                }
                if (this.f18277a.f18276h != null) {
                    if (abstractRunnableC5005a.m18999m()) {
                        this.f18277a.f18276h.mo6860b(viewMo7449h, abstractRunnableC5005a);
                    } else {
                        this.f18277a.f18276h.mo6852a(viewMo7449h, abstractRunnableC5005a);
                    }
                }
                abstractRunnableC5005a.mo7443a(abstractRunnableC5005a.mo7448g(), false);
            }
        }
    }

    /* renamed from: a */
    void m19026a(AbstractRunnableC5005a<?> abstractRunnableC5005a, Callable<Void> callable) {
        m19027a(abstractRunnableC5005a, callable, 0L);
    }

    /* renamed from: a */
    void m19027a(AbstractRunnableC5005a<?> abstractRunnableC5005a, Callable<Void> callable, long j) {
        removeMessages(abstractRunnableC5005a.hashCode());
        sendMessageDelayed(Message.obtain(this, 100, new Object[]{abstractRunnableC5005a, callable}), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19024a(AbstractRunnableC5005a<?> abstractRunnableC5005a, boolean z) {
        removeMessages(abstractRunnableC5005a.hashCode());
        if (z) {
            sendMessage(Message.obtain(this, 0, abstractRunnableC5005a));
        } else {
            sendMessage(Message.obtain(this, 1, abstractRunnableC5005a));
        }
    }
}
