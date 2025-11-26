package com.sec.chaton.settings;

import android.net.Uri;

/* compiled from: RingtonePreference2.java */
/* renamed from: com.sec.chaton.settings.fo */
/* loaded from: classes.dex */
class C3632fo {

    /* renamed from: a */
    private EnumC3633fp f13186a;

    /* renamed from: b */
    private String f13187b;

    /* renamed from: c */
    private Uri f13188c;

    /* renamed from: d */
    private int f13189d;

    /* renamed from: e */
    private int f13190e;

    public C3632fo(int i, EnumC3633fp enumC3633fp, String str, Uri uri) {
        this.f13186a = enumC3633fp;
        this.f13187b = str;
        this.f13188c = uri;
        this.f13190e = i;
    }

    public C3632fo(int i, EnumC3633fp enumC3633fp, String str, Uri uri, int i2) {
        this.f13186a = enumC3633fp;
        this.f13187b = str;
        this.f13188c = uri;
        this.f13189d = i2;
        this.f13190e = i;
    }

    /* renamed from: a */
    public EnumC3633fp m13910a() {
        return this.f13186a;
    }

    /* renamed from: b */
    public String m13911b() {
        return this.f13187b;
    }

    /* renamed from: c */
    public Uri m13912c() {
        return this.f13188c;
    }

    public String toString() {
        return this.f13187b;
    }

    /* renamed from: d */
    public int m13913d() {
        return this.f13189d;
    }

    /* renamed from: e */
    public int m13914e() {
        return this.f13190e;
    }
}
