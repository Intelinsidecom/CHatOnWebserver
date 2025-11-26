package com.sec.chaton.smsplugin.p102b;

import com.sec.chaton.smsplugin.C3811d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: Conversation.java */
/* renamed from: com.sec.chaton.smsplugin.b.m */
/* loaded from: classes.dex */
class C3794m {

    /* renamed from: a */
    private static C3794m f13613a = new C3794m();

    /* renamed from: b */
    private final HashSet<C3790i> f13614b = new HashSet<>(10);

    /* renamed from: a */
    static C3794m m14372a() {
        return f13613a;
    }

    private C3794m() {
    }

    /* renamed from: a */
    static C3790i m14370a(long j) {
        synchronized (f13613a) {
            Iterator<C3790i> it = f13613a.f13614b.iterator();
            while (it.hasNext()) {
                C3790i next = it.next();
                if (next.m14359d() == j) {
                    return next;
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    static C3790i m14371a(C3789h c3789h) {
        synchronized (f13613a) {
            Iterator<C3790i> it = f13613a.f13614b.iterator();
            while (it.hasNext()) {
                C3790i next = it.next();
                if (next.m14362g().equals(c3789h)) {
                    return next;
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    static void m14373a(C3790i c3790i) {
        synchronized (f13613a) {
            if (f13613a.f13614b.contains(c3790i)) {
                throw new IllegalStateException("cache already contains " + c3790i + " threadId: " + c3790i.f13597i);
            }
            f13613a.f13614b.add(c3790i);
        }
    }

    /* renamed from: b */
    static boolean m14377b(C3790i c3790i) {
        boolean z;
        synchronized (f13613a) {
            if (!f13613a.f13614b.contains(c3790i)) {
                z = false;
            } else {
                f13613a.f13614b.remove(c3790i);
                f13613a.f13614b.add(c3790i);
                z = true;
            }
        }
        return z;
    }

    /* renamed from: b */
    static void m14376b(long j) {
        synchronized (f13613a) {
            Iterator<C3790i> it = f13613a.f13614b.iterator();
            while (it.hasNext()) {
                C3790i next = it.next();
                if (next.m14359d() == j) {
                    f13613a.f13614b.remove(next);
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    static void m14375b() {
        synchronized (f13613a) {
            C3811d.m14485a("Conversation dumpCache: ", new Object[0]);
            Iterator<C3790i> it = f13613a.f13614b.iterator();
            while (it.hasNext()) {
                C3790i next = it.next();
                C3811d.m14485a("   conv: " + next.toString() + " hash: " + next.hashCode(), new Object[0]);
            }
        }
    }

    /* renamed from: a */
    static void m14374a(Set<Long> set) {
        synchronized (f13613a) {
            Iterator<C3790i> it = f13613a.f13614b.iterator();
            while (it.hasNext()) {
                if (!set.contains(Long.valueOf(it.next().m14359d()))) {
                    it.remove();
                }
            }
        }
    }
}
