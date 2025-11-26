package com.sec.chaton.multimedia.vcard;

import android.telephony.PhoneNumberUtils;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ContactStruct {

    /* renamed from: a */
    public String f2281a;

    /* renamed from: b */
    public String f2282b;

    /* renamed from: c */
    public String f2283c;

    /* renamed from: d */
    public String f2284d;

    /* renamed from: e */
    public String f2285e;

    /* renamed from: f */
    public byte[] f2286f;

    /* renamed from: g */
    public String f2287g;

    /* renamed from: h */
    public List f2288h;

    /* renamed from: i */
    public List f2289i;

    /* renamed from: j */
    public List f2290j;

    /* renamed from: k */
    public List f2291k;

    /* renamed from: l */
    public List f2292l;

    public class ContactMethod {

        /* renamed from: a */
        public final int f2293a;

        /* renamed from: b */
        public final String f2294b;

        /* renamed from: c */
        public final String f2295c;

        /* renamed from: d */
        public final int f2296d;

        /* renamed from: e */
        public boolean f2297e;

        /* renamed from: f */
        public boolean f2298f = false;

        public ContactMethod(int i, String str, String str2, int i2, boolean z) {
            this.f2293a = i;
            this.f2294b = str;
            this.f2295c = str2;
            this.f2296d = i2;
            this.f2297e = z;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ContactMethod)) {
                return false;
            }
            ContactMethod contactMethod = (ContactMethod) obj;
            return this.f2293a == contactMethod.f2293a && this.f2294b.equals(contactMethod.f2294b) && this.f2295c.equals(contactMethod.f2295c) && this.f2296d == contactMethod.f2296d && this.f2297e == contactMethod.f2297e;
        }

        public String toString() {
            return String.format("type: %d, data: %s, label: %s, kind: %d, isPrimary: %s", Integer.valueOf(this.f2293a), this.f2294b, this.f2295c, Integer.valueOf(this.f2296d), Boolean.valueOf(this.f2297e));
        }
    }

    public class EmailData {

        /* renamed from: a */
        public final int f2299a;

        /* renamed from: b */
        public final String f2300b;

        /* renamed from: c */
        public final String f2301c;

        /* renamed from: d */
        public boolean f2302d;

        public EmailData(int i, String str, String str2, boolean z) {
            this.f2299a = i;
            this.f2300b = str;
            this.f2301c = str2;
            this.f2302d = z;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof EmailData)) {
                return false;
            }
            EmailData emailData = (EmailData) obj;
            return this.f2299a == emailData.f2299a && this.f2300b.equals(emailData.f2300b) && this.f2301c.equals(emailData.f2301c) && this.f2302d == emailData.f2302d;
        }

        public String toString() {
            return String.format("type: %d, data: %s, label: %s, isPrimary: %s", Integer.valueOf(this.f2299a), this.f2300b, this.f2301c, Boolean.valueOf(this.f2302d));
        }
    }

    public class ImData {

        /* renamed from: a */
        public final int f2303a;

        /* renamed from: b */
        public final String f2304b;

        /* renamed from: c */
        public final int f2305c;

        /* renamed from: d */
        public final String f2306d;

        /* renamed from: e */
        public final boolean f2307e;

        public boolean equals(Object obj) {
            if (!(obj instanceof ImData)) {
                return false;
            }
            ImData imData = (ImData) obj;
            return this.f2305c == imData.f2305c && this.f2303a == imData.f2303a && (this.f2304b == null ? imData.f2304b == null : this.f2304b.equals(imData.f2304b)) && (this.f2306d == null ? imData.f2306d == null : this.f2306d.equals(imData.f2306d)) && this.f2307e == imData.f2307e;
        }

        public String toString() {
            return String.format("type: %d, protocol: %d, custom_protcol: %s, data: %s, isPrimary: %s", Integer.valueOf(this.f2305c), Integer.valueOf(this.f2303a), this.f2304b, this.f2306d, Boolean.valueOf(this.f2307e));
        }
    }

    public class PhoneData {

        /* renamed from: a */
        public final int f2308a;

        /* renamed from: b */
        public final String f2309b;

        /* renamed from: c */
        public final String f2310c;

        /* renamed from: d */
        public boolean f2311d;

        public PhoneData(int i, String str, String str2, boolean z) {
            this.f2308a = i;
            this.f2309b = str;
            this.f2310c = str2;
            this.f2311d = z;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PhoneData)) {
                return false;
            }
            PhoneData phoneData = (PhoneData) obj;
            return this.f2308a == phoneData.f2308a && this.f2309b.equals(phoneData.f2309b) && this.f2310c.equals(phoneData.f2310c) && this.f2311d == phoneData.f2311d;
        }

        public String toString() {
            return String.format("type: %d, data: %s, label: %s, isPrimary: %s", Integer.valueOf(this.f2308a), this.f2309b, this.f2310c, Boolean.valueOf(this.f2311d));
        }
    }

    public class PostalData {

        /* renamed from: a */
        public final String f2312a;

        /* renamed from: b */
        public final String f2313b;

        /* renamed from: c */
        public final String f2314c;

        /* renamed from: d */
        public final String f2315d;

        /* renamed from: e */
        public final String f2316e;

        /* renamed from: f */
        public final String f2317f;

        /* renamed from: g */
        public final String f2318g;

        /* renamed from: h */
        public final int f2319h;

        /* renamed from: i */
        public final String f2320i;

        /* renamed from: j */
        public boolean f2321j;

        /* renamed from: k */
        private final String[] f2322k;

        public boolean equals(Object obj) {
            if (!(obj instanceof PostalData)) {
                return false;
            }
            PostalData postalData = (PostalData) obj;
            return Arrays.equals(this.f2322k, postalData.f2322k) && this.f2319h == postalData.f2319h && (this.f2319h != 0 || this.f2320i == postalData.f2320i) && this.f2321j == postalData.f2321j;
        }

        public String toString() {
            return String.format("type: %d, label: %s, isPrimary: %s", Integer.valueOf(this.f2319h), this.f2320i, Boolean.valueOf(this.f2321j));
        }
    }

    /* renamed from: a */
    public static String m2615a(String str, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        PhoneNumberUtils.formatNumber(spannableStringBuilder, i);
        return spannableStringBuilder.toString();
    }

    /* renamed from: a */
    public void m2616a(int i, String str, String str2, boolean z) {
        String strM2615a;
        if (this.f2288h == null) {
            this.f2288h = new ArrayList();
        }
        StringBuilder sb = new StringBuilder();
        String strTrim = str.trim();
        if (i == 6) {
            strM2615a = strTrim;
        } else {
            int length = strTrim.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = strTrim.charAt(i2);
                if (('0' <= cCharAt && cCharAt <= '9') || (i2 == 0 && cCharAt == '+')) {
                    sb.append(cCharAt);
                }
            }
            strM2615a = m2615a(sb.toString(), 1);
        }
        this.f2288h.add(new PhoneData(i, strM2615a, str2, z));
    }

    /* renamed from: b */
    public void m2617b(int i, String str, String str2, boolean z) {
        if (this.f2289i == null) {
            this.f2289i = new ArrayList();
        }
        this.f2289i.add(new EmailData(i, str, str2, z));
    }
}
