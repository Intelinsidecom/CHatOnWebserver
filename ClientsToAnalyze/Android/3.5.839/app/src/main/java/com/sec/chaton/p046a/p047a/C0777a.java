package com.sec.chaton.p046a.p047a;

import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BuddyEntry.java */
/* renamed from: com.sec.chaton.a.a.a */
/* loaded from: classes.dex */
public class C0777a {

    /* renamed from: a */
    private String f2102a;

    /* renamed from: b */
    private String f2103b;

    /* renamed from: c */
    private String f2104c;

    /* renamed from: d */
    private int f2105d;

    /* renamed from: e */
    private String f2106e;

    public C0777a(String str) {
        this.f2102a = str;
        this.f2103b = GlobalApplication.m10283b().getString(R.string.unknown);
    }

    public C0777a(String str, String str2, String str3) {
        this.f2102a = str;
        this.f2103b = str2;
        this.f2104c = str3;
    }

    public C0777a(String str, String str2, String str3, int i, String str4) {
        this.f2102a = str;
        this.f2103b = str2;
        this.f2104c = str3;
        this.f2105d = i;
        this.f2106e = str4;
    }

    /* renamed from: a */
    public void m3098a(String str) {
        this.f2102a = str;
    }

    /* renamed from: b */
    public void m3100b(String str) {
        this.f2103b = str;
    }

    /* renamed from: c */
    public void m3102c(String str) {
        this.f2104c = str;
    }

    /* renamed from: a */
    public void m3097a(int i) {
        this.f2105d = i;
    }

    /* renamed from: d */
    public void m3104d(String str) {
        this.f2106e = str;
    }

    /* renamed from: a */
    public String m3096a() {
        return this.f2102a;
    }

    /* renamed from: b */
    public String m3099b() {
        return this.f2103b;
    }

    /* renamed from: c */
    public int m3101c() {
        return this.f2105d;
    }

    /* renamed from: d */
    public String m3103d() {
        return this.f2106e;
    }
}
