package com.sec.chaton.settings;

import java.util.Calendar;

/* compiled from: CustomTimeData.java */
/* renamed from: com.sec.chaton.settings.dl */
/* loaded from: classes.dex */
public class C3575dl {

    /* renamed from: a */
    private final long f13065a;

    /* renamed from: b */
    private int f13066b;

    /* renamed from: c */
    private int f13067c;

    /* renamed from: d */
    private int f13068d;

    /* renamed from: e */
    private int f13069e;

    /* renamed from: f */
    private long f13070f;

    /* renamed from: g */
    private long f13071g;

    /* renamed from: h */
    private boolean f13072h;

    /* renamed from: a */
    public static C3575dl m13852a(int i, int i2, int i3, int i4, boolean z) {
        return new C3575dl(i, i2, i3, i4, z);
    }

    /* renamed from: a */
    public static C3575dl m13853a(long j, long j2) {
        return new C3575dl(j, j2);
    }

    private C3575dl(int i, int i2, int i3, int i4, boolean z) {
        this.f13065a = 86400000L;
        this.f13072h = false;
        this.f13066b = i;
        this.f13067c = i2;
        this.f13068d = i3;
        this.f13069e = i4;
        this.f13072h = z;
        m13855k();
    }

    private C3575dl(long j, long j2) {
        this.f13065a = 86400000L;
        this.f13072h = false;
        this.f13070f = j;
        this.f13071g = j2;
        m13854j();
    }

    /* renamed from: j */
    private void m13854j() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.f13070f);
        this.f13066b = calendar.get(11);
        this.f13067c = calendar.get(12);
        calendar.setTimeInMillis(this.f13071g);
        this.f13068d = calendar.get(11);
        this.f13069e = calendar.get(12);
    }

    /* renamed from: k */
    private void m13855k() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), this.f13066b, this.f13067c);
        this.f13070f = calendar.getTimeInMillis();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), this.f13068d, this.f13069e);
        this.f13071g = calendar.getTimeInMillis();
    }

    /* renamed from: a */
    public long m13856a() {
        return this.f13070f;
    }

    /* renamed from: b */
    public long m13857b() {
        return this.f13071g;
    }

    /* renamed from: c */
    public void m13858c() {
        this.f13071g += 86400000;
    }

    /* renamed from: d */
    public void m13859d() {
        this.f13070f += 86400000;
    }

    /* renamed from: e */
    public boolean m13860e() {
        return this.f13072h;
    }

    /* renamed from: f */
    public int m13861f() {
        return this.f13066b;
    }

    /* renamed from: g */
    public int m13862g() {
        return this.f13067c;
    }

    /* renamed from: h */
    public int m13863h() {
        return this.f13068d;
    }

    /* renamed from: i */
    public int m13864i() {
        return this.f13069e;
    }
}
