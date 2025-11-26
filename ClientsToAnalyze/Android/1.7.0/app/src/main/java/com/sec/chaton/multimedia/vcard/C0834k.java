package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.k */
/* loaded from: classes.dex */
public class C0834k {

    /* renamed from: a */
    public final int f2907a;

    /* renamed from: b */
    public final String f2908b;

    /* renamed from: c */
    public final String f2909c;

    /* renamed from: d */
    public final int f2910d;

    /* renamed from: e */
    public boolean f2911e;

    /* renamed from: f */
    public boolean f2912f = false;

    public C0834k(int i, String str, String str2, int i2, boolean z) {
        this.f2907a = i;
        this.f2908b = str;
        this.f2909c = str2;
        this.f2910d = i2;
        this.f2911e = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0834k)) {
            return false;
        }
        C0834k c0834k = (C0834k) obj;
        return this.f2907a == c0834k.f2907a && this.f2908b.equals(c0834k.f2908b) && this.f2909c.equals(c0834k.f2909c) && this.f2910d == c0834k.f2910d && this.f2911e == c0834k.f2911e;
    }

    public String toString() {
        return String.format("type: %d, data: %s, label: %s, kind: %d, isPrimary: %s", Integer.valueOf(this.f2907a), this.f2908b, this.f2909c, Integer.valueOf(this.f2910d), Boolean.valueOf(this.f2911e));
    }
}
