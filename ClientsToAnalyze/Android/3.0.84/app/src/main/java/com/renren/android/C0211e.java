package com.renren.android;

import twitter4j.internal.http.HttpResponseCode;

/* compiled from: RenrenError.java */
/* renamed from: com.renren.android.e */
/* loaded from: classes.dex */
public class C0211e extends RuntimeException {

    /* renamed from: a */
    private int f445a;

    /* renamed from: b */
    private String f446b;

    public C0211e() {
    }

    public C0211e(String str) {
        super(str);
    }

    public C0211e(int i, String str, String str2) {
        super(str);
        this.f445a = i;
        this.f446b = str2;
    }

    /* renamed from: a */
    public String m560a() {
        return this.f446b;
    }

    /* renamed from: b */
    public int m561b() {
        return this.f445a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "errorCode:" + this.f445a + "\nerrorMessage:" + getMessage() + "\norgResponse:" + this.f446b;
    }

    /* renamed from: a */
    public static String m559a(int i, String str) {
        switch (i) {
            case HttpResponseCode.MULTIPLE_CHOICES /* 300 */:
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
