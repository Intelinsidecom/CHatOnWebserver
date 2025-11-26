package com.sec.chaton.shop.inappbilling.p100a;

import org.json.JSONObject;

/* compiled from: ProductDetails.java */
/* renamed from: com.sec.chaton.shop.inappbilling.a.r */
/* loaded from: classes.dex */
public class C3755r {

    /* renamed from: a */
    String f13477a;

    /* renamed from: b */
    String f13478b;

    /* renamed from: c */
    String f13479c;

    /* renamed from: d */
    String f13480d;

    /* renamed from: e */
    String f13481e;

    /* renamed from: f */
    String f13482f;

    /* renamed from: g */
    String f13483g;

    public C3755r(String str, String str2) {
        this.f13477a = str;
        this.f13483g = str2;
        JSONObject jSONObject = new JSONObject(this.f13483g);
        this.f13478b = jSONObject.optString("productId");
        this.f13479c = jSONObject.optString("type");
        this.f13480d = jSONObject.optString("price");
        this.f13481e = jSONObject.optString("title");
        this.f13482f = jSONObject.optString("description");
    }

    /* renamed from: a */
    public String m14136a() {
        return this.f13478b;
    }

    public String toString() {
        return "SkuDetails:" + this.f13483g;
    }
}
