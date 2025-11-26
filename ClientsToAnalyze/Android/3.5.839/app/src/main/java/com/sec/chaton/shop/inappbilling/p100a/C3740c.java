package com.sec.chaton.shop.inappbilling.p100a;

/* compiled from: IabException.java */
/* renamed from: com.sec.chaton.shop.inappbilling.a.c */
/* loaded from: classes.dex */
public class C3740c extends Exception {

    /* renamed from: a */
    C3753p f13441a;

    public C3740c(C3753p c3753p) {
        this(c3753p, (Exception) null);
    }

    public C3740c(int i, String str) {
        this(new C3753p(i, str));
    }

    public C3740c(C3753p c3753p, Exception exc) {
        super(c3753p.m14129a(), exc);
        this.f13441a = c3753p;
    }

    public C3740c(int i, String str, Exception exc) {
        this(new C3753p(i, str), exc);
    }

    /* renamed from: a */
    public C3753p m14100a() {
        return this.f13441a;
    }
}
