package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.l */
/* loaded from: classes.dex */
public class C1042l {

    /* renamed from: a */
    public final int f3870a;

    /* renamed from: b */
    public final String f3871b;

    /* renamed from: c */
    public final String f3872c;

    /* renamed from: d */
    public boolean f3873d;

    public C1042l(int i, String str, String str2, boolean z) {
        this.f3870a = i;
        this.f3871b = str;
        this.f3872c = str2;
        this.f3873d = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1042l)) {
            return false;
        }
        C1042l c1042l = (C1042l) obj;
        return this.f3870a == c1042l.f3870a && this.f3871b.equals(c1042l.f3871b) && this.f3872c.equals(c1042l.f3872c) && this.f3873d == c1042l.f3873d;
    }

    public String toString() {
        return String.format("type: %d, data: %s, label: %s, isPrimary: %s", Integer.valueOf(this.f3870a), this.f3871b, this.f3872c, Boolean.valueOf(this.f3873d));
    }
}
