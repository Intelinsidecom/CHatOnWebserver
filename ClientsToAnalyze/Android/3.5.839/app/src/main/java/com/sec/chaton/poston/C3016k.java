package com.sec.chaton.poston;

import com.sec.chaton.p057e.p058a.C2179ae;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: PostONAdapter.java */
/* renamed from: com.sec.chaton.poston.k */
/* loaded from: classes.dex */
public class C3016k {

    /* renamed from: a */
    private String f11153a;

    /* renamed from: b */
    private String f11154b;

    /* renamed from: c */
    private String f11155c;

    /* renamed from: d */
    private String f11156d;

    /* renamed from: e */
    private String f11157e;

    /* renamed from: f */
    private String f11158f;

    /* renamed from: g */
    private String f11159g;

    /* renamed from: h */
    private String f11160h;

    /* renamed from: i */
    private ArrayList<C3007by> f11161i;

    /* renamed from: j */
    private ArrayList<C2179ae> f11162j;

    /* renamed from: k */
    private String f11163k;

    /* renamed from: l */
    private String f11164l;

    /* renamed from: m */
    private String f11165m;

    public C3016k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, ArrayList<C3007by> arrayList, ArrayList<C2179ae> arrayList2, String str9, String str10) {
        this.f11153a = str;
        this.f11154b = str2;
        this.f11155c = str3;
        this.f11156d = str4;
        this.f11157e = str5;
        this.f11158f = str6;
        this.f11159g = str7;
        this.f11160h = str8;
        this.f11161i = arrayList;
        this.f11162j = arrayList2;
        this.f11164l = str9;
        this.f11165m = str10;
    }

    /* renamed from: a */
    public String m12365a() {
        return this.f11164l;
    }

    /* renamed from: b */
    public String m12367b() {
        return this.f11153a;
    }

    /* renamed from: c */
    public String m12368c() {
        return this.f11154b;
    }

    /* renamed from: d */
    public String m12369d() {
        return this.f11155c;
    }

    /* renamed from: e */
    public String m12370e() {
        return this.f11156d;
    }

    /* renamed from: f */
    public String m12371f() {
        return this.f11157e;
    }

    /* renamed from: g */
    public String m12372g() {
        return this.f11158f;
    }

    /* renamed from: h */
    public String m12373h() {
        return this.f11165m;
    }

    /* renamed from: a */
    public String m12366a(int i) {
        if (this.f11162j != null && this.f11162j.size() > i) {
            this.f11163k = this.f11162j.get(i).m9728b();
        }
        if (C4904y.f17871a) {
            C4904y.m18646e("getUrl(): " + this.f11163k, getClass().getSimpleName());
        }
        return this.f11163k;
    }

    /* renamed from: i */
    public ArrayList<C3007by> m12374i() {
        return this.f11161i;
    }

    /* renamed from: j */
    public ArrayList<C2179ae> m12375j() {
        return this.f11162j;
    }

    /* renamed from: k */
    public String m12376k() {
        return String.valueOf(Integer.parseInt(this.f11158f) + Integer.parseInt(this.f11159g));
    }
}
