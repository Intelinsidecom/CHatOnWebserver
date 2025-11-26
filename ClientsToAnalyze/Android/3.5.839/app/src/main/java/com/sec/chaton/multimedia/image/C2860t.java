package com.sec.chaton.multimedia.image;

import com.sec.chaton.p057e.EnumC2214ab;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.t */
/* loaded from: classes.dex */
public class C2860t {

    /* renamed from: a */
    String f10494a;

    /* renamed from: b */
    long f10495b;

    /* renamed from: c */
    long f10496c;

    /* renamed from: d */
    String f10497d;

    /* renamed from: e */
    String f10498e;

    /* renamed from: f */
    EnumC2214ab f10499f;

    /* renamed from: g */
    int f10500g;

    /* renamed from: h */
    String f10501h;

    /* renamed from: i */
    final /* synthetic */ ImagePagerActivity f10502i;

    public C2860t(ImagePagerActivity imagePagerActivity, String str, long j, long j2, String str2, String str3, EnumC2214ab enumC2214ab, int i) {
        this.f10502i = imagePagerActivity;
        this.f10494a = str;
        this.f10495b = j;
        this.f10496c = j2;
        this.f10497d = str2;
        this.f10498e = str3;
        this.f10499f = enumC2214ab;
        this.f10500g = i;
        if (str2 != null) {
            String[] strArrSplit = str2.split("\n");
            if (strArrSplit.length > 6 && "mixed".equals(strArrSplit[0])) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 6; i2 < strArrSplit.length; i2++) {
                    stringBuffer.append(strArrSplit[i2] + "\n");
                }
                this.f10501h = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("messageId: " + this.f10495b);
        sb.append(", mediaType: " + this.f10499f);
        sb.append(", downloadUri: " + this.f10498e);
        sb.append(", messageType: " + this.f10500g);
        sb.append("\n");
        return sb.toString();
    }
}
