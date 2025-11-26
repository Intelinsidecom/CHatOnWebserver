package com.sec.chaton.multimedia.image;

import com.sec.chaton.util.C3250y;

/* compiled from: PostONImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.aj */
/* loaded from: classes.dex */
public class C1859aj {

    /* renamed from: a */
    String f7087a;

    /* renamed from: b */
    String f7088b;

    /* renamed from: c */
    String f7089c;

    /* renamed from: d */
    String f7090d;

    /* renamed from: e */
    String f7091e;

    /* renamed from: f */
    String f7092f;

    /* renamed from: g */
    String f7093g;

    /* renamed from: h */
    String f7094h;

    /* renamed from: i */
    String f7095i;

    /* renamed from: j */
    String f7096j;

    /* renamed from: k */
    String f7097k;

    /* renamed from: l */
    final /* synthetic */ PostONImagePagerActivity f7098l;

    public C1859aj(PostONImagePagerActivity postONImagePagerActivity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f7098l = postONImagePagerActivity;
        this.f7087a = str;
        this.f7088b = str2;
        this.f7089c = str3;
        this.f7090d = str4;
        this.f7091e = str5;
        this.f7092f = str6;
        this.f7093g = str7;
        this.f7094h = str8;
        this.f7095i = str9;
        this.f7096j = str10;
        this.f7097k = str11;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("postonNo: " + this.f7087a);
        sb.append(", postonMetaId: " + this.f7088b);
        sb.append(", postonMetaType: " + this.f7089c);
        sb.append(", postonUrl: " + this.f7090d);
        sb.append(", sender: " + this.f7092f);
        sb.append("\n");
        return sb.toString();
    }

    /* renamed from: a */
    public String m7699a() {
        if (C3250y.f11733a) {
            C3250y.m11456e("Read comment : " + this.f7095i + " / unReadConnent : " + this.f7096j, PostONImagePagerActivity.f6962b);
        }
        return String.valueOf(Integer.parseInt(this.f7095i) + Integer.parseInt(this.f7096j));
    }
}
