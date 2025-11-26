package com.sec.chaton.shop.inappbilling.p100a;

/* compiled from: IabResult.java */
/* renamed from: com.sec.chaton.shop.inappbilling.a.p */
/* loaded from: classes.dex */
public class C3753p {

    /* renamed from: a */
    int f13473a;

    /* renamed from: b */
    String f13474b;

    public C3753p(int i, String str) {
        this.f13473a = i;
        if (str == null || str.trim().length() == 0) {
            this.f13474b = C3741d.m14101a(i);
        } else {
            this.f13474b = str + " (response: " + C3741d.m14101a(i) + ")";
        }
    }

    /* renamed from: a */
    public String m14129a() {
        return this.f13474b;
    }

    /* renamed from: b */
    public boolean m14130b() {
        return this.f13473a == 0;
    }

    /* renamed from: c */
    public boolean m14131c() {
        return !m14130b();
    }

    public String toString() {
        return "IabResult: " + m14129a();
    }
}
