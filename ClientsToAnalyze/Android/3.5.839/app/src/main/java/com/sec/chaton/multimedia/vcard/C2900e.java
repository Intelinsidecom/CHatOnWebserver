package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.e */
/* loaded from: classes.dex */
public class C2900e {

    /* renamed from: a */
    public final int f10732a;

    /* renamed from: b */
    public final String f10733b;

    /* renamed from: c */
    public final int f10734c;

    /* renamed from: d */
    public final String f10735d;

    /* renamed from: e */
    public final boolean f10736e;

    public boolean equals(Object obj) {
        if (!(obj instanceof C2900e)) {
            return false;
        }
        C2900e c2900e = (C2900e) obj;
        if (this.f10734c != c2900e.f10734c || this.f10732a != c2900e.f10732a) {
            return false;
        }
        if (this.f10733b != null) {
            if (!this.f10733b.equals(c2900e.f10733b)) {
                return false;
            }
        } else if (c2900e.f10733b != null) {
            return false;
        }
        if (this.f10735d != null) {
            if (!this.f10735d.equals(c2900e.f10735d)) {
                return false;
            }
        } else if (c2900e.f10735d != null) {
            return false;
        }
        return this.f10736e == c2900e.f10736e;
    }

    public String toString() {
        return String.format("type: %d, protocol: %d, custom_protcol: %s, data: %s, isPrimary: %s", Integer.valueOf(this.f10734c), Integer.valueOf(this.f10732a), this.f10733b, this.f10735d, Boolean.valueOf(this.f10736e));
    }
}
