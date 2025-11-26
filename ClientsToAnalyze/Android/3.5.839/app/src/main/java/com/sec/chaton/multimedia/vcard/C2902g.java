package com.sec.chaton.multimedia.vcard;

import java.util.Arrays;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.g */
/* loaded from: classes.dex */
public class C2902g {

    /* renamed from: a */
    public final String f10741a;

    /* renamed from: b */
    public final String f10742b;

    /* renamed from: c */
    public final String f10743c;

    /* renamed from: d */
    public final String f10744d;

    /* renamed from: e */
    public final String f10745e;

    /* renamed from: f */
    public final String f10746f;

    /* renamed from: g */
    public final String f10747g;

    /* renamed from: h */
    public final int f10748h;

    /* renamed from: i */
    public final String f10749i;

    /* renamed from: j */
    public boolean f10750j;

    /* renamed from: k */
    private final String[] f10751k;

    public boolean equals(Object obj) {
        if (!(obj instanceof C2902g)) {
            return false;
        }
        C2902g c2902g = (C2902g) obj;
        if (Arrays.equals(this.f10751k, c2902g.f10751k) && this.f10748h == c2902g.f10748h) {
            return (this.f10748h != 0 || this.f10749i.equals(c2902g.f10749i)) && this.f10750j == c2902g.f10750j;
        }
        return false;
    }

    public String toString() {
        return String.format("type: %d, label: %s, isPrimary: %s", Integer.valueOf(this.f10748h), this.f10749i, Boolean.valueOf(this.f10750j));
    }
}
