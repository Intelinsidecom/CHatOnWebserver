package com.sec.chaton.trunk.p045d;

import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyLocker.java */
/* renamed from: com.sec.chaton.trunk.d.h */
/* loaded from: classes.dex */
public final class C1170h {

    /* renamed from: a */
    private final List f4021a = new ArrayList();

    /* renamed from: a */
    public synchronized boolean m4218a(String str) {
        boolean z;
        if (this.f4021a.contains(str)) {
            z = false;
        } else {
            this.f4021a.add(str);
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public synchronized boolean m4219b(String str) {
        boolean z;
        if (!this.f4021a.contains(str)) {
            z = false;
        } else {
            this.f4021a.remove(str);
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public synchronized boolean m4220c(String str) {
        return this.f4021a.contains(str);
    }

    /* renamed from: a */
    public synchronized void m4217a() {
        this.f4021a.clear();
    }
}
