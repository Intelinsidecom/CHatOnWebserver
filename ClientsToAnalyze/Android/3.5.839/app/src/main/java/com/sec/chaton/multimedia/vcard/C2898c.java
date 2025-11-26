package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.c */
/* loaded from: classes.dex */
public class C2898c {

    /* renamed from: a */
    public final int f10722a;

    /* renamed from: b */
    public final String f10723b;

    /* renamed from: c */
    public final String f10724c;

    /* renamed from: d */
    public final int f10725d;

    /* renamed from: e */
    public boolean f10726e;

    /* renamed from: f */
    public boolean f10727f = false;

    public C2898c(int i, String str, String str2, int i2, boolean z) {
        this.f10722a = i;
        this.f10723b = str;
        this.f10724c = str2;
        this.f10725d = i2;
        this.f10726e = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2898c)) {
            return false;
        }
        C2898c c2898c = (C2898c) obj;
        return this.f10722a == c2898c.f10722a && this.f10723b.equals(c2898c.f10723b) && this.f10724c.equals(c2898c.f10724c) && this.f10725d == c2898c.f10725d && this.f10726e == c2898c.f10726e;
    }

    public String toString() {
        return String.format("type: %d, data: %s, label: %s, kind: %d, isPrimary: %s", Integer.valueOf(this.f10722a), this.f10723b, this.f10724c, Integer.valueOf(this.f10725d), Boolean.valueOf(this.f10726e));
    }
}
