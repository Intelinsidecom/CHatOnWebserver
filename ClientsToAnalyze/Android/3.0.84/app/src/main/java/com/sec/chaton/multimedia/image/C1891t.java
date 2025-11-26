package com.sec.chaton.multimedia.image;

import com.sec.chaton.p027e.EnumC1455w;
import twitter4j.Query;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.t */
/* loaded from: classes.dex */
public class C1891t {

    /* renamed from: a */
    String f7174a;

    /* renamed from: b */
    long f7175b;

    /* renamed from: c */
    long f7176c;

    /* renamed from: d */
    String f7177d;

    /* renamed from: e */
    String f7178e;

    /* renamed from: f */
    EnumC1455w f7179f;

    /* renamed from: g */
    int f7180g;

    /* renamed from: h */
    String f7181h;

    /* renamed from: i */
    final /* synthetic */ ImagePagerActivity f7182i;

    public C1891t(ImagePagerActivity imagePagerActivity, String str, long j, long j2, String str2, String str3, EnumC1455w enumC1455w, int i) {
        this.f7182i = imagePagerActivity;
        this.f7174a = str;
        this.f7175b = j;
        this.f7176c = j2;
        this.f7177d = str2;
        this.f7178e = str3;
        this.f7179f = enumC1455w;
        this.f7180g = i;
        if (str2 != null) {
            String[] strArrSplit = str2.split("\n");
            if (strArrSplit.length > 6 && Query.MIXED.equals(strArrSplit[0])) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 6; i2 < strArrSplit.length; i2++) {
                    stringBuffer.append(strArrSplit[i2] + "\n");
                }
                this.f7181h = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("messageId: " + this.f7175b);
        sb.append(", mediaType: " + this.f7179f);
        sb.append(", downloadUri: " + this.f7178e);
        sb.append(", messageType: " + this.f7180g);
        sb.append("\n");
        return sb.toString();
    }
}
