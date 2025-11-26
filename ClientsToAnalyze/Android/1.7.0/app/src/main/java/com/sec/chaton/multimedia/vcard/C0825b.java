package com.sec.chaton.multimedia.vcard;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.b */
/* loaded from: classes.dex */
public class C0825b {

    /* renamed from: a */
    public final int f2863a;

    /* renamed from: b */
    public final String f2864b;

    /* renamed from: c */
    public final String f2865c;

    /* renamed from: d */
    public boolean f2866d;

    public C0825b(int i, String str, String str2, boolean z) {
        this.f2863a = i;
        this.f2864b = str;
        this.f2865c = str2;
        this.f2866d = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0825b)) {
            return false;
        }
        C0825b c0825b = (C0825b) obj;
        return this.f2863a == c0825b.f2863a && this.f2864b.equals(c0825b.f2864b) && this.f2865c.equals(c0825b.f2865c) && this.f2866d == c0825b.f2866d;
    }

    public String toString() {
        return String.format("type: %d, data: %s, label: %s, isPrimary: %s", Integer.valueOf(this.f2863a), this.f2864b, this.f2865c, Boolean.valueOf(this.f2866d));
    }
}
