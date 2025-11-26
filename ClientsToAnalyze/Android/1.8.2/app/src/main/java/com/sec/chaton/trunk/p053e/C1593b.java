package com.sec.chaton.trunk.p053e;

import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyLocker.java */
/* renamed from: com.sec.chaton.trunk.e.b */
/* loaded from: classes.dex */
public final class C1593b {

    /* renamed from: a */
    private final List f5708a = new ArrayList();

    /* renamed from: a */
    public synchronized boolean m5496a(String str) {
        boolean z;
        if (this.f5708a.contains(str)) {
            z = false;
        } else {
            this.f5708a.add(str);
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public synchronized boolean m5497b(String str) {
        boolean z;
        if (!this.f5708a.contains(str)) {
            z = false;
        } else {
            this.f5708a.remove(str);
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public synchronized boolean m5498c(String str) {
        return this.f5708a.contains(str);
    }

    /* renamed from: a */
    public synchronized void m5495a() {
        this.f5708a.clear();
    }
}
