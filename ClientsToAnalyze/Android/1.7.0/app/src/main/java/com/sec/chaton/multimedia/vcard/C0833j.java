package com.sec.chaton.multimedia.vcard;

import android.telephony.PhoneNumberUtils;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.j */
/* loaded from: classes.dex */
public class C0833j {

    /* renamed from: a */
    public String f2895a;

    /* renamed from: b */
    public String f2896b;

    /* renamed from: c */
    public String f2897c;

    /* renamed from: d */
    public String f2898d;

    /* renamed from: e */
    public String f2899e;

    /* renamed from: f */
    public byte[] f2900f;

    /* renamed from: g */
    public String f2901g;

    /* renamed from: h */
    public List f2902h;

    /* renamed from: i */
    public List f2903i;

    /* renamed from: j */
    public List f2904j;

    /* renamed from: k */
    public List f2905k;

    /* renamed from: l */
    public List f2906l;

    /* renamed from: a */
    public void m3406a(int i, String str, String str2, boolean z) {
        if (this.f2902h == null) {
            this.f2902h = new ArrayList();
        }
        StringBuilder sb = new StringBuilder();
        String strTrim = str.trim();
        if (i != 6) {
            int length = strTrim.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = strTrim.charAt(i2);
                if (('0' <= cCharAt && cCharAt <= '9') || (i2 == 0 && cCharAt == '+')) {
                    sb.append(cCharAt);
                }
            }
            strTrim = m3405a(sb.toString(), 1);
        }
        this.f2902h.add(new C0825b(i, strTrim, str2, z));
    }

    /* renamed from: a */
    public static String m3405a(String str, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        PhoneNumberUtils.formatNumber(spannableStringBuilder, i);
        return spannableStringBuilder.toString();
    }

    /* renamed from: b */
    public void m3407b(int i, String str, String str2, boolean z) {
        if (this.f2903i == null) {
            this.f2903i = new ArrayList();
        }
        this.f2903i.add(new C0842s(i, str, str2, z));
    }
}
