package com.sec.chaton.multimedia.vcalendar;

import com.sec.chaton.multimedia.vcalendar.VCalendarStruct;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class VCalParser {

    /* renamed from: a */
    private VCalendarStruct f2184a = new VCalendarStruct();

    /* renamed from: b */
    private VCalendarStruct.EventStruct f2185b = new VCalendarStruct.EventStruct();

    /* renamed from: b */
    private String[] m2559b(String str) {
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
            strArr[1] = m2561a(str.split(":")[1], strSubstring);
        }
        return strArr;
    }

    /* renamed from: a */
    public VCalendarStruct m2560a(String str) {
        for (String str2 : str.split("\n")) {
            String str3 = m2559b(str2)[0];
            String str4 = m2559b(str2)[1];
            ChatONLogWriter.m3509d("Raw Line : " + str2);
            ChatONLogWriter.m3509d(str3 + " " + str4);
            if (str3.equals("SUMMARY")) {
                this.f2185b.f2244i = str4;
            } else if (str3.equals("DTSTART")) {
                this.f2185b.f2238c = str4;
            } else if (str3.equals("DTEND")) {
                this.f2185b.f2237b = str4;
            } else if (str3.equals("DUE")) {
                this.f2185b.f2239d = str4;
            } else if (str3.equals("DESCRIPTION")) {
                this.f2185b.f2236a = str4;
            } else if (str3.equals("LOCATION")) {
                this.f2185b.f2245j = str4;
            } else if (str3.equals("COMPLETED")) {
                this.f2185b.f2241f = str4;
            } else if (str3.equals("RRULE")) {
                this.f2185b.f2242g = str4;
            } else if (str3.equals("STATUS")) {
                this.f2185b.f2243h = str4;
            } else if (str3.equals("END") && !str4.startsWith("V")) {
                this.f2185b.f2237b = str4;
            }
        }
        this.f2184a.m2601a(this.f2185b);
        return this.f2184a;
    }

    /* renamed from: a */
    public String m2561a(String str, String str2) {
        String strReplaceAll = str.replaceAll(";", "");
        if (!strReplaceAll.contains("=")) {
            return strReplaceAll;
        }
        String[] strArrSplit = strReplaceAll.split("=");
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= strReplaceAll.length()) {
                break;
            }
            if (strReplaceAll.charAt(i2) == '=') {
                i = i2;
                break;
            }
            i2++;
        }
        String str3 = "";
        int i3 = 0;
        String str4 = "";
        for (String str5 : strArrSplit) {
            i3++;
            if (i != 0) {
                str3 = str3 + str5;
                i = 0;
            } else {
                if (str5.length() < 2) {
                    if (str4.length() > 1) {
                        try {
                            str3 = str3 + new String(new BigInteger(str4, 16).toByteArray(), str2);
                            str4 = "";
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            return strReplaceAll;
                        }
                    }
                    str3 = str3 + str5;
                } else if (str5.length() > 2) {
                    try {
                        String str6 = new String(new BigInteger(str4 + str5.substring(0, 2), 16).toByteArray(), str2);
                        ChatONLogWriter.m3509d(str6);
                        str3 = (str3 + str6.trim()) + str5.substring(2, str5.length());
                        str4 = "";
                    } catch (UnsupportedEncodingException e2) {
                        ChatONLogWriter.m3499a("Cannot Encode", "VCardParser");
                        return strReplaceAll;
                    }
                } else {
                    str4 = str4 + str5;
                }
                if (i3 == strArrSplit.length && str4.length() > 0) {
                    try {
                        String str7 = new String(new BigInteger(str4, 16).toByteArray(), str2);
                        ChatONLogWriter.m3509d(str7);
                        str3 = str3 + str7.trim();
                    } catch (UnsupportedEncodingException e3) {
                        e3.printStackTrace();
                        return strReplaceAll;
                    }
                }
            }
        }
        return str3;
    }
}
