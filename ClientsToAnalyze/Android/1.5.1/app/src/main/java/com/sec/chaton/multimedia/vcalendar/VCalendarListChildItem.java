package com.sec.chaton.multimedia.vcalendar;

/* loaded from: classes.dex */
public class VCalendarListChildItem {

    /* renamed from: a */
    private String f2213a;

    /* renamed from: b */
    private Long f2214b;

    /* renamed from: c */
    private Long f2215c;

    /* renamed from: d */
    private String f2216d;

    /* renamed from: e */
    private String f2217e;

    public VCalendarListChildItem() {
    }

    public VCalendarListChildItem(VCalendarListChildItem vCalendarListChildItem) {
        this.f2213a = vCalendarListChildItem.m2582a();
        this.f2214b = vCalendarListChildItem.m2583b();
        this.f2215c = vCalendarListChildItem.m2584c();
        this.f2216d = vCalendarListChildItem.m2585d();
        this.f2217e = vCalendarListChildItem.m2586e();
    }

    public VCalendarListChildItem(String str, Long l, Long l2, String str2, String str3) {
        this.f2213a = str;
        this.f2214b = l;
        this.f2215c = l2;
        this.f2216d = str2;
        this.f2217e = str3;
    }

    /* renamed from: a */
    public String m2582a() {
        return this.f2213a;
    }

    /* renamed from: b */
    public Long m2583b() {
        return this.f2214b;
    }

    /* renamed from: c */
    public Long m2584c() {
        return this.f2215c;
    }

    /* renamed from: d */
    public String m2585d() {
        return this.f2216d;
    }

    /* renamed from: e */
    public String m2586e() {
        return this.f2217e;
    }
}
