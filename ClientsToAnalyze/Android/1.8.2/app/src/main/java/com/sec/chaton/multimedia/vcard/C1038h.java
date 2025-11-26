package com.sec.chaton.multimedia.vcard;

import android.telephony.PhoneNumberUtils;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContactStruct.java */
/* renamed from: com.sec.chaton.multimedia.vcard.h */
/* loaded from: classes.dex */
public class C1038h {

    /* renamed from: a */
    public String f3843a;

    /* renamed from: b */
    public String f3844b;

    /* renamed from: c */
    public String f3845c;

    /* renamed from: d */
    public String f3846d;

    /* renamed from: e */
    public String f3847e;

    /* renamed from: f */
    public byte[] f3848f;

    /* renamed from: g */
    public String f3849g;

    /* renamed from: h */
    public List f3850h;

    /* renamed from: i */
    public List f3851i;

    /* renamed from: j */
    public List f3852j;

    /* renamed from: k */
    public List f3853k;

    /* renamed from: l */
    public List f3854l;

    /* renamed from: a */
    public void m4027a(int i, String str, String str2, boolean z) {
        if (this.f3850h == null) {
            this.f3850h = new ArrayList();
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
            strTrim = m4026a(sb.toString(), 1);
        }
        this.f3850h.add(new C1042l(i, strTrim, str2, z));
    }

    /* renamed from: a */
    public static String m4026a(String str, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        PhoneNumberUtils.formatNumber(spannableStringBuilder, i);
        return spannableStringBuilder.toString();
    }

    /* renamed from: b */
    public void m4028b(int i, String str, String str2, boolean z) {
        if (this.f3851i == null) {
            this.f3851i = new ArrayList();
        }
        this.f3851i.add(new C1040j(i, str, str2, z));
    }
}
