package org.p072a.p073a.p074a.p075a;

import java.security.AccessController;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: EvictionTimer.java */
/* renamed from: org.a.a.a.a.f */
/* loaded from: classes.dex */
class C3698f {

    /* renamed from: a */
    private static Timer f13640a;

    /* renamed from: b */
    private static int f13641b;

    private C3698f() {
    }

    /* renamed from: a */
    static synchronized void m13319a(TimerTask timerTask, long j, long j2) {
        if (f13640a == null) {
            ClassLoader classLoader = (ClassLoader) AccessController.doPrivileged(new C3700h());
            try {
                AccessController.doPrivileged(new C3701i(C3698f.class.getClassLoader()));
                f13640a = new Timer(true);
            } finally {
                AccessController.doPrivileged(new C3701i(classLoader));
            }
        }
        f13641b++;
        f13640a.schedule(timerTask, j, j2);
    }

    /* renamed from: a */
    static synchronized void m13318a(TimerTask timerTask) {
        timerTask.cancel();
        f13641b--;
        if (f13641b == 0) {
            f13640a.cancel();
            f13640a = null;
        }
    }
}
