package com.sec.chaton.multimedia.vcard;

import java.util.Arrays;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.g */
/* loaded from: classes.dex */
public class C0830g {

    /* renamed from: a */
    public final String f2875a;

    /* renamed from: b */
    public final String f2876b;

    /* renamed from: c */
    public final String f2877c;

    /* renamed from: d */
    public final String f2878d;

    /* renamed from: e */
    public final String f2879e;

    /* renamed from: f */
    public final String f2880f;

    /* renamed from: g */
    public final String f2881g;

    /* renamed from: h */
    public final int f2882h;

    /* renamed from: i */
    public final String f2883i;

    /* renamed from: j */
    public boolean f2884j;

    /* renamed from: k */
    private final String[] f2885k;

    public boolean equals(Object obj) {
        if (!(obj instanceof C0830g)) {
            return false;
        }
        C0830g c0830g = (C0830g) obj;
        if (Arrays.equals(this.f2885k, c0830g.f2885k) && this.f2882h == c0830g.f2882h) {
            return (this.f2882h != 0 || this.f2883i == c0830g.f2883i) && this.f2884j == c0830g.f2884j;
        }
        return false;
    }

    public String toString() {
        return String.format("type: %d, label: %s, isPrimary: %s", Integer.valueOf(this.f2882h), this.f2883i, Boolean.valueOf(this.f2884j));
    }
}
