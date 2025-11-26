package org.p138a.p139a.p140a.p141a;

import java.security.PrivilegedAction;

/* compiled from: EvictionTimer.java */
/* renamed from: org.a.a.a.a.h */
/* loaded from: classes.dex */
class C5212h implements PrivilegedAction<ClassLoader> {
    private C5212h() {
    }

    @Override // java.security.PrivilegedAction
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ClassLoader run() {
        return Thread.currentThread().getContextClassLoader();
    }
}
