package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.f */
/* loaded from: classes.dex */
public class C1932f {

    /* renamed from: a */
    public final int f7416a;

    /* renamed from: b */
    public final String f7417b;

    /* renamed from: c */
    public final String f7418c;

    /* renamed from: d */
    public boolean f7419d;

    public C1932f(int i, String str, String str2, boolean z) {
        this.f7416a = i;
        this.f7417b = str;
        this.f7418c = str2;
        this.f7419d = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1932f)) {
            return false;
        }
        C1932f c1932f = (C1932f) obj;
        return this.f7416a == c1932f.f7416a && this.f7417b.equals(c1932f.f7417b) && this.f7418c.equals(c1932f.f7418c) && this.f7419d == c1932f.f7419d;
    }

    public String toString() {
        return String.format("type: %d, data: %s, label: %s, isPrimary: %s", Integer.valueOf(this.f7416a), this.f7417b, this.f7418c, Boolean.valueOf(this.f7419d));
    }
}
