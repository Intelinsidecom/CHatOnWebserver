package com.sec.chaton.multimedia.vcard;

import com.sec.chaton.util.ChatONLogWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class VCardParser {

    /* renamed from: b */
    boolean f2345b = true;

    /* renamed from: a */
    ContactStruct f2344a = new ContactStruct();

    /* renamed from: a */
    public ContactStruct m2643a(String str) {
        for (String str2 : str.split("\n")) {
            ChatONLogWriter.m3509d("RAW LINE : " + str2);
            if (str2.startsWith("NOTE")) {
                this.f2344a.f2284d = m2648e(str2);
            } else if (str2.startsWith("N") || str2.startsWith("FN")) {
                if (!str2.startsWith("NICK") && !str2.startsWith("NOTE")) {
                    this.f2344a.f2281a = m2645b(str2);
                }
            } else if (str2.startsWith("TEL")) {
                String[] strArrM2646c = m2646c(str2);
                this.f2344a.m2616a(Integer.parseInt(strArrM2646c[2]), strArrM2646c[0], strArrM2646c[1], this.f2345b);
                this.f2345b = false;
            } else if (str2.startsWith("EMAIL")) {
                String[] strArrM2647d = m2647d(str2);
                this.f2344a.m2617b(Integer.parseInt(strArrM2647d[2]), strArrM2647d[0], strArrM2647d[1], this.f2345b);
            }
        }
        return this.f2344a;
    }

    /* renamed from: a */
    public String m2644a(String str, String str2) {
        int i;
        String str3;
        String str4;
        String strReplaceAll = str.replaceAll(";", "");
        if (!strReplaceAll.contains("=")) {
            ChatONLogWriter.m3509d(strReplaceAll);
            return strReplaceAll;
        }
        String[] strArrSplit = strReplaceAll.split("=");
        int i2 = 0;
        while (true) {
            if (i2 >= strReplaceAll.length()) {
                i = 0;
                break;
            }
            if (strReplaceAll.charAt(i2) == '=') {
                i = i2;
                break;
            }
            i2++;
        }
        String str5 = "";
        int i3 = 0;
        String str6 = "";
        int i4 = i;
        for (String str7 : strArrSplit) {
            i3++;
            if (i4 != 0) {
                str5 = str5 + str7;
                i4 = 0;
            } else {
                if (str7.length() < 2) {
                    if (str6.length() > 1) {
                        try {
                            str4 = str5 + new String(new BigInteger(str6, 16).toByteArray(), str2);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            str4 = str5;
                        }
                        str5 = str4;
                        str6 = "";
                    }
                    str5 = str5 + str7;
                } else if (str7.length() > 2) {
                    try {
                        str3 = str5 + new String(new BigInteger(str6 + str7.substring(0, 2), 16).toByteArray(), str2).trim();
                    } catch (UnsupportedEncodingException e2) {
                        ChatONLogWriter.m3499a("Cannot Encode", "VCardParser");
                        str3 = str5;
                    }
                    str5 = str3 + str7.substring(2, str7.length());
                    str6 = "";
                } else {
                    str6 = str6 + str7;
                }
                if (i3 == strArrSplit.length && str6.length() > 0) {
                    try {
                        str5 = str5 + new String(new BigInteger(str6, 16).toByteArray(), str2).trim();
                    } catch (UnsupportedEncodingException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
        ChatONLogWriter.m3509d("Decode : " + str5);
        return str5;
    }

    /* renamed from: b */
    public String m2645b(String str) {
        String str2 = str.split(":")[1];
        String strSubstring = "";
        for (String str3 : str.split(":")[0].split(";")) {
            if (str3.startsWith("CHARSET")) {
                strSubstring = str3.substring(8, str3.length());
            }
        }
        return m2644a(str2, strSubstring);
    }

    /* renamed from: c */
    public String[] m2646c(String str) {
        String[] strArr = new String[3];
        strArr[0] = str.split(":")[1];
        int i = 0;
        for (String str2 : str.split(":")[0].split(";")) {
            if (str2.equals("HOME")) {
                strArr[1] = str2;
                i = 1;
            } else if (str2.equals("CELL")) {
                strArr[1] = str2;
                i = 2;
            } else if (str2.equals("WORK")) {
                strArr[1] = str2;
                i = 3;
            } else if (str2.equals("WORK-FAX")) {
                i = 4;
                strArr[1] = str2;
            } else if (str2.equals("HOME-FAX")) {
                i = 5;
                strArr[1] = str2;
            } else if (str2.equals("PAGER")) {
                i = 6;
                strArr[1] = str2;
            } else if (str2.equals("OTHER")) {
                i = 7;
                strArr[1] = str2;
            } else if (str2.equals("CALLBACK")) {
                i = 8;
                strArr[1] = str2;
            } else if (str2.equals("CAR")) {
                i = 9;
                strArr[1] = str2;
            } else if (str2.equals("COMPANY_MAIN")) {
                i = 10;
                strArr[1] = str2;
            } else if (str2.equals("ISDN")) {
                i = 11;
                strArr[1] = str2;
            } else if (str2.equals("MAIN")) {
                i = 12;
                strArr[1] = str2;
            } else if (str2.equals("OTHER_FAX")) {
                i = 13;
                strArr[1] = str2;
            } else if (str2.equals("RADIO")) {
                i = 14;
                strArr[1] = str2;
            } else if (str2.equals("TELEX")) {
                i = 15;
                strArr[1] = str2;
            } else if (str2.equals("TTY_TDD")) {
                i = 16;
                strArr[1] = str2;
            } else if (str2.equals("WORK_MOBILE")) {
                i = 17;
                strArr[1] = str2;
            } else if (str2.equals("WORK_PAGER")) {
                i = 18;
                strArr[1] = str2;
            } else if (str2.equals("ASSISTANT")) {
                i = 19;
                strArr[1] = str2;
            } else if (str2.equals("MMS")) {
                i = 20;
                strArr[1] = str2;
            }
            strArr[2] = String.valueOf(i);
        }
        return strArr;
    }

    /* renamed from: d */
    public String[] m2647d(String str) {
        String[] strArr = new String[3];
        String str2 = str.split(":")[1];
        String str3 = "OTHER";
        String strSubstring = "";
        int i = 0;
        for (String str4 : str.split(":")[0].split(";")) {
            if (str4.startsWith("CHARSET")) {
                strSubstring = str4.substring(8, str4.length());
            } else if (str4.equals("HOME")) {
                i = 1;
                str3 = str4;
            } else if (str4.equals("WORK")) {
                i = 2;
                str3 = str4;
            } else if (str4.equals("OTHER")) {
                i = 3;
                str3 = str4;
            } else if (str4.equals("MOBILE")) {
                i = 4;
                str3 = str4;
            }
        }
        strArr[0] = m2644a(str2, strSubstring);
        strArr[1] = str3;
        strArr[2] = String.valueOf(i);
        return strArr;
    }

    /* renamed from: e */
    public String m2648e(String str) {
        String str2 = str.split(":")[1];
        String str3 = "";
        for (String str4 : str.split(":")[0].split(";")) {
            if (str4.startsWith("CHARSET")) {
                str3 = str4;
            }
        }
        return m2644a(str2, str3);
    }
}
