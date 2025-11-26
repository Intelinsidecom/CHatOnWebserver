package com.sec.chaton.settings;

import android.net.Uri;

/* compiled from: RingtonePreference2.java */
/* renamed from: com.sec.chaton.settings.eq */
/* loaded from: classes.dex */
class C2680eq {

    /* renamed from: a */
    private EnumC2681er f9966a;

    /* renamed from: b */
    private String f9967b;

    /* renamed from: c */
    private Uri f9968c;

    /* renamed from: d */
    private int f9969d;

    /* renamed from: e */
    private int f9970e;

    public C2680eq(int i, EnumC2681er enumC2681er, String str, Uri uri) {
        this.f9966a = enumC2681er;
        this.f9967b = str;
        this.f9968c = uri;
        this.f9970e = i;
    }

    public C2680eq(int i, EnumC2681er enumC2681er, String str, Uri uri, int i2) {
        this.f9966a = enumC2681er;
        this.f9967b = str;
        this.f9968c = uri;
        this.f9969d = i2;
        this.f9970e = i;
    }

    /* renamed from: a */
    public EnumC2681er m9685a() {
        return this.f9966a;
    }

    /* renamed from: b */
    public String m9686b() {
        return this.f9967b;
    }

    /* renamed from: c */
    public Uri m9687c() {
        return this.f9968c;
    }

    public String toString() {
        return this.f9967b;
    }

    /* renamed from: d */
    public int m9688d() {
        return this.f9969d;
    }

    /* renamed from: e */
    public int m9689e() {
        return this.f9970e;
    }
}
