package com.sec.chaton.push.p044c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p041b.p043b.InterfaceC1089b;
import com.sec.chaton.push.util.C1139g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.e */
/* loaded from: classes.dex */
public class C1111e implements InterfaceC1089b {

    /* renamed from: a */
    private static final String f4074a = C1111e.class.getSimpleName();

    /* renamed from: b */
    private static C1111e f4075b;

    /* renamed from: c */
    private boolean f4076c;

    /* renamed from: d */
    private Thread f4077d;

    /* renamed from: e */
    private HandlerThread f4078e;

    /* renamed from: f */
    private Handler f4079f;

    /* renamed from: g */
    private InterfaceC1110d f4080g;

    /* renamed from: h */
    private Map f4081h = new ConcurrentHashMap();

    /* renamed from: i */
    private PowerManager.WakeLock f4082i;

    private C1111e() {
    }

    /* renamed from: a */
    public static synchronized C1111e m4174a() {
        if (f4075b == null) {
            f4075b = new C1111e();
        }
        return f4075b;
    }

    /* renamed from: b */
    public synchronized Handler m4186b() {
        return this.f4079f;
    }

    /* renamed from: c */
    public synchronized Thread m4187c() {
        return this.f4078e;
    }

    /* renamed from: d */
    public synchronized void m4188d() {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4074a, "MessageTaskDispatcher.prepare()");
        }
        if (this.f4076c) {
            if (C1139g.f4144c) {
                C1139g.m4312c(f4074a, "It is already prepared.");
            }
        } else {
            this.f4076c = true;
            this.f4077d = new C1112f(this, "MessageTaskDispatchThread");
            this.f4077d.start();
            this.f4078e = new HandlerThread("MessageTaskExecuteThread");
            this.f4078e.start();
            this.f4079f = new HandlerC1113g(this, this.f4078e.getLooper());
            this.f4082i = ((PowerManager) PushClientApplication.m4111g().getSystemService("power")).newWakeLock(1, f4074a);
        }
    }

    @Override // com.sec.chaton.push.p041b.p043b.InterfaceC1089b
    /* renamed from: a */
    public synchronized void mo4142a(Object obj) {
        if (!this.f4076c) {
            if (C1139g.f4145d) {
                C1139g.m4313d(f4074a, "MessageTaskDispatcher isn't prepared.");
            }
        } else {
            this.f4079f.sendMessage(Message.obtain(this.f4079f, 1, obj));
        }
    }

    /* renamed from: a */
    public void m4185a(InterfaceC1109c interfaceC1109c) {
        this.f4081h.put(interfaceC1109c.mo4160a(), interfaceC1109c);
    }

    /* renamed from: a */
    public synchronized void m4184a(int i) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4074a, String.format("Cancel current message task. (reason internal error code: %d).", Integer.valueOf(i)));
        }
        if (this.f4080g != null) {
            this.f4079f.removeMessages(-1);
            InterfaceC1110d interfaceC1110d = this.f4080g;
            this.f4080g = null;
            try {
                interfaceC1110d.mo4151a(i, null);
                m4183h();
                if (C1139g.f4142a) {
                    C1139g.m4308a(f4074a, "Wake up MessageTaskDispatchThread.");
                }
                synchronized (this.f4077d) {
                    this.f4077d.notify();
                }
            } catch (Throwable th) {
                m4183h();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public synchronized void m4182g() {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4074a, "Acquire wake lock.");
        }
        try {
            if (this.f4082i != null) {
                this.f4082i.acquire();
            }
        } catch (Throwable th) {
            if (C1139g.f4145d) {
                C1139g.m4309a(f4074a, th.getMessage(), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public synchronized void m4183h() {
        synchronized (this) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4074a, "Release wake lock.");
            }
            try {
                if (this.f4082i != null) {
                    this.f4082i.release();
                    if (C1139g.f4142a) {
                        String str = f4074a;
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(this.f4082i.isHeld() ? false : true);
                        C1139g.m4308a(str, String.format("Is all wake lock released? %s", objArr));
                    }
                }
            } catch (Throwable th) {
                if (C1139g.f4145d) {
                    C1139g.m4309a(f4074a, th.getMessage(), th);
                }
            }
        }
    }
}
