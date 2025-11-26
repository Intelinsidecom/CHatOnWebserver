package com.sec.chaton.buddy.p019a;

import java.io.Serializable;

/* compiled from: SpecialBuddyItem.java */
/* renamed from: com.sec.chaton.buddy.a.d */
/* loaded from: classes.dex */
public class C0514d implements Serializable {

    /* renamed from: a */
    private String f2399a;

    /* renamed from: b */
    private String f2400b;

    /* renamed from: c */
    private String f2401c;

    /* renamed from: d */
    private String f2402d;

    /* renamed from: e */
    private String f2403e;

    /* renamed from: f */
    private String f2404f;

    /* renamed from: g */
    private String f2405g;

    /* renamed from: h */
    private String f2406h;

    /* renamed from: i */
    private String f2407i;

    /* renamed from: j */
    private String f2408j;

    /* renamed from: k */
    private String f2409k;

    /* renamed from: l */
    private String f2410l;

    /* renamed from: m */
    private String f2411m;

    public C0514d() {
    }

    public C0514d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.f2399a = str;
        this.f2400b = str2;
        this.f2401c = str3;
        this.f2402d = str4;
        this.f2403e = str5;
        this.f2404f = str6;
        this.f2405g = str7;
        this.f2406h = str8;
        this.f2407i = str9;
        this.f2408j = str10;
        this.f2409k = str11;
        this.f2410l = str12;
        this.f2411m = str13;
    }

    public C0514d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.f2399a = str;
        this.f2400b = str2;
        this.f2401c = str3;
        this.f2402d = str4;
        this.f2403e = str5;
        this.f2404f = str6;
        this.f2405g = str7;
        this.f2406h = str8;
        this.f2407i = str9;
        this.f2408j = str10;
        this.f2410l = str11;
        this.f2411m = str12;
    }

    public C0514d(String str, String str2) {
        this.f2399a = str;
        this.f2400b = str2;
        this.f2411m = "0";
        this.f2405g = "y";
    }

    /* renamed from: a */
    public String m4000a() {
        return this.f2399a;
    }

    /* renamed from: b */
    public String m4001b() {
        return this.f2400b;
    }

    /* renamed from: c */
    public String m4002c() {
        return this.f2401c;
    }

    /* renamed from: d */
    public String m4003d() {
        return this.f2402d;
    }

    /* renamed from: e */
    public String m4004e() {
        return this.f2403e;
    }

    /* renamed from: f */
    public String m4005f() {
        return this.f2404f;
    }

    /* renamed from: g */
    public String m4006g() {
        return this.f2405g;
    }

    /* renamed from: h */
    public String m4007h() {
        return this.f2406h;
    }

    /* renamed from: i */
    public String m4008i() {
        return this.f2407i;
    }

    /* renamed from: j */
    public String m4009j() {
        return this.f2408j;
    }

    /* renamed from: k */
    public String m4010k() {
        return this.f2409k;
    }

    /* renamed from: l */
    public String m4011l() {
        return this.f2410l;
    }

    /* renamed from: m */
    public EnumC0515e m4012m() {
        for (EnumC0515e enumC0515e : EnumC0515e.values()) {
            if (enumC0515e.m4013a().equals(this.f2411m)) {
                return enumC0515e;
            }
        }
        return EnumC0515e.NONE;
    }
}
