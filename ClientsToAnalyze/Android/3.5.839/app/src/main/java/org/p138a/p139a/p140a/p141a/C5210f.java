package org.p138a.p139a.p140a.p141a;

import java.security.AccessController;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: EvictionTimer.java */
/* renamed from: org.a.a.a.a.f */
/* loaded from: classes.dex */
class C5210f {

    /* renamed from: a */
    private static Timer f18995a;

    /* renamed from: b */
    private static int f18996b;

    private C5210f() {
    }

    /* renamed from: a */
    static synchronized void m19847a(TimerTask timerTask, long j, long j2) {
        if (f18995a == null) {
            ClassLoader classLoader = (ClassLoader) AccessController.doPrivileged(new C5212h());
            try {
                AccessController.doPrivileged(new C5213i(C5210f.class.getClassLoader()));
                f18995a = new Timer(true);
            } finally {
                AccessController.doPrivileged(new C5213i(classLoader));
            }
        }
        f18996b++;
        f18995a.schedule(timerTask, j, j2);
    }

    /* renamed from: a */
    static synchronized void m19846a(TimerTask timerTask) {
        timerTask.cancel();
        f18996b--;
        if (f18996b == 0) {
            f18995a.cancel();
            f18995a = null;
        }
    }
}
