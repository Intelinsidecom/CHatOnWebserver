package com.sec.chaton.trunk.p121c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyLocker.java */
/* renamed from: com.sec.chaton.trunk.c.b */
/* loaded from: classes.dex */
public final class C4637b {

    /* renamed from: a */
    private final List<String> f16815a = new ArrayList();

    /* renamed from: a */
    public synchronized boolean m17605a(String str) {
        boolean z;
        if (this.f16815a.contains(str)) {
            z = false;
        } else {
            this.f16815a.add(str);
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public synchronized boolean m17606b(String str) {
        boolean z;
        if (!this.f16815a.contains(str)) {
            z = false;
        } else {
            this.f16815a.remove(str);
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public synchronized boolean m17607c(String str) {
        return this.f16815a.contains(str);
    }

    /* renamed from: a */
    public synchronized void m17604a() {
        this.f16815a.clear();
    }
}
