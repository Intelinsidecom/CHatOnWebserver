package com.sec.chaton.multimedia.vcalendar;

import android.text.TextUtils;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.Config;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/* compiled from: VCalParser.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.b */
/* loaded from: classes.dex */
public class C1917b {

    /* renamed from: a */
    private C1925j f7329a = new C1925j();

    /* renamed from: b */
    private C1926k f7330b = new C1926k();

    /* renamed from: a */
    public C1925j m7820a(String str) {
        String str2;
        String[] strArrM7819c;
        String strM7818b;
        String str3;
        String[] strArrSplit = str.split("\n");
        String strSubstring = "";
        int length = strArrSplit.length;
        int i = 0;
        while (i < length) {
            String str4 = strArrSplit[i];
            String[] strArrM7819c2 = m7819c(str4);
            if (strArrM7819c2 != null && TextUtils.isEmpty(strArrM7819c2[1])) {
                if (strSubstring != null && strSubstring.endsWith("=")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                }
                str2 = strSubstring + str4;
            } else {
                str2 = "";
            }
            if (!TextUtils.isEmpty(str2)) {
                strArrM7819c = m7819c(str2);
                str3 = str2;
                strM7818b = m7818b(str2);
            } else {
                strArrM7819c = m7819c(str4);
                strM7818b = m7818b(str4);
                str3 = str4;
            }
            String str5 = strArrM7819c[0];
            String strM7821a = m7821a(strArrM7819c[1], strM7818b);
            C3250y.m11454d("Raw Line : " + str4);
            C3250y.m11454d(str5 + " " + strM7821a);
            if ("SUMMARY".equals(str5)) {
                this.f7330b.f7357i = strM7821a;
            } else if ("DTSTART".equals(str5)) {
                this.f7330b.f7351c = strM7821a;
            } else if ("DTEND".equals(str5)) {
                this.f7330b.f7350b = strM7821a;
            } else if ("DUE".equals(str5)) {
                this.f7330b.f7352d = strM7821a;
            } else if ("DESCRIPTION".equals(str5)) {
                this.f7330b.f7349a = strM7821a;
            } else if ("LOCATION".equals(str5)) {
                this.f7330b.f7358j = strM7821a;
            } else if ("COMPLETED".equals(str5)) {
                this.f7330b.f7354f = strM7821a;
            } else if ("RRULE".equals(str5)) {
                this.f7330b.f7355g = strM7821a;
            } else if ("STATUS".equals(str5)) {
                this.f7330b.f7356h = strM7821a;
            } else if ("END".equals(str5) && !strM7821a.startsWith("V")) {
                this.f7330b.f7350b = strM7821a;
            }
            i++;
            strSubstring = str3;
        }
        this.f7329a.m7830a(this.f7330b);
        return this.f7329a;
    }

    /* renamed from: b */
    private String m7818b(String str) {
        String strSubstring = "";
        for (String str2 : str.split(":")[0].split(Config.KEYVALUE_SPLIT)) {
            if (str2.startsWith("CHARSET")) {
                strSubstring = str2.substring(8, str2.length());
            }
        }
        return strSubstring;
    }

    /* renamed from: c */
    private String[] m7819c(String str) {
        String[] strArr = new String[2];
        strArr[0] = str.split(":")[0].split(Config.KEYVALUE_SPLIT)[0];
        if (str.split(":").length > 1) {
            strArr[1] = str.substring(str.indexOf(":") + 1);
        } else {
            strArr[1] = "";
        }
        return strArr;
    }

    /* renamed from: a */
    public String m7821a(String str, String str2) {
        if (str.contains("=") && !TextUtils.isEmpty(str2)) {
            String strReplaceAll = str.replaceAll(Config.KEYVALUE_SPLIT, "");
            String[] strArrSplit = strReplaceAll.split("=");
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int i = 0;
            while (true) {
                if (i >= strReplaceAll.length()) {
                    i = 0;
                    break;
                }
                if (strReplaceAll.charAt(i) == '=') {
                    break;
                }
                i++;
            }
            int i2 = 0;
            for (String str3 : strArrSplit) {
                i2++;
                if (i != 0) {
                    sb.append(str3);
                    i = 0;
                } else {
                    if (str3.length() < 2) {
                        if (sb2.length() > 1) {
                            try {
                                sb.append(new String(new BigInteger(sb2.toString(), 16).toByteArray(), str2));
                                sb2.delete(0, sb2.length());
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                                return strReplaceAll;
                            }
                        }
                        sb.append(str3);
                    } else if (str3.length() > 2) {
                        sb2.append(str3.substring(0, 2));
                        try {
                            String str4 = new String(new BigInteger(sb2.toString(), 16).toByteArray(), str2);
                            C3250y.m11454d(str4);
                            sb.append(str4.trim());
                            sb2.delete(0, sb2.length());
                            sb.append(str3.substring(2, str3.length()));
                        } catch (UnsupportedEncodingException e2) {
                            C3250y.m11442a("Cannot Encode", "VCardParser");
                            return strReplaceAll;
                        }
                    } else {
                        sb2.append(str3);
                    }
                    if (i2 == strArrSplit.length && sb2.length() > 0) {
                        try {
                            String str5 = new String(new BigInteger(sb2.toString(), 16).toByteArray(), str2);
                            C3250y.m11454d(str5);
                            sb.append(str5.trim());
                        } catch (UnsupportedEncodingException e3) {
                            e3.printStackTrace();
                            return strReplaceAll;
                        }
                    }
                }
            }
            return sb.toString();
        }
        return str;
    }
}
