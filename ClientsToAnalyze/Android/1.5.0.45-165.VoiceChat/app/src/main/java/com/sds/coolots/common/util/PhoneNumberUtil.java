package com.sds.coolots.common.util;

import android.telephony.PhoneNumberUtils;
import com.sds.coolots.MainApplication;
import com.sds.coolots.login.model.NationalCode;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PhoneNumberUtil {
    public static final String INTERNATIONAL_DIRECT_DIALING_NUMBER = "00755";

    /* renamed from: a */
    private static final int f3081a = 5;

    /* renamed from: b */
    private static final int f3082b = 4;

    /* renamed from: c */
    private static final String f3083c = "+";

    /* renamed from: d */
    private static final String f3084d = "61";

    /* renamed from: e */
    private static final String f3085e = "6111";

    /* renamed from: f */
    private static List f3086f = null;

    /* renamed from: g */
    private static List f3087g = null;

    /* renamed from: j */
    private String f3090j;

    /* renamed from: h */
    private NationalCode f3088h = null;

    /* renamed from: i */
    private boolean f3089i = false;

    /* renamed from: k */
    private String f3091k = "";

    /* renamed from: l */
    private String f3092l = "";

    /* renamed from: m */
    private String f3093m = "";

    public PhoneNumberUtil(String str) {
        this.f3090j = str;
        m2979a();
        m2981b();
        try {
            m2982c();
        } catch (Exception e) {
            Log.m2958e("null point exception");
        }
        m2983d();
    }

    /* renamed from: a */
    private void m2979a() {
        if (f3087g == null) {
            f3087g = MainApplication.mPhoneManager.getConfigManager().getNationalCodeListFromMemory();
        }
        if (f3086f == null) {
            f3086f = MainApplication.mPhoneManager.getConfigManager().getNationalCodeAreaListFromMemory();
        }
    }

    /* renamed from: a */
    private boolean m2980a(String str) {
        return getCountryCodeCount(str) > 0;
    }

    /* renamed from: b */
    private void m2981b() {
        if (this.f3090j.indexOf(f3083c) != 0) {
            this.f3093m = this.f3090j;
            return;
        }
        this.f3089i = true;
        this.f3090j = this.f3090j.replace(f3083c, "");
        this.f3093m = INTERNATIONAL_DIRECT_DIALING_NUMBER + this.f3090j;
    }

    /* renamed from: c */
    private void m2982c() {
        if (this.f3090j == null || this.f3090j.length() <= 0) {
            return;
        }
        for (int i = 0; i < this.f3090j.length() && i <= 5; i++) {
            String strSubstring = this.f3090j.substring(0, i + 1);
            if (m2980a(strSubstring)) {
                this.f3091k = strSubstring;
            }
        }
    }

    /* renamed from: d */
    private void m2983d() {
        if (this.f3090j == null || this.f3090j.length() <= 0 || this.f3091k.length() <= 0 || this.f3090j.indexOf(this.f3091k) != 0) {
            return;
        }
        this.f3092l = this.f3090j.substring(this.f3091k.length());
        NationalCode nationaCodeFromCountryCode = MainApplication.mPhoneManager.getConfigManager().getNationaCodeFromCountryCode(this.f3091k);
        if (nationaCodeFromCountryCode == null || !nationaCodeFromCountryCode.isZeroSpace() || this.f3092l == null || this.f3092l.isEmpty() || this.f3092l.charAt(0) == '0') {
            return;
        }
        this.f3092l = "0" + this.f3092l;
    }

    /* renamed from: e */
    private void m2984e() {
        NationalCode nationalCodeByAreaCode;
        if (this.f3091k == null || this.f3090j == null) {
            return;
        }
        int length = this.f3091k.length();
        int length2 = this.f3090j.length();
        if (length <= 0 || length2 <= 0) {
            return;
        }
        while (length < length2 && length <= 4) {
            NationalCode nationalCodeByAreaCode2 = getNationalCodeByAreaCode(this.f3090j.substring(0, length + 1));
            if (nationalCodeByAreaCode2 != null) {
                this.f3088h = nationalCodeByAreaCode2;
            }
            length++;
        }
        if (this.f3088h == null && this.f3091k.equals(f3084d) && (nationalCodeByAreaCode = getNationalCodeByAreaCode(f3085e)) != null) {
            this.f3088h = nationalCodeByAreaCode;
        }
    }

    public static String formatNumber(String str) {
        return str.indexOf(INTERNATIONAL_DIRECT_DIALING_NUMBER) == 0 ? str.replace(INTERNATIONAL_DIRECT_DIALING_NUMBER, f3083c) : PhoneNumberUtils.formatNumber(str);
    }

    public String getCountryCode() {
        return this.f3091k;
    }

    public int getCountryCodeCount(String str) {
        if (str == null || str.length() <= 0 || str.length() > 5) {
            return 0;
        }
        try {
            Iterator it = f3087g.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2 = ((NationalCode) it.next()).getcountryCode().equals(str) ? i + 1 : i;
                if (i2 > 1) {
                    return i2;
                }
                i = i2;
            }
            return i;
        } catch (Exception e) {
            return 0;
        }
    }

    public String getInternationalPhoneNumber() {
        return this.f3093m;
    }

    public NationalCode getNationalCode() {
        m2984e();
        return this.f3088h;
    }

    public NationalCode getNationalCodeByAreaCode(String str) {
        if (str != null && str.length() > 0 && str.length() <= 4) {
            try {
                for (NationalCode nationalCode : f3086f) {
                    if (nationalCode.getAreaCode().equals(str)) {
                        return nationalCode;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String getPhoneNumber() {
        return this.f3092l;
    }

    public boolean isInternationalTelephoneNumber() {
        return this.f3089i && this.f3091k.length() > 0 && this.f3092l.length() > 0;
    }
}
