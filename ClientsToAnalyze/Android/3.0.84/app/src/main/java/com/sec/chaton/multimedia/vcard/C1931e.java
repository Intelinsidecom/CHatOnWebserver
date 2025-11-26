package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.e */
/* loaded from: classes.dex */
public class C1931e {

    /* renamed from: a */
    public final int f7411a;

    /* renamed from: b */
    public final String f7412b;

    /* renamed from: c */
    public final int f7413c;

    /* renamed from: d */
    public final String f7414d;

    /* renamed from: e */
    public final boolean f7415e;

    public boolean equals(Object obj) {
        if (!(obj instanceof C1931e)) {
            return false;
        }
        C1931e c1931e = (C1931e) obj;
        if (this.f7413c != c1931e.f7413c || this.f7411a != c1931e.f7411a) {
            return false;
        }
        if (this.f7412b != null) {
            if (!this.f7412b.equals(c1931e.f7412b)) {
                return false;
            }
        } else if (c1931e.f7412b != null) {
            return false;
        }
        if (this.f7414d != null) {
            if (!this.f7414d.equals(c1931e.f7414d)) {
                return false;
            }
        } else if (c1931e.f7414d != null) {
            return false;
        }
        return this.f7415e == c1931e.f7415e;
    }

    public String toString() {
        return String.format("type: %d, protocol: %d, custom_protcol: %s, data: %s, isPrimary: %s", Integer.valueOf(this.f7413c), Integer.valueOf(this.f7411a), this.f7412b, this.f7414d, Boolean.valueOf(this.f7415e));
    }
}
