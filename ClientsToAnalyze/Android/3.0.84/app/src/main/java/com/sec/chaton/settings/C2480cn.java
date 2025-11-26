package com.sec.chaton.settings;

import java.util.Calendar;

/* compiled from: CustomTimeData.java */
/* renamed from: com.sec.chaton.settings.cn */
/* loaded from: classes.dex */
public class C2480cn {

    /* renamed from: a */
    private final long f9340a;

    /* renamed from: b */
    private int f9341b;

    /* renamed from: c */
    private int f9342c;

    /* renamed from: d */
    private int f9343d;

    /* renamed from: e */
    private int f9344e;

    /* renamed from: f */
    private long f9345f;

    /* renamed from: g */
    private long f9346g;

    /* renamed from: h */
    private boolean f9347h;

    public C2480cn(int i, int i2, int i3, int i4, boolean z) {
        this.f9340a = 86400000L;
        this.f9347h = false;
        this.f9341b = i;
        this.f9342c = i2;
        this.f9343d = i3;
        this.f9344e = i4;
        this.f9347h = z;
        m9216k();
    }

    public C2480cn(long j, long j2) {
        this.f9340a = 86400000L;
        this.f9347h = false;
        this.f9345f = j;
        this.f9346g = j2;
        m9215j();
    }

    /* renamed from: j */
    private void m9215j() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.f9345f);
        this.f9341b = calendar.get(11);
        this.f9342c = calendar.get(12);
        calendar.setTimeInMillis(this.f9346g);
        this.f9343d = calendar.get(11);
        this.f9344e = calendar.get(12);
    }

    /* renamed from: k */
    private void m9216k() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), this.f9341b, this.f9342c);
        this.f9345f = calendar.getTimeInMillis();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), this.f9343d, this.f9344e);
        this.f9346g = calendar.getTimeInMillis();
    }

    /* renamed from: a */
    public long m9217a() {
        return this.f9345f;
    }

    /* renamed from: b */
    public long m9218b() {
        return this.f9346g;
    }

    /* renamed from: c */
    public void m9219c() {
        this.f9346g += 86400000;
    }

    /* renamed from: d */
    public void m9220d() {
        this.f9345f += 86400000;
    }

    /* renamed from: e */
    public boolean m9221e() {
        return this.f9347h;
    }

    /* renamed from: f */
    public int m9222f() {
        return this.f9341b;
    }

    /* renamed from: g */
    public int m9223g() {
        return this.f9342c;
    }

    /* renamed from: h */
    public int m9224h() {
        return this.f9343d;
    }

    /* renamed from: i */
    public int m9225i() {
        return this.f9344e;
    }
}
