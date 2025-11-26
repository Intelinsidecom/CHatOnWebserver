package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.j */
/* loaded from: classes.dex */
public class C1040j {

    /* renamed from: a */
    public final int f3861a;

    /* renamed from: b */
    public final String f3862b;

    /* renamed from: c */
    public final String f3863c;

    /* renamed from: d */
    public boolean f3864d;

    public C1040j(int i, String str, String str2, boolean z) {
        this.f3861a = i;
        this.f3862b = str;
        this.f3863c = str2;
        this.f3864d = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1040j)) {
            return false;
        }
        C1040j c1040j = (C1040j) obj;
        return this.f3861a == c1040j.f3861a && this.f3862b.equals(c1040j.f3862b) && this.f3863c.equals(c1040j.f3863c) && this.f3864d == c1040j.f3864d;
    }

    public String toString() {
        return String.format("type: %d, data: %s, label: %s, isPrimary: %s", Integer.valueOf(this.f3861a), this.f3862b, this.f3863c, Boolean.valueOf(this.f3864d));
    }
}
