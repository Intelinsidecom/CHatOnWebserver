package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.s */
/* loaded from: classes.dex */
public class C0842s {

    /* renamed from: a */
    public final int f2921a;

    /* renamed from: b */
    public final String f2922b;

    /* renamed from: c */
    public final String f2923c;

    /* renamed from: d */
    public boolean f2924d;

    public C0842s(int i, String str, String str2, boolean z) {
        this.f2921a = i;
        this.f2922b = str;
        this.f2923c = str2;
        this.f2924d = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0842s)) {
            return false;
        }
        C0842s c0842s = (C0842s) obj;
        return this.f2921a == c0842s.f2921a && this.f2922b.equals(c0842s.f2922b) && this.f2923c.equals(c0842s.f2923c) && this.f2924d == c0842s.f2924d;
    }

    public String toString() {
        return String.format("type: %d, data: %s, label: %s, isPrimary: %s", Integer.valueOf(this.f2921a), this.f2922b, this.f2923c, Boolean.valueOf(this.f2924d));
    }
}
