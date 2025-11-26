package com.sec.chaton.multimedia.vcard;

import java.util.Arrays;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.m */
/* loaded from: classes.dex */
public class C1043m {

    /* renamed from: a */
    public final String f3874a;

    /* renamed from: b */
    public final String f3875b;

    /* renamed from: c */
    public final String f3876c;

    /* renamed from: d */
    public final String f3877d;

    /* renamed from: e */
    public final String f3878e;

    /* renamed from: f */
    public final String f3879f;

    /* renamed from: g */
    public final String f3880g;

    /* renamed from: h */
    public final int f3881h;

    /* renamed from: i */
    public final String f3882i;

    /* renamed from: j */
    public boolean f3883j;

    /* renamed from: k */
    private final String[] f3884k;

    public boolean equals(Object obj) {
        if (!(obj instanceof C1043m)) {
            return false;
        }
        C1043m c1043m = (C1043m) obj;
        if (Arrays.equals(this.f3884k, c1043m.f3884k) && this.f3881h == c1043m.f3881h) {
            return (this.f3881h != 0 || this.f3882i == c1043m.f3882i) && this.f3883j == c1043m.f3883j;
        }
        return false;
    }

    public String toString() {
        return String.format("type: %d, label: %s, isPrimary: %s", Integer.valueOf(this.f3881h), this.f3882i, Boolean.valueOf(this.f3883j));
    }
}
