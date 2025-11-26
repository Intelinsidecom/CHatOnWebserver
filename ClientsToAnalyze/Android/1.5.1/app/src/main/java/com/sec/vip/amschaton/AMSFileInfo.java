package com.sec.vip.amschaton;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class AMSFileInfo {

    /* renamed from: a */
    private String f3938a;

    /* renamed from: b */
    private Bitmap f3939b;

    public AMSFileInfo() {
    }

    public AMSFileInfo(String str, Bitmap bitmap) {
        m3901a(str, bitmap);
    }

    /* renamed from: a */
    public String m3898a() {
        return this.f3938a;
    }

    /* renamed from: a */
    public void m3899a(Bitmap bitmap) {
        this.f3939b = bitmap;
    }

    /* renamed from: a */
    public void m3900a(String str) {
        this.f3938a = str;
    }

    /* renamed from: a */
    public void m3901a(String str, Bitmap bitmap) {
        m3900a(str);
        m3899a(bitmap);
    }

    /* renamed from: b */
    public Bitmap m3902b() {
        return this.f3939b;
    }
}
