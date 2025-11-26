package com.sec.chaton.push.p094c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.p091b.p093b.InterfaceC3062b;
import com.sec.chaton.push.util.C3115g;
import com.sec.common.CommonApplication;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.e */
/* loaded from: classes.dex */
public class C3084e implements InterfaceC3062b {

    /* renamed from: a */
    private static final String f11387a = C3084e.class.getSimpleName();

    /* renamed from: c */
    private static C3084e f11388c;

    /* renamed from: d */
    @Deprecated
    private boolean f11390d;

    /* renamed from: e */
    private Thread f11391e;

    /* renamed from: f */
    private HandlerThread f11392f;

    /* renamed from: g */
    private Handler f11393g;

    /* renamed from: h */
    private InterfaceC3083d f11394h;

    /* renamed from: j */
    private PowerManager.WakeLock f11396j;

    /* renamed from: b */
    private final Object f11389b = new Object();

    /* renamed from: i */
    private Map<Class<? extends GeneratedMessageLite>, InterfaceC3082c> f11395i = new ConcurrentHashMap();

    private C3084e() {
        m12568e();
    }

    /* renamed from: a */
    public static synchronized C3084e m12562a() {
        if (f11388c == null) {
            f11388c = new C3084e();
        }
        return f11388c;
    }

    /* renamed from: b */
    public Handler m12575b() {
        return this.f11393g;
    }

    /* renamed from: c */
    public Thread m12576c() {
        return this.f11392f;
    }

    /* renamed from: e */
    private void m12568e() {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11387a, "MessageTaskDispatcher.prepare()");
        }
        if (this.f11390d) {
            if (C3115g.f11460c) {
                C3115g.m12705c(f11387a, "It is already prepared.");
                return;
            }
            return;
        }
        this.f11390d = true;
        this.f11391e = new C3085f(this, "MessageTaskDispatchThread");
        this.f11391e.start();
        this.f11392f = new HandlerThread("MessageTaskExecuteThread");
        this.f11392f.start();
        this.f11393g = new HandlerC3086g(this, this.f11392f.getLooper());
        this.f11396j = ((PowerManager) CommonApplication.m18732r().getSystemService("power")).newWakeLock(1, f11387a);
    }

    @Override // com.sec.chaton.push.p091b.p093b.InterfaceC3062b
    /* renamed from: a */
    public void mo12528a(Object obj) {
        this.f11393g.sendMessage(Message.obtain(this.f11393g, 1, obj));
    }

    /* renamed from: a */
    public void m12574a(InterfaceC3082c interfaceC3082c) {
        this.f11395i.put(interfaceC3082c.mo12548a(), interfaceC3082c);
    }

    /* renamed from: a */
    public void m12573a(int i) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11387a, String.format("Cancel current message task. (reason internal error code: %d).", Integer.valueOf(i)));
        }
        synchronized (this.f11389b) {
            if (this.f11394h != null) {
                this.f11393g.removeMessages(-1);
                InterfaceC3083d interfaceC3083d = this.f11394h;
                this.f11394h = null;
                try {
                    interfaceC3083d.mo12538a(i, null);
                    m12572g();
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11387a, "Wake up MessageTaskDispatchThread.");
                    }
                    synchronized (this.f11391e) {
                        this.f11391e.notify();
                    }
                } catch (Throwable th) {
                    m12572g();
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12569f() {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11387a, "Acquire wake lock.");
        }
        try {
            synchronized (this.f11396j) {
                if (this.f11396j != null) {
                    this.f11396j.acquire();
                }
            }
        } catch (Throwable th) {
            if (C3115g.f11461d) {
                C3115g.m12702a(f11387a, th.getMessage(), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m12572g() {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11387a, "Release wake lock.");
        }
        try {
            synchronized (this.f11396j) {
                if (this.f11396j != null) {
                    this.f11396j.release();
                    if (C3115g.f11458a) {
                        String str = f11387a;
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(this.f11396j.isHeld() ? false : true);
                        C3115g.m12701a(str, String.format("Is all wake lock released? %s", objArr));
                    }
                }
            }
        } catch (Throwable th) {
            if (C3115g.f11461d) {
                C3115g.m12702a(f11387a, th.getMessage(), th);
            }
        }
    }
}
