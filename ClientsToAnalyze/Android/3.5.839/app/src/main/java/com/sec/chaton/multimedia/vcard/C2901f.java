package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.f */
/* loaded from: classes.dex */
public class C2901f {

    /* renamed from: a */
    public final int f10737a;

    /* renamed from: b */
    public final String f10738b;

    /* renamed from: c */
    public final String f10739c;

    /* renamed from: d */
    public boolean f10740d;

    public C2901f(int i, String str, String str2, boolean z) {
        this.f10737a = i;
        this.f10738b = str;
        this.f10739c = str2;
        this.f10740d = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2901f)) {
            return false;
        }
        C2901f c2901f = (C2901f) obj;
        return this.f10737a == c2901f.f10737a && this.f10738b.equals(c2901f.f10738b) && this.f10739c.equals(c2901f.f10739c) && this.f10740d == c2901f.f10740d;
    }

    public String toString() {
        return String.format("type: %d, data: %s, label: %s, isPrimary: %s", Integer.valueOf(this.f10737a), this.f10738b, this.f10739c, Boolean.valueOf(this.f10740d));
    }
}
