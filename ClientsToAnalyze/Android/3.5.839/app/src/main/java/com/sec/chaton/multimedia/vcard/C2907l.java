package com.sec.chaton.multimedia.vcard;

import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/* compiled from: VCardParser.java */
/* renamed from: com.sec.chaton.multimedia.vcard.l */
/* loaded from: classes.dex */
public class C2907l {

    /* renamed from: a */
    public static final String f10767a = C2907l.class.getSimpleName();

    /* renamed from: c */
    boolean f10769c = true;

    /* renamed from: b */
    C2897b f10768b = new C2897b();

    /* renamed from: a */
    public C2897b m12111a(String str) {
        String[] strArrM12115d;
        for (String str2 : str.split("\n")) {
            C4904y.m18644d("RAW LINE : " + str2);
            if (str2.startsWith("NOTE")) {
                this.f10768b.f10715d = m12116e(str2);
            } else if (str2.startsWith("N") || str2.startsWith("FN")) {
                if (!str2.startsWith("NICK") && !str2.startsWith("NOTE")) {
                    this.f10768b.f10712a = m12113b(str2);
                }
            } else if (str2.startsWith("TEL")) {
                String[] strArrM12114c = m12114c(str2);
                if (strArrM12114c != null) {
                    this.f10768b.m12091a(Integer.parseInt(strArrM12114c[2]), strArrM12114c[0], strArrM12114c[1], this.f10769c);
                    this.f10769c = false;
                }
            } else if (str2.startsWith("EMAIL") && (strArrM12115d = m12115d(str2)) != null) {
                this.f10768b.m12092b(Integer.parseInt(strArrM12115d[2]), strArrM12115d[0], strArrM12115d[1], this.f10769c);
            }
        }
        return this.f10768b;
    }

    /* renamed from: b */
    public String m12113b(String str) {
        try {
            String str2 = str.split(":")[1];
            String strSubstring = "";
            for (String str3 : str.split(":")[0].split(Config.KEYVALUE_SPLIT)) {
                if (str3.startsWith("CHARSET")) {
                    strSubstring = str3.substring(8, str3.length());
                }
            }
            return m12112a(str2, strSubstring);
        } catch (ArrayIndexOutOfBoundsException e) {
            C4904y.m18635a(e, f10767a);
            return null;
        }
    }

    /* renamed from: c */
    public String[] m12114c(String str) {
        int i = 0;
        String[] strArr = new String[3];
        try {
            strArr[0] = str.split(":")[1];
            for (String str2 : str.split(":")[0].split(Config.KEYVALUE_SPLIT)) {
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
        } catch (ArrayIndexOutOfBoundsException e) {
            C4904y.m18635a(e, f10767a);
            return null;
        }
    }

    /* renamed from: d */
    public String[] m12115d(String str) {
        String strSubstring;
        String[] strArr = new String[3];
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str2 = strArrSplit[1];
        String[] strArrSplit2 = str.split(":")[0].split(Config.KEYVALUE_SPLIT);
        String str3 = "";
        int length = strArrSplit2.length;
        int i = 0;
        int i2 = 0;
        String str4 = "OTHER";
        while (i < length) {
            String str5 = strArrSplit2[i];
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
                i2 = 3;
                str4 = null;
                strSubstring = str3;
            } else {
                strSubstring = str3;
            }
            i++;
            str3 = strSubstring;
        }
        strArr[0] = m12112a(str2, str3);
        strArr[1] = str4;
        strArr[2] = String.valueOf(i2);
        return strArr;
    }

    /* renamed from: e */
    public String m12116e(String str) {
        try {
            String str2 = str.split(":")[1];
            String strSubstring = "";
            for (String str3 : str.split(":")[0].split(Config.KEYVALUE_SPLIT)) {
                if (str3.startsWith("CHARSET")) {
                    strSubstring = str3.substring(8, str3.length());
                }
            }
            return m12112a(str2, strSubstring);
        } catch (ArrayIndexOutOfBoundsException e) {
            C4904y.m18635a(e, f10767a);
            return null;
        }
    }

    /* renamed from: a */
    public String m12112a(String str, String str2) {
        String strReplaceAll = str.replaceAll(Config.KEYVALUE_SPLIT, "");
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
                            } catch (NumberFormatException e2) {
                                C4904y.m18634a("NumberFormatException: Invalid BigInteger", "VCardParser");
                            }
                            sb2.delete(0, sb2.length());
                        }
                        sb.append(str3);
                    } else if (str3.length() > 2) {
                        sb2.append(str3.substring(0, 2));
                        try {
                            sb.append(new String(new BigInteger(sb2.toString(), 16).toByteArray(), str2).trim());
                        } catch (UnsupportedEncodingException e3) {
                            C4904y.m18634a("Cannot Decode", "VCardParser");
                        } catch (NumberFormatException e4) {
                            C4904y.m18634a("NumberFormatException: Invalid BigInteger", "VCardParser");
                        }
                        sb2.delete(0, sb2.length());
                        sb.append(str3.substring(2, str3.length()));
                    } else {
                        sb2.append(str3);
                    }
                    if (i4 == strArrSplit.length && sb2.length() > 0) {
                        try {
                            sb.append(new String(new BigInteger(sb2.toString(), 16).toByteArray(), str2).trim());
                        } catch (UnsupportedEncodingException e5) {
                            e5.printStackTrace();
                        } catch (NumberFormatException e6) {
                            C4904y.m18634a("NumberFormatException: Invalid BigInteger", "VCardParser");
                        }
                    }
                }
                i2++;
                i3 = i4;
            }
            C4904y.m18644d("Decode : " + ((Object) sb));
            return sb.toString();
        }
        C4904y.m18644d(strReplaceAll);
        return strReplaceAll;
    }
}
