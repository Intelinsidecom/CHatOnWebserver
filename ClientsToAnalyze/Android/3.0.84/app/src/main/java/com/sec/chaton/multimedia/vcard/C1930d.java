package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.d */
/* loaded from: classes.dex */
public class C1930d {

    /* renamed from: a */
    public final int f7407a;

    /* renamed from: b */
    public final String f7408b;

    /* renamed from: c */
    public final String f7409c;

    /* renamed from: d */
    public boolean f7410d;

    public C1930d(int i, String str, String str2, boolean z) {
        this.f7407a = i;
        this.f7408b = str;
        this.f7409c = str2;
        this.f7410d = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1930d)) {
            return false;
        }
        C1930d c1930d = (C1930d) obj;
        return this.f7407a == c1930d.f7407a && this.f7408b.equals(c1930d.f7408b) && this.f7409c.equals(c1930d.f7409c) && this.f7410d == c1930d.f7410d;
    }

    public String toString() {
        return String.format("type: %d, data: %s, label: %s, isPrimary: %s", Integer.valueOf(this.f7407a), this.f7408b, this.f7409c, Boolean.valueOf(this.f7410d));
    }
}
