package org.p072a.p073a.p074a.p075a;

import java.security.PrivilegedAction;

/* compiled from: EvictionTimer.java */
/* renamed from: org.a.a.a.a.h */
/* loaded from: classes.dex */
class C3700h implements PrivilegedAction<ClassLoader> {
    private C3700h() {
    }

    @Override // java.security.PrivilegedAction
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ClassLoader run() {
        return Thread.currentThread().getContextClassLoader();
    }
}
