package com.facebook.p008b;

import java.io.File;

/* compiled from: FileLruCache.java */
/* renamed from: com.facebook.b.j */
/* loaded from: classes.dex */
final class C0096j implements Comparable<C0096j> {

    /* renamed from: a */
    private final File f179a;

    /* renamed from: b */
    private final long f180b;

    C0096j(File file) {
        this.f179a = file;
        this.f180b = file.lastModified();
    }

    /* renamed from: a */
    File m239a() {
        return this.f179a;
    }

    /* renamed from: b */
    long m240b() {
        return this.f180b;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0096j c0096j) {
        if (m240b() < c0096j.m240b()) {
            return -1;
        }
        if (m240b() > c0096j.m240b()) {
            return 1;
        }
        return m239a().compareTo(c0096j.m239a());
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0096j) && compareTo((C0096j) obj) == 0;
    }
}
