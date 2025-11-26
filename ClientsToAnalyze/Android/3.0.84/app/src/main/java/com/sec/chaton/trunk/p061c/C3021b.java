package com.sec.chaton.trunk.p061c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyLocker.java */
/* renamed from: com.sec.chaton.trunk.c.b */
/* loaded from: classes.dex */
public final class C3021b {

    /* renamed from: a */
    private final List<String> f10898a = new ArrayList();

    /* renamed from: a */
    public synchronized boolean m10528a(String str) {
        boolean z;
        if (this.f10898a.contains(str)) {
            z = false;
        } else {
            this.f10898a.add(str);
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public synchronized boolean m10529b(String str) {
        boolean z;
        if (!this.f10898a.contains(str)) {
            z = false;
        } else {
            this.f10898a.remove(str);
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public synchronized boolean m10530c(String str) {
        return this.f10898a.contains(str);
    }

    /* renamed from: a */
    public synchronized void m10527a() {
        this.f10898a.clear();
    }
}
