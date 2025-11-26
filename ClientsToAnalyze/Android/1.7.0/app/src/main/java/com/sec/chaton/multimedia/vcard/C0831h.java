package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.h */
/* loaded from: classes.dex */
public class C0831h {

    /* renamed from: a */
    public final int f2886a;

    /* renamed from: b */
    public final String f2887b;

    /* renamed from: c */
    public final int f2888c;

    /* renamed from: d */
    public final String f2889d;

    /* renamed from: e */
    public final boolean f2890e;

    public boolean equals(Object obj) {
        if (!(obj instanceof C0831h)) {
            return false;
        }
        C0831h c0831h = (C0831h) obj;
        if (this.f2888c != c0831h.f2888c || this.f2886a != c0831h.f2886a) {
            return false;
        }
        if (this.f2887b != null) {
            if (!this.f2887b.equals(c0831h.f2887b)) {
                return false;
            }
        } else if (c0831h.f2887b != null) {
            return false;
        }
        if (this.f2889d != null) {
            if (!this.f2889d.equals(c0831h.f2889d)) {
                return false;
            }
        } else if (c0831h.f2889d != null) {
            return false;
        }
        return this.f2890e == c0831h.f2890e;
    }

    public String toString() {
        return String.format("type: %d, protocol: %d, custom_protcol: %s, data: %s, isPrimary: %s", Integer.valueOf(this.f2888c), Integer.valueOf(this.f2886a), this.f2887b, this.f2889d, Boolean.valueOf(this.f2890e));
    }
}
