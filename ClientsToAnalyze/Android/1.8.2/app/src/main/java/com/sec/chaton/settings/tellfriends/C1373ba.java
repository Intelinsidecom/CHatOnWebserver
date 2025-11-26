package com.sec.chaton.settings.tellfriends;

import android.graphics.drawable.Drawable;

/* compiled from: SnsHelper.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ba */
/* loaded from: classes.dex */
public class C1373ba {

    /* renamed from: a */
    public String f5202a;

    /* renamed from: b */
    public String f5203b;

    /* renamed from: c */
    public String f5204c;

    /* renamed from: d */
    public Drawable f5205d;

    /* renamed from: e */
    public boolean f5206e;

    public C1373ba(String str, String str2, String str3, boolean z) {
        this.f5202a = str;
        this.f5203b = str2;
        this.f5204c = str3;
        this.f5206e = z;
    }

    public String toString() {
        return "SnsFriend id=" + this.f5202a + ", name=" + this.f5203b + ", isUser=" + this.f5206e + ", imageUrl=" + this.f5204c;
    }
}
