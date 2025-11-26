package com.sec.chaton.push.p054c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.p051b.p053b.InterfaceC2062b;
import com.sec.chaton.push.util.C2115g;
import com.sec.common.CommonApplication;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.e */
/* loaded from: classes.dex */
public class C2084e implements InterfaceC2062b {

    /* renamed from: a */
    private static final String f7977a = C2084e.class.getSimpleName();

    /* renamed from: c */
    private static C2084e f7978c;

    /* renamed from: d */
    @Deprecated
    private boolean f7980d;

    /* renamed from: e */
    private Thread f7981e;

    /* renamed from: f */
    private HandlerThread f7982f;

    /* renamed from: g */
    private Handler f7983g;

    /* renamed from: h */
    private InterfaceC2083d f7984h;

    /* renamed from: j */
    private PowerManager.WakeLock f7986j;

    /* renamed from: b */
    private final Object f7979b = new Object();

    /* renamed from: i */
    private Map<Class<? extends GeneratedMessageLite>, InterfaceC2082c> f7985i = new ConcurrentHashMap();

    private C2084e() {
        m8225e();
    }

    /* renamed from: a */
    public static synchronized C2084e m8219a() {
        if (f7978c == null) {
            f7978c = new C2084e();
        }
        return f7978c;
    }

    /* renamed from: b */
    public Handler m8232b() {
        return this.f7983g;
    }

    /* renamed from: c */
    public Thread m8233c() {
        return this.f7982f;
    }

    /* renamed from: e */
    private void m8225e() {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7977a, "MessageTaskDispatcher.prepare()");
        }
        if (this.f7980d) {
            if (C2115g.f8050c) {
                C2115g.m8363c(f7977a, "It is already prepared.");
                return;
            }
            return;
        }
        this.f7980d = true;
        this.f7981e = new C2085f(this, "MessageTaskDispatchThread");
        this.f7981e.start();
        this.f7982f = new HandlerThread("MessageTaskExecuteThread");
        this.f7982f.start();
        this.f7983g = new HandlerC2086g(this, this.f7982f.getLooper());
        this.f7986j = ((PowerManager) CommonApplication.m11493l().getSystemService("power")).newWakeLock(1, f7977a);
    }

    @Override // com.sec.chaton.push.p051b.p053b.InterfaceC2062b
    /* renamed from: a */
    public void mo8185a(Object obj) {
        this.f7983g.sendMessage(Message.obtain(this.f7983g, 1, obj));
    }

    /* renamed from: a */
    public void m8231a(InterfaceC2082c interfaceC2082c) {
        this.f7985i.put(interfaceC2082c.mo8205a(), interfaceC2082c);
    }

    /* renamed from: a */
    public void m8230a(int i) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7977a, String.format("Cancel current message task. (reason internal error code: %d).", Integer.valueOf(i)));
        }
        synchronized (this.f7979b) {
            if (this.f7984h != null) {
                this.f7983g.removeMessages(-1);
                InterfaceC2083d interfaceC2083d = this.f7984h;
                this.f7984h = null;
                try {
                    interfaceC2083d.mo8195a(i, null);
                    m8229g();
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f7977a, "Wake up MessageTaskDispatchThread.");
                    }
                    synchronized (this.f7981e) {
                        this.f7981e.notify();
                    }
                } catch (Throwable th) {
                    m8229g();
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m8226f() {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7977a, "Acquire wake lock.");
        }
        try {
            synchronized (this.f7986j) {
                if (this.f7986j != null) {
                    this.f7986j.acquire();
                }
            }
        } catch (Throwable th) {
            if (C2115g.f8051d) {
                C2115g.m8360a(f7977a, th.getMessage(), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m8229g() {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7977a, "Release wake lock.");
        }
        try {
            synchronized (this.f7986j) {
                if (this.f7986j != null) {
                    this.f7986j.release();
                    if (C2115g.f8048a) {
                        String str = f7977a;
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(this.f7986j.isHeld() ? false : true);
                        C2115g.m8359a(str, String.format("Is all wake lock released? %s", objArr));
                    }
                }
            }
        } catch (Throwable th) {
            if (C2115g.f8051d) {
                C2115g.m8360a(f7977a, th.getMessage(), th);
            }
        }
    }
}
