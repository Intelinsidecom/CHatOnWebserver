package com.sec.chaton.multimedia.vcard;

import java.util.Arrays;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.g */
/* loaded from: classes.dex */
public class C1933g {

    /* renamed from: a */
    public final String f7420a;

    /* renamed from: b */
    public final String f7421b;

    /* renamed from: c */
    public final String f7422c;

    /* renamed from: d */
    public final String f7423d;

    /* renamed from: e */
    public final String f7424e;

    /* renamed from: f */
    public final String f7425f;

    /* renamed from: g */
    public final String f7426g;

    /* renamed from: h */
    public final int f7427h;

    /* renamed from: i */
    public final String f7428i;

    /* renamed from: j */
    public boolean f7429j;

    /* renamed from: k */
    private final String[] f7430k;

    public boolean equals(Object obj) {
        if (!(obj instanceof C1933g)) {
            return false;
        }
        C1933g c1933g = (C1933g) obj;
        if (Arrays.equals(this.f7430k, c1933g.f7430k) && this.f7427h == c1933g.f7427h) {
            return (this.f7427h != 0 || this.f7428i.equals(c1933g.f7428i)) && this.f7429j == c1933g.f7429j;
        }
        return false;
    }

    public String toString() {
        return String.format("type: %d, label: %s, isPrimary: %s", Integer.valueOf(this.f7427h), this.f7428i, Boolean.valueOf(this.f7429j));
    }
}
