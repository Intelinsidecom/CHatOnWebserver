package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.d */
/* loaded from: classes.dex */
public class C2899d {

    /* renamed from: a */
    public final int f10728a;

    /* renamed from: b */
    public final String f10729b;

    /* renamed from: c */
    public final String f10730c;

    /* renamed from: d */
    public boolean f10731d;

    public C2899d(int i, String str, String str2, boolean z) {
        this.f10728a = i;
        this.f10729b = str;
        this.f10730c = str2;
        this.f10731d = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2899d)) {
            return false;
        }
        C2899d c2899d = (C2899d) obj;
        return this.f10728a == c2899d.f10728a && this.f10729b.equals(c2899d.f10729b) && this.f10730c.equals(c2899d.f10730c) && this.f10731d == c2899d.f10731d;
    }

    public String toString() {
        return String.format("type: %d, data: %s, label: %s, isPrimary: %s", Integer.valueOf(this.f10728a), this.f10729b, this.f10730c, Boolean.valueOf(this.f10731d));
    }
}
