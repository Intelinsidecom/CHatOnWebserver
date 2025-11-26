package com.sec.chaton.chat.background;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.util.C1341p;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: ChatBackgroundHandler.java */
/* renamed from: com.sec.chaton.chat.background.a */
/* loaded from: classes.dex */
public class HandlerC0554a extends Handler {

    /* renamed from: a */
    private Map f1915a;

    /* renamed from: b */
    private C0560g f1916b;

    public HandlerC0554a() {
        this.f1915a = new HashMap();
        m2729b();
    }

    public HandlerC0554a(Looper looper) {
        super(looper);
        this.f1915a = new HashMap();
        m2729b();
    }

    /* renamed from: a */
    public boolean m2730a() {
        this.f1915a.clear();
        this.f1916b.m2768c();
        return true;
    }

    /* renamed from: b */
    private void m2729b() {
        this.f1916b = new C0560g();
        this.f1916b.m2767b();
    }

    /* renamed from: a */
    private void m2728a(C0558e c0558e) {
        if (c0558e != null) {
            C0559f c0559f = new C0559f(this, getLooper());
            long jM2764b = c0559f.m2764b();
            if (!c0559f.m2762a(c0558e)) {
                c0559f.m2763a(false, 0, c0558e.m2750h());
                return;
            }
            this.f1915a.put(Long.valueOf(jM2764b), c0559f);
            BlockingQueue blockingQueueM2766a = this.f1916b.m2766a();
            if (blockingQueueM2766a != null) {
                if (!blockingQueueM2766a.offer(new RunnableC0557d(this, jM2764b))) {
                    c0559f.m2763a(false, 0, c0558e.m2750h());
                    this.f1915a.remove(Long.valueOf(jM2764b));
                    return;
                }
                return;
            }
            c0559f.m2763a(false, 0, c0558e.m2750h());
            this.f1915a.remove(Long.valueOf(jM2764b));
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                m2728a((C0558e) message.obj);
                break;
            case 1:
                ((C0559f) this.f1915a.remove(Long.valueOf(((Long) message.obj).longValue()))).m2760a();
                C1341p.m4660c("REQUEST_JOB_COMPLETED", "ChatBackgroundHandler");
                break;
        }
    }
}
