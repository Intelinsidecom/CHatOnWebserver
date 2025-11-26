package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.k */
/* loaded from: classes.dex */
public class C1041k {

    /* renamed from: a */
    public final int f3865a;

    /* renamed from: b */
    public final String f3866b;

    /* renamed from: c */
    public final int f3867c;

    /* renamed from: d */
    public final String f3868d;

    /* renamed from: e */
    public final boolean f3869e;

    public boolean equals(Object obj) {
        if (!(obj instanceof C1041k)) {
            return false;
        }
        C1041k c1041k = (C1041k) obj;
        if (this.f3867c != c1041k.f3867c || this.f3865a != c1041k.f3865a) {
            return false;
        }
        if (this.f3866b != null) {
            if (!this.f3866b.equals(c1041k.f3866b)) {
                return false;
            }
        } else if (c1041k.f3866b != null) {
            return false;
        }
        if (this.f3868d != null) {
            if (!this.f3868d.equals(c1041k.f3868d)) {
                return false;
            }
        } else if (c1041k.f3868d != null) {
            return false;
        }
        return this.f3869e == c1041k.f3869e;
    }

    public String toString() {
        return String.format("type: %d, protocol: %d, custom_protcol: %s, data: %s, isPrimary: %s", Integer.valueOf(this.f3867c), Integer.valueOf(this.f3865a), this.f3866b, this.f3868d, Boolean.valueOf(this.f3869e));
    }
}
