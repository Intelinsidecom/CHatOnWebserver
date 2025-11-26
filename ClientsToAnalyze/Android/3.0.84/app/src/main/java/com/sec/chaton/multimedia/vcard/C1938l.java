package com.sec.chaton.multimedia.vcard;

import com.sec.chaton.util.C3250y;
import com.sec.spp.push.Config;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/* compiled from: VCardParser.java */
/* renamed from: com.sec.chaton.multimedia.vcard.l */
/* loaded from: classes.dex */
public class C1938l {

    /* renamed from: a */
    public static final String f7446a = C1938l.class.getSimpleName();

    /* renamed from: c */
    boolean f7448c = true;

    /* renamed from: b */
    C1928b f7447b = new C1928b();

    /* renamed from: a */
    public C1928b m7883a(String str) {
        String[] strArrM7887d;
        for (String str2 : str.split("\n")) {
            C3250y.m11454d("RAW LINE : " + str2);
            if (str2.startsWith("NOTE")) {
                this.f7447b.f7394d = m7888e(str2);
            } else if (str2.startsWith("N") || str2.startsWith("FN")) {
                if (!str2.startsWith("NICK") && !str2.startsWith("NOTE")) {
                    this.f7447b.f7391a = m7885b(str2);
                }
            } else if (str2.startsWith("TEL")) {
                String[] strArrM7886c = m7886c(str2);
                if (strArrM7886c != null) {
                    this.f7447b.m7864a(Integer.parseInt(strArrM7886c[2]), strArrM7886c[0], strArrM7886c[1], this.f7448c);
                    this.f7448c = false;
                }
            } else if (str2.startsWith("EMAIL") && (strArrM7887d = m7887d(str2)) != null) {
                this.f7447b.m7865b(Integer.parseInt(strArrM7887d[2]), strArrM7887d[0], strArrM7887d[1], this.f7448c);
            }
        }
        return this.f7447b;
    }

    /* renamed from: b */
    public String m7885b(String str) {
        try {
            String str2 = str.split(":")[1];
            String strSubstring = "";
            for (String str3 : str.split(":")[0].split(Config.KEYVALUE_SPLIT)) {
                if (str3.startsWith("CHARSET")) {
                    strSubstring = str3.substring(8, str3.length());
                }
            }
            return m7884a(str2, strSubstring);
        } catch (ArrayIndexOutOfBoundsException e) {
            C3250y.m11443a(e, f7446a);
            return null;
        }
    }

    /* renamed from: c */
    public String[] m7886c(String str) {
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
            C3250y.m11443a(e, f7446a);
            return null;
        }
    }

    /* renamed from: d */
    public String[] m7887d(String str) {
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
        strArr[0] = m7884a(str2, str3);
        strArr[1] = str4;
        strArr[2] = String.valueOf(i2);
        return strArr;
    }

    /* renamed from: e */
    public String m7888e(String str) {
        try {
            String str2 = str.split(":")[1];
            String strSubstring = "";
            for (String str3 : str.split(":")[0].split(Config.KEYVALUE_SPLIT)) {
                if (str3.startsWith("CHARSET")) {
                    strSubstring = str3.substring(8, str3.length());
                }
            }
            return m7884a(str2, strSubstring);
        } catch (ArrayIndexOutOfBoundsException e) {
            C3250y.m11443a(e, f7446a);
            return null;
        }
    }

    /* renamed from: a */
    public String m7884a(String str, String str2) {
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
                                C3250y.m11442a("NumberFormatException: Invalid BigInteger", "VCardParser");
                            }
                            sb2.delete(0, sb2.length());
                        }
                        sb.append(str3);
                    } else if (str3.length() > 2) {
                        sb2.append(str3.substring(0, 2));
                        try {
                            sb.append(new String(new BigInteger(sb2.toString(), 16).toByteArray(), str2).trim());
                        } catch (UnsupportedEncodingException e3) {
                            C3250y.m11442a("Cannot Decode", "VCardParser");
                        } catch (NumberFormatException e4) {
                            C3250y.m11442a("NumberFormatException: Invalid BigInteger", "VCardParser");
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
                            C3250y.m11442a("NumberFormatException: Invalid BigInteger", "VCardParser");
                        }
                    }
                }
                i2++;
                i3 = i4;
            }
            C3250y.m11454d("Decode : " + ((Object) sb));
            return sb.toString();
        }
        C3250y.m11454d(strReplaceAll);
        return strReplaceAll;
    }
}
