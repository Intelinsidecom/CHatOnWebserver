package com.sec.chaton.push.p039c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p035a.p036a.InterfaceC0862j;
import com.sec.chaton.push.util.C0921g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.e */
/* loaded from: classes.dex */
public class C0893e implements InterfaceC0862j {

    /* renamed from: a */
    private static final String f3054a = C0893e.class.getSimpleName();

    /* renamed from: b */
    private static C0893e f3055b;

    /* renamed from: c */
    private boolean f3056c;

    /* renamed from: d */
    private Thread f3057d;

    /* renamed from: e */
    private HandlerThread f3058e;

    /* renamed from: f */
    private Handler f3059f;

    /* renamed from: g */
    private InterfaceC0890b f3060g;

    /* renamed from: h */
    private Map f3061h = new ConcurrentHashMap();

    /* renamed from: i */
    private PowerManager.WakeLock f3062i;

    private C0893e() {
    }

    /* renamed from: a */
    public static synchronized C0893e m3502a() {
        if (f3055b == null) {
            f3055b = new C0893e();
        }
        return f3055b;
    }

    /* renamed from: b */
    public synchronized Handler m3514b() {
        return this.f3059f;
    }

    /* renamed from: c */
    public synchronized Thread m3515c() {
        return this.f3058e;
    }

    /* renamed from: d */
    public synchronized void m3516d() {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3054a, "MessageTaskDispatcher.prepare()");
        }
        if (this.f3056c) {
            if (C0921g.f3118c) {
                C0921g.m3641c(f3054a, "It is already prepared.");
            }
        } else {
            this.f3056c = true;
            this.f3057d = new C0891c(this, "MessageTaskDispatchThread");
            this.f3057d.start();
            this.f3058e = new HandlerThread("MessageTaskExecuteThread");
            this.f3058e.start();
            this.f3059f = new HandlerC0899k(this, this.f3058e.getLooper());
            this.f3062i = ((PowerManager) PushClientApplication.m3436a().getSystemService("power")).newWakeLock(1, f3054a);
        }
    }

    @Override // com.sec.chaton.push.p035a.p036a.InterfaceC0862j
    /* renamed from: a */
    public synchronized void mo3454a(Object obj) {
        if (!this.f3056c) {
            if (C0921g.f3119d) {
                C0921g.m3642d(f3054a, "MessageTaskDispatcher isn't prepared.");
            }
        } else {
            this.f3059f.sendMessage(Message.obtain(this.f3059f, 1, obj));
        }
    }

    /* renamed from: a */
    public void m3513a(InterfaceC0895g interfaceC0895g) {
        this.f3061h.put(interfaceC0895g.mo3493a(), interfaceC0895g);
    }

    /* renamed from: a */
    public synchronized void m3512a(int i) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3054a, String.format("Cancel current message task. (reason internal error code: %d).", Integer.valueOf(i)));
        }
        if (this.f3060g != null) {
            this.f3059f.removeMessages(-1);
            InterfaceC0890b interfaceC0890b = this.f3060g;
            this.f3060g = null;
            try {
                interfaceC0890b.mo3486a(i, null);
                m3511h();
                if (C0921g.f3116a) {
                    C0921g.m3637a(f3054a, "Wake up MessageTaskDispatchThread.");
                }
                synchronized (this.f3057d) {
                    this.f3057d.notify();
                }
            } catch (Throwable th) {
                m3511h();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public synchronized void m3510g() {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3054a, "Acquire wake lock.");
        }
        try {
            if (this.f3062i != null) {
                this.f3062i.acquire();
            }
        } catch (Throwable th) {
            if (C0921g.f3119d) {
                C0921g.m3638a(f3054a, th.getMessage(), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public synchronized void m3511h() {
        synchronized (this) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3054a, "Release wake lock.");
            }
            try {
                if (this.f3062i != null) {
                    this.f3062i.release();
                    if (C0921g.f3116a) {
                        String str = f3054a;
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(this.f3062i.isHeld() ? false : true);
                        C0921g.m3637a(str, String.format("Is all wake lock released? %s", objArr));
                    }
                }
            } catch (Throwable th) {
                if (C0921g.f3119d) {
                    C0921g.m3638a(f3054a, th.getMessage(), th);
                }
            }
        }
    }
}
