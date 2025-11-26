package com.sec.chaton.multimedia.vcalendar;

import android.text.TextUtils;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/* compiled from: VCalParser.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.b */
/* loaded from: classes.dex */
public class C2886b {

    /* renamed from: a */
    private C2894j f10650a = new C2894j();

    /* renamed from: b */
    private C2895k f10651b = new C2895k();

    /* renamed from: a */
    public C2894j m12050a(String str) {
        String str2;
        String[] strArrM12049c;
        String strM12048b;
        String str3 = "";
        for (String str4 : str.split("\n")) {
            String[] strArrM12049c2 = m12049c(str4);
            if (strArrM12049c2 != null && TextUtils.isEmpty(strArrM12049c2[1]) && str3 != null && str3.endsWith("=")) {
                str2 = str3.substring(0, str3.length() - 1) + str4;
            } else {
                str2 = "";
            }
            if (!TextUtils.isEmpty(str2)) {
                strArrM12049c = m12049c(str2);
                str3 = str2;
                strM12048b = m12048b(str2);
            } else {
                strArrM12049c = m12049c(str4);
                strM12048b = m12048b(str4);
                str3 = str4;
            }
            String str5 = strArrM12049c[0];
            String strM12051a = m12051a(strArrM12049c[1], strM12048b);
            if (!TextUtils.isEmpty(strM12051a)) {
                C4904y.m18644d("Raw Line : " + str4);
                C4904y.m18644d(str5 + " " + strM12051a);
                if ("SUMMARY".equals(str5)) {
                    this.f10651b.f10678i = strM12051a;
                } else if ("DTSTART".equals(str5)) {
                    this.f10651b.f10672c = strM12051a;
                } else if ("DTEND".equals(str5)) {
                    this.f10651b.f10671b = strM12051a;
                } else if ("DUE".equals(str5)) {
                    this.f10651b.f10673d = strM12051a;
                } else if ("DESCRIPTION".equals(str5)) {
                    this.f10651b.f10670a = strM12051a;
                } else if ("LOCATION".equals(str5)) {
                    this.f10651b.f10679j = strM12051a;
                } else if ("COMPLETED".equals(str5)) {
                    this.f10651b.f10675f = strM12051a;
                } else if ("RRULE".equals(str5)) {
                    this.f10651b.f10676g = strM12051a;
                } else if ("STATUS".equals(str5)) {
                    this.f10651b.f10677h = strM12051a;
                } else if ("END".equals(str5) && !strM12051a.startsWith("V")) {
                    this.f10651b.f10671b = strM12051a;
                }
            }
        }
        this.f10650a.m12059a(this.f10651b);
        return this.f10650a;
    }

    /* renamed from: b */
    private String m12048b(String str) {
        String strSubstring = "";
        for (String str2 : str.split(":")[0].split(Config.KEYVALUE_SPLIT)) {
            if (str2.startsWith("CHARSET")) {
                strSubstring = str2.substring(8, str2.length());
            }
        }
        return strSubstring;
    }

    /* renamed from: c */
    private String[] m12049c(String str) {
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
    public String m12051a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.contains("=") && !TextUtils.isEmpty(str2)) {
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
                            C4904y.m18644d(str4);
                            sb.append(str4.trim());
                            sb2.delete(0, sb2.length());
                            sb.append(str3.substring(2, str3.length()));
                        } catch (UnsupportedEncodingException e2) {
                            C4904y.m18634a("Cannot Encode", "VCardParser");
                            return strReplaceAll;
                        }
                    } else {
                        sb2.append(str3);
                    }
                    if (i2 == strArrSplit.length && sb2.length() > 0) {
                        try {
                            String str5 = new String(new BigInteger(sb2.toString(), 16).toByteArray(), str2);
                            C4904y.m18644d(str5);
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
