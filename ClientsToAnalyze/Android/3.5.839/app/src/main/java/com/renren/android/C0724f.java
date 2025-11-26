package com.renren.android;

/* compiled from: RenrenException.java */
/* renamed from: com.renren.android.f */
/* loaded from: classes.dex */
public class C0724f extends Exception {

    /* renamed from: a */
    private int f1683a;

    /* renamed from: b */
    private String f1684b;

    public C0724f(int i, String str, String str2) {
        super(str);
        this.f1683a = i;
        this.f1684b = str2;
    }

    public C0724f(C0723e c0723e) {
        super(c0723e.getMessage());
        this.f1683a = c0723e.m2293b();
        this.f1684b = c0723e.m2292a();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "errorCode:" + this.f1683a + "\nerrorMessage:" + getMessage() + "\norgResponse:" + this.f1684b;
    }
}
