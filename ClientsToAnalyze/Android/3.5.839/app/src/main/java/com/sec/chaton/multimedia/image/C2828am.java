package com.sec.chaton.multimedia.image;

import com.sec.chaton.util.C4904y;

/* compiled from: PostONImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.am */
/* loaded from: classes.dex */
public class C2828am {

    /* renamed from: a */
    String f10398a;

    /* renamed from: b */
    String f10399b;

    /* renamed from: c */
    String f10400c;

    /* renamed from: d */
    String f10401d;

    /* renamed from: e */
    String f10402e;

    /* renamed from: f */
    String f10403f;

    /* renamed from: g */
    String f10404g;

    /* renamed from: h */
    String f10405h;

    /* renamed from: i */
    String f10406i;

    /* renamed from: j */
    String f10407j;

    /* renamed from: k */
    String f10408k;

    /* renamed from: l */
    final /* synthetic */ PostONImagePagerActivity f10409l;

    public C2828am(PostONImagePagerActivity postONImagePagerActivity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f10409l = postONImagePagerActivity;
        this.f10398a = str;
        this.f10399b = str2;
        this.f10400c = str3;
        this.f10401d = str4;
        this.f10402e = str5;
        this.f10403f = str6;
        this.f10404g = str7;
        this.f10405h = str8;
        this.f10406i = str9;
        this.f10407j = str10;
        this.f10408k = str11;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("postonNo: " + this.f10398a);
        sb.append(", postonMetaId: " + this.f10399b);
        sb.append(", postonMetaType: " + this.f10400c);
        sb.append(", postonUrl: " + this.f10401d);
        sb.append(", sender: " + this.f10403f);
        sb.append("\n");
        return sb.toString();
    }

    /* renamed from: a */
    public String m11925a() {
        if (C4904y.f17871a) {
            C4904y.m18646e("Read comment : " + this.f10406i + " / unReadConnent : " + this.f10407j, PostONImagePagerActivity.f10266o);
        }
        return String.valueOf(Integer.parseInt(this.f10406i) + Integer.parseInt(this.f10407j));
    }
}
