package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.c */
/* loaded from: classes.dex */
public class C1929c {

    /* renamed from: a */
    public final int f7401a;

    /* renamed from: b */
    public final String f7402b;

    /* renamed from: c */
    public final String f7403c;

    /* renamed from: d */
    public final int f7404d;

    /* renamed from: e */
    public boolean f7405e;

    /* renamed from: f */
    public boolean f7406f = false;

    public C1929c(int i, String str, String str2, int i2, boolean z) {
        this.f7401a = i;
        this.f7402b = str;
        this.f7403c = str2;
        this.f7404d = i2;
        this.f7405e = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1929c)) {
            return false;
        }
        C1929c c1929c = (C1929c) obj;
        return this.f7401a == c1929c.f7401a && this.f7402b.equals(c1929c.f7402b) && this.f7403c.equals(c1929c.f7403c) && this.f7404d == c1929c.f7404d && this.f7405e == c1929c.f7405e;
    }

    public String toString() {
        return String.format("type: %d, data: %s, label: %s, kind: %d, isPrimary: %s", Integer.valueOf(this.f7401a), this.f7402b, this.f7403c, Integer.valueOf(this.f7404d), Boolean.valueOf(this.f7405e));
    }
}
