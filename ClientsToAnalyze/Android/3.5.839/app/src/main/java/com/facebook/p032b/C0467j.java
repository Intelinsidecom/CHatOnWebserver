package com.facebook.p032b;

import java.io.File;

/* compiled from: FileLruCache.java */
/* renamed from: com.facebook.b.j */
/* loaded from: classes.dex */
final class C0467j implements Comparable<C0467j> {

    /* renamed from: a */
    private final File f1148a;

    /* renamed from: b */
    private final long f1149b;

    C0467j(File file) {
        this.f1148a = file;
        this.f1149b = file.lastModified();
    }

    /* renamed from: a */
    File m1683a() {
        return this.f1148a;
    }

    /* renamed from: b */
    long m1684b() {
        return this.f1149b;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0467j c0467j) {
        if (m1684b() < c0467j.m1684b()) {
            return -1;
        }
        if (m1684b() > c0467j.m1684b()) {
            return 1;
        }
        return m1683a().compareTo(c0467j.m1683a());
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0467j) && compareTo((C0467j) obj) == 0;
    }
}
