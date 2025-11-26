package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.i */
/* loaded from: classes.dex */
public class C1039i {

    /* renamed from: a */
    public final int f3855a;

    /* renamed from: b */
    public final String f3856b;

    /* renamed from: c */
    public final String f3857c;

    /* renamed from: d */
    public final int f3858d;

    /* renamed from: e */
    public boolean f3859e;

    /* renamed from: f */
    public boolean f3860f = false;

    public C1039i(int i, String str, String str2, int i2, boolean z) {
        this.f3855a = i;
        this.f3856b = str;
        this.f3857c = str2;
        this.f3858d = i2;
        this.f3859e = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1039i)) {
            return false;
        }
        C1039i c1039i = (C1039i) obj;
        return this.f3855a == c1039i.f3855a && this.f3856b.equals(c1039i.f3856b) && this.f3857c.equals(c1039i.f3857c) && this.f3858d == c1039i.f3858d && this.f3859e == c1039i.f3859e;
    }

    public String toString() {
        return String.format("type: %d, data: %s, label: %s, kind: %d, isPrimary: %s", Integer.valueOf(this.f3855a), this.f3856b, this.f3857c, Integer.valueOf(this.f3858d), Boolean.valueOf(this.f3859e));
    }
}
