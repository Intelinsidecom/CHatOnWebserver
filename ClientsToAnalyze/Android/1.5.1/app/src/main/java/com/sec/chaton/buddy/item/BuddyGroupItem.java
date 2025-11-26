package com.sec.chaton.buddy.item;

/* loaded from: classes.dex */
public class BuddyGroupItem {

    /* renamed from: a */
    private int f662a;

    /* renamed from: b */
    private String f663b;

    /* renamed from: c */
    private int f664c;

    /* renamed from: d */
    private int f665d;

    /* renamed from: e */
    private boolean f666e;

    /* renamed from: f */
    private boolean f667f;

    /* renamed from: g */
    private int f668g;

    public BuddyGroupItem() {
    }

    public BuddyGroupItem(int i, String str, int i2, int i3, boolean z, boolean z2, int i4) {
        this.f662a = i;
        this.f663b = str;
        this.f664c = i2;
        this.f665d = i3;
        this.f666e = z;
        this.f668g = i4;
        this.f667f = false;
    }

    public BuddyGroupItem(BuddyGroupItem buddyGroupItem) {
        this.f662a = buddyGroupItem.m655a();
        this.f663b = buddyGroupItem.m657b();
        this.f664c = buddyGroupItem.m658c();
        this.f665d = buddyGroupItem.m659d();
        this.f666e = buddyGroupItem.m660e();
        this.f668g = buddyGroupItem.m661f();
        this.f667f = buddyGroupItem.m662g();
    }

    /* renamed from: a */
    public int m655a() {
        return this.f662a;
    }

    /* renamed from: a */
    public void m656a(int i) {
        this.f664c = i;
    }

    /* renamed from: b */
    public String m657b() {
        return this.f663b;
    }

    /* renamed from: c */
    public int m658c() {
        return this.f664c;
    }

    /* renamed from: d */
    public int m659d() {
        return this.f665d;
    }

    /* renamed from: e */
    public boolean m660e() {
        return this.f666e;
    }

    /* renamed from: f */
    public int m661f() {
        return this.f668g;
    }

    /* renamed from: g */
    public boolean m662g() {
        return this.f667f;
    }
}
