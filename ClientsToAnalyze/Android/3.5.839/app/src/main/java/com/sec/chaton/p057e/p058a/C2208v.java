package com.sec.chaton.p057e.p058a;

import android.text.TextUtils;

/* compiled from: NormalizedPhoneNumber.java */
/* renamed from: com.sec.chaton.e.a.v */
/* loaded from: classes.dex */
public class C2208v {

    /* renamed from: a */
    String f7889a;

    /* renamed from: b */
    String f7890b;

    /* renamed from: c */
    EnumC2209w f7891c;

    public C2208v(String str) {
        this.f7891c = EnumC2209w.NOT_DETERMINED;
        this.f7890b = str;
        if (!TextUtils.isEmpty(str)) {
            this.f7889a = str.replaceAll("[^\\+\\*\\#0-9]", "");
            if (TextUtils.isEmpty(this.f7889a)) {
                this.f7891c = EnumC2209w.NOT_PHONE_NUMBER;
            } else if (this.f7889a.length() < 8) {
                this.f7891c = EnumC2209w.PHONE_NUMBER_BELOW_DIGIT_8;
            } else {
                this.f7891c = EnumC2209w.PHONE_NUMBER_DIGIT_8_AND_OVER;
            }
        }
    }

    /* renamed from: a */
    public String m10060a() {
        return this.f7889a;
    }

    /* renamed from: b */
    public String m10061b() {
        return this.f7890b;
    }

    /* renamed from: c */
    public String m10062c() {
        if (TextUtils.isEmpty(this.f7889a)) {
            return null;
        }
        return "%" + this.f7889a.substring(this.f7889a.length() - 8) + "%";
    }

    /* renamed from: d */
    public EnumC2209w m10063d() {
        return this.f7891c;
    }
}
