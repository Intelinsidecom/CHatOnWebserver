package com.sec.chaton.multimedia.vcalendar;

import android.text.TextUtils;
import com.sec.chaton.util.C1341p;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/* compiled from: VCalParser.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.m */
/* loaded from: classes.dex */
public class C0823m {

    /* renamed from: a */
    private C0812b f2822a = new C0812b();

    /* renamed from: b */
    private C0811a f2823b = new C0811a();

    /* renamed from: a */
    public C0812b m3353a(String str) {
        for (String str2 : str.split("\n")) {
            String[] strArrM3352b = m3352b(str2);
            String str3 = strArrM3352b[0];
            String str4 = strArrM3352b[1];
            C1341p.m4659c("Raw Line : " + str2);
            C1341p.m4659c(str3 + " " + str4);
            if ("SUMMARY".equals(str3)) {
                this.f2823b.f2795i = str4;
            } else if ("DTSTART".equals(str3)) {
                this.f2823b.f2789c = str4;
            } else if ("DTEND".equals(str3)) {
                this.f2823b.f2788b = str4;
            } else if ("DUE".equals(str3)) {
                this.f2823b.f2790d = str4;
            } else if ("DESCRIPTION".equals(str3)) {
                this.f2823b.f2787a = str4;
            } else if ("LOCATION".equals(str3)) {
                this.f2823b.f2796j = str4;
            } else if ("COMPLETED".equals(str3)) {
                this.f2823b.f2792f = str4;
            } else if ("RRULE".equals(str3)) {
                this.f2823b.f2793g = str4;
            } else if ("STATUS".equals(str3)) {
                this.f2823b.f2794h = str4;
            } else if ("END".equals(str3) && !str4.startsWith("V")) {
                this.f2823b.f2788b = str4;
            }
        }
        this.f2822a.m3341a(this.f2823b);
        return this.f2822a;
    }

    /* renamed from: b */
    private String[] m3352b(String str) {
        String[] strArr = new String[2];
        String strSubstring = "";
        for (String str2 : str.split(":")[0].split(";")) {
            if (str2.startsWith("CHARSET")) {
                strSubstring = str2.substring(8, str2.length());
            }
        }
        strArr[0] = str.split(":")[0].split(";")[0];
        if (str.split(":").length < 2) {
            strArr[1] = "";
        } else {
            strArr[1] = m3354a(str.split(":")[1], strSubstring);
        }
        return strArr;
    }

    /* renamed from: a */
    public String m3354a(String str, String str2) {
        if (str.contains("=") && !TextUtils.isEmpty(str2)) {
            String strReplaceAll = str.replaceAll(";", "");
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
                            C1341p.m4659c(str4);
                            sb.append(str4.trim());
                            sb2.delete(0, sb2.length());
                            sb.append(str3.substring(2, str3.length()));
                        } catch (UnsupportedEncodingException e2) {
                            C1341p.m4651a("Cannot Encode", "VCardParser");
                            return strReplaceAll;
                        }
                    } else {
                        sb2.append(str3);
                    }
                    if (i2 == strArrSplit.length && sb2.length() > 0) {
                        try {
                            String str5 = new String(new BigInteger(sb2.toString(), 16).toByteArray(), str2);
                            C1341p.m4659c(str5);
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
