package com.sec.chaton.shop.inappbilling.p100a;

import org.json.JSONObject;

/* compiled from: Purchase.java */
/* renamed from: com.sec.chaton.shop.inappbilling.a.s */
/* loaded from: classes.dex */
public class C3756s {

    /* renamed from: a */
    String f13484a;

    /* renamed from: b */
    String f13485b;

    /* renamed from: c */
    String f13486c;

    /* renamed from: d */
    String f13487d;

    /* renamed from: e */
    long f13488e;

    /* renamed from: f */
    int f13489f;

    /* renamed from: g */
    String f13490g;

    /* renamed from: h */
    String f13491h;

    /* renamed from: i */
    String f13492i;

    /* renamed from: j */
    String f13493j;

    public C3756s(String str, String str2, String str3) {
        this.f13484a = str;
        this.f13492i = str2;
        JSONObject jSONObject = new JSONObject(this.f13492i);
        this.f13485b = jSONObject.optString("orderId");
        this.f13486c = jSONObject.optString("packageName");
        this.f13487d = jSONObject.optString("productId");
        this.f13488e = jSONObject.optLong("purchaseTime");
        this.f13489f = jSONObject.optInt("purchaseState");
        this.f13490g = jSONObject.optString("developerPayload");
        this.f13491h = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.f13493j = str3;
    }

    /* renamed from: a */
    public String m14137a() {
        return this.f13484a;
    }

    /* renamed from: b */
    public String m14138b() {
        return this.f13487d;
    }

    /* renamed from: c */
    public String m14139c() {
        return this.f13490g;
    }

    /* renamed from: d */
    public String m14140d() {
        return this.f13491h;
    }

    /* renamed from: e */
    public String m14141e() {
        return this.f13492i;
    }

    /* renamed from: f */
    public String m14142f() {
        return this.f13493j;
    }

    public String toString() {
        return "PurchaseInfo(type:" + this.f13484a + "):" + this.f13492i;
    }
}
