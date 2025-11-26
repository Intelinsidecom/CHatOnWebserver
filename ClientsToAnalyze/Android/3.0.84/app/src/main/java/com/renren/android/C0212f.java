package com.renren.android;

/* compiled from: RenrenException.java */
/* renamed from: com.renren.android.f */
/* loaded from: classes.dex */
public class C0212f extends Exception {

    /* renamed from: a */
    private int f447a;

    /* renamed from: b */
    private String f448b;

    public C0212f(int i, String str, String str2) {
        super(str);
        this.f447a = i;
        this.f448b = str2;
    }

    public C0212f(C0211e c0211e) {
        super(c0211e.getMessage());
        this.f447a = c0211e.m561b();
        this.f448b = c0211e.m560a();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "errorCode:" + this.f447a + "\nerrorMessage:" + getMessage() + "\norgResponse:" + this.f448b;
    }
}
