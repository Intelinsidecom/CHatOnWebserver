package com.renren.android;

/* compiled from: RenrenError.java */
/* renamed from: com.renren.android.e */
/* loaded from: classes.dex */
public class C0723e extends RuntimeException {

    /* renamed from: a */
    private int f1681a;

    /* renamed from: b */
    private String f1682b;

    public C0723e() {
    }

    public C0723e(String str) {
        super(str);
    }

    public C0723e(int i, String str, String str2) {
        super(str);
        this.f1681a = i;
        this.f1682b = str2;
    }

    /* renamed from: a */
    public String m2292a() {
        return this.f1682b;
    }

    /* renamed from: b */
    public int m2293b() {
        return this.f1681a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "errorCode:" + this.f1681a + "\nerrorMessage:" + getMessage() + "\norgResponse:" + this.f1682b;
    }

    /* renamed from: a */
    public static String m2291a(int i, String str) {
        switch (i) {
            case 300:
                return "";
            case 20101:
                return "请稍后重试";
            case 20102:
            case 20103:
                return "暂不支持此格式照片，请重新选择";
            default:
                return str;
        }
    }
}
