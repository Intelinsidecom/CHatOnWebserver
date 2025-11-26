package com.sec.chaton.multimedia.vcard;

import com.sec.chaton.util.C1341p;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/* compiled from: VCardParser.java */
/* renamed from: com.sec.chaton.multimedia.vcard.c */
/* loaded from: classes.dex */
public class C0826c {

    /* renamed from: b */
    boolean f2868b = true;

    /* renamed from: a */
    C0833j f2867a = new C0833j();

    /* renamed from: a */
    public C0833j m3399a(String str) {
        for (String str2 : str.split("\n")) {
            C1341p.m4659c("RAW LINE : " + str2);
            if (str2.startsWith("NOTE")) {
                this.f2867a.f2898d = m3404e(str2);
            } else if (str2.startsWith("N") || str2.startsWith("FN")) {
                if (!str2.startsWith("NICK") && !str2.startsWith("NOTE")) {
                    this.f2867a.f2895a = m3401b(str2);
                }
            } else if (str2.startsWith("TEL")) {
                String[] strArrM3402c = m3402c(str2);
                this.f2867a.m3406a(Integer.parseInt(strArrM3402c[2]), strArrM3402c[0], strArrM3402c[1], this.f2868b);
                this.f2868b = false;
            } else if (str2.startsWith("EMAIL")) {
                String[] strArrM3403d = m3403d(str2);
                this.f2867a.m3407b(Integer.parseInt(strArrM3403d[2]), strArrM3403d[0], strArrM3403d[1], this.f2868b);
            }
        }
        return this.f2867a;
    }

    /* renamed from: b */
    public String m3401b(String str) {
        String str2 = str.split(":")[1];
        String strSubstring = "";
        for (String str3 : str.split(":")[0].split(";")) {
            if (str3.startsWith("CHARSET")) {
                strSubstring = str3.substring(8, str3.length());
            }
        }
        return m3400a(str2, strSubstring);
    }

    /* renamed from: c */
    public String[] m3402c(String str) {
        int i = 0;
        String[] strArr = new String[3];
        strArr[0] = str.split(":")[1];
        for (String str2 : str.split(":")[0].split(";")) {
            if ("HOME".equals(str2)) {
                strArr[1] = str2;
                i = 1;
            } else if ("CELL".equals(str2)) {
                strArr[1] = str2;
                i = 2;
            } else if ("WORK".equals(str2)) {
                strArr[1] = str2;
                i = 3;
            } else if ("WORK-FAX".equals(str2)) {
                i = 4;
                strArr[1] = str2;
            } else if ("HOME-FAX".equals(str2)) {
                i = 5;
                strArr[1] = str2;
            } else if ("PAGER".equals(str2)) {
                i = 6;
                strArr[1] = str2;
            } else if ("OTHER".equals(str2)) {
                i = 7;
                strArr[1] = str2;
            } else if ("CALLBACK".equals(str2)) {
                i = 8;
                strArr[1] = str2;
            } else if ("CAR".equals(str2)) {
                i = 9;
                strArr[1] = str2;
            } else if ("COMPANY_MAIN".equals(str2)) {
                i = 10;
                strArr[1] = str2;
            } else if ("ISDN".equals(str2)) {
                i = 11;
                strArr[1] = str2;
            } else if ("MAIN".equals(str2)) {
                i = 12;
                strArr[1] = str2;
            } else if ("OTHER_FAX".equals(str2)) {
                i = 13;
                strArr[1] = str2;
            } else if ("RADIO".equals(str2)) {
                i = 14;
                strArr[1] = str2;
            } else if ("TELEX".equals(str2)) {
                i = 15;
                strArr[1] = str2;
            } else if ("TTY_TDD".equals(str2)) {
                i = 16;
                strArr[1] = str2;
            } else if ("WORK_MOBILE".equals(str2)) {
                i = 17;
                strArr[1] = str2;
            } else if ("WORK_PAGER".equals(str2)) {
                i = 18;
                strArr[1] = str2;
            } else if ("ASSISTANT".equals(str2)) {
                i = 19;
                strArr[1] = str2;
            } else if ("MMS".equals(str2)) {
                i = 20;
                strArr[1] = str2;
            }
            strArr[2] = String.valueOf(i);
        }
        return strArr;
    }

    /* renamed from: d */
    public String[] m3403d(String str) {
        String strSubstring;
        String[] strArr = new String[3];
        String str2 = str.split(":")[1];
        String[] strArrSplit = str.split(":")[0].split(";");
        String str3 = "";
        String str4 = "OTHER";
        int length = strArrSplit.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str5 = strArrSplit[i];
            if (str5.startsWith("CHARSET")) {
                strSubstring = str5.substring(8, str5.length());
            } else if ("HOME".equals(str5)) {
                i2 = 1;
                str4 = str5;
                strSubstring = str3;
            } else if ("WORK".equals(str5)) {
                i2 = 2;
                str4 = str5;
                strSubstring = str3;
            } else if ("OTHER".equals(str5)) {
                i2 = 3;
                str4 = str5;
                strSubstring = str3;
            } else if ("MOBILE".equals(str5)) {
                i2 = 4;
                str4 = str5;
                strSubstring = str3;
            } else if (str5.startsWith("X-")) {
                str4 = null;
                strSubstring = str3;
                i2 = 3;
            } else {
                strSubstring = str3;
            }
            i++;
            str3 = strSubstring;
        }
        strArr[0] = m3400a(str2, str3);
        strArr[1] = str4;
        strArr[2] = String.valueOf(i2);
        return strArr;
    }

    /* renamed from: e */
    public String m3404e(String str) {
        String str2 = "";
        String str3 = str.split(":")[1];
        String[] strArrSplit = str.split(":")[0].split(";");
        int length = strArrSplit.length;
        int i = 0;
        while (i < length) {
            String str4 = strArrSplit[i];
            if (!str4.startsWith("CHARSET")) {
                str4 = str2;
            }
            i++;
            str2 = str4;
        }
        return m3400a(str3, str2);
    }

    /* renamed from: a */
    public String m3400a(String str, String str2) {
        String strReplaceAll = str.replaceAll(";", "");
        if (strReplaceAll.contains("=")) {
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
            int length = strArrSplit.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                String str3 = strArrSplit[i2];
                int i4 = i3 + 1;
                if (i != 0) {
                    sb.append(str3);
                    i = 0;
                } else {
                    if (str3.length() < 2) {
                        if (sb2.length() > 1) {
                            try {
                                sb.append(new String(new BigInteger(sb2.toString(), 16).toByteArray(), str2));
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                            sb2.delete(0, sb2.length());
                        }
                        sb.append(str3);
                    } else if (str3.length() > 2) {
                        sb2.append(str3.substring(0, 2));
                        try {
                            sb.append(new String(new BigInteger(sb2.toString(), 16).toByteArray(), str2).trim());
                        } catch (UnsupportedEncodingException e2) {
                            C1341p.m4651a("Cannot Encode", "VCardParser");
                        }
                        sb2.delete(0, sb2.length());
                        sb.append(str3.substring(2, str3.length()));
                    } else {
                        sb2.append(str3);
                    }
                    if (i4 == strArrSplit.length && sb2.length() > 0) {
                        try {
                            sb.append(new String(new BigInteger(sb2.toString(), 16).toByteArray(), str2).trim());
                        } catch (UnsupportedEncodingException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                i2++;
                i3 = i4;
            }
            C1341p.m4659c("Decode : " + ((Object) sb));
            return sb.toString();
        }
        C1341p.m4659c(strReplaceAll);
        return strReplaceAll;
    }
}
