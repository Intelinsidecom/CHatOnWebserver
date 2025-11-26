package com.sec.chaton.poston;

import com.sec.chaton.p027e.p028a.C1352aa;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: PostONAdapter.java */
/* renamed from: com.sec.chaton.poston.k */
/* loaded from: classes.dex */
public class C2020k {

    /* renamed from: a */
    private String f7757a;

    /* renamed from: b */
    private String f7758b;

    /* renamed from: c */
    private String f7759c;

    /* renamed from: d */
    private String f7760d;

    /* renamed from: e */
    private String f7761e;

    /* renamed from: f */
    private String f7762f;

    /* renamed from: g */
    private String f7763g;

    /* renamed from: h */
    private String f7764h;

    /* renamed from: i */
    private ArrayList<C2011bx> f7765i;

    /* renamed from: j */
    private ArrayList<C1352aa> f7766j;

    /* renamed from: k */
    private String f7767k;

    /* renamed from: l */
    private String f7768l;

    /* renamed from: m */
    private String f7769m;

    public C2020k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, ArrayList<C2011bx> arrayList, ArrayList<C1352aa> arrayList2, String str9, String str10) {
        this.f7757a = str;
        this.f7758b = str2;
        this.f7759c = str3;
        this.f7760d = str4;
        this.f7761e = str5;
        this.f7762f = str6;
        this.f7763g = str7;
        this.f7764h = str8;
        this.f7765i = arrayList;
        this.f7766j = arrayList2;
        this.f7768l = str9;
        this.f7769m = str10;
    }

    /* renamed from: a */
    public String m8045a() {
        return this.f7768l;
    }

    /* renamed from: b */
    public String m8047b() {
        return this.f7757a;
    }

    /* renamed from: c */
    public String m8048c() {
        return this.f7758b;
    }

    /* renamed from: d */
    public String m8049d() {
        return this.f7759c;
    }

    /* renamed from: e */
    public String m8050e() {
        return this.f7760d;
    }

    /* renamed from: f */
    public String m8051f() {
        return this.f7761e;
    }

    /* renamed from: g */
    public String m8052g() {
        return this.f7762f;
    }

    /* renamed from: h */
    public String m8053h() {
        return this.f7769m;
    }

    /* renamed from: a */
    public String m8046a(int i) {
        if (this.f7766j != null && this.f7766j.size() > i) {
            this.f7767k = this.f7766j.get(i).m5959b();
        }
        if (C3250y.f11733a) {
            C3250y.m11456e("getUrl(): " + this.f7767k, getClass().getSimpleName());
        }
        return this.f7767k;
    }

    /* renamed from: i */
    public ArrayList<C2011bx> m8054i() {
        return this.f7765i;
    }

    /* renamed from: j */
    public ArrayList<C1352aa> m8055j() {
        return this.f7766j;
    }

    /* renamed from: k */
    public String m8056k() {
        return String.valueOf(Integer.parseInt(this.f7762f) + Integer.parseInt(this.f7763g));
    }
}
