package com.sec.chaton.multimedia.vcalendar;

import android.text.TextUtils;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4877co;
import com.sec.chaton.util.C4904y;
import java.net.URLEncoder;
import java.util.Date;

/* compiled from: VCalComposer.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.a */
/* loaded from: classes.dex */
public class C2885a {

    /* renamed from: a */
    private static String f10649a = "\r\n";

    /* renamed from: a */
    public static C2885a m12044a() {
        return new C2885a();
    }

    private C2885a() {
    }

    /* renamed from: a */
    public String m12047a(C2894j c2894j, int i) {
        StringBuilder sb = new StringBuilder();
        if (i != 1 && i != 2) {
            if (C4904y.f17875e) {
                C4904y.m18634a("version not match 1.0 or 2.0.", getClass().getSimpleName());
            }
            return null;
        }
        sb.append("BEGIN:VCALENDAR").append(f10649a);
        if (i == 1) {
            sb.append("VERSION:1.0").append(f10649a);
        } else {
            sb.append("VERSION:2.0").append(f10649a);
        }
        sb.append("PRODID:vCal ID default").append(f10649a);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < c2894j.f10669a.size()) {
                sb.append(m12045a(c2894j.f10669a.get(i3)));
                i2 = i3 + 1;
            } else {
                sb.append("END:VCALENDAR").append(f10649a).append(f10649a);
                return sb.toString();
            }
        }
    }

    /* renamed from: a */
    private String m12045a(C2895k c2895k) {
        StringBuilder sb = new StringBuilder();
        sb.append("BEGIN:VEVENT").append(f10649a);
        if (!TextUtils.isEmpty(c2895k.f10680k)) {
            sb.append("UID:").append(c2895k.f10680k).append(f10649a);
        }
        if (!TextUtils.isEmpty(c2895k.f10670a)) {
            sb.append("DESCRIPTION;").append(m12046a(c2895k.f10670a)).append(f10649a);
        }
        if (!TextUtils.isEmpty(c2895k.f10672c)) {
            sb.append("DTSTART:").append(C4877co.m18513a(new Date(Long.parseLong(c2895k.f10672c)))).append(f10649a);
        }
        if (!TextUtils.isEmpty(c2895k.f10671b)) {
            sb.append("DTEND:").append(C4877co.m18513a(new Date(Long.parseLong(c2895k.f10671b)))).append(f10649a);
        }
        if (!TextUtils.isEmpty(c2895k.f10673d)) {
            sb.append("DUE:").append(c2895k.f10673d).append(f10649a);
        }
        if (!TextUtils.isEmpty(c2895k.f10679j)) {
            sb.append("LOCATION;").append(m12046a(c2895k.f10679j)).append(f10649a);
        }
        if (!TextUtils.isEmpty(c2895k.f10675f)) {
            sb.append("COMPLETED:").append(C4877co.m18513a(new Date(Long.parseLong(c2895k.f10675f)))).append(f10649a);
        }
        if (!TextUtils.isEmpty(c2895k.f10676g)) {
            sb.append("RRULE:").append(c2895k.f10676g).append(f10649a);
        }
        if (!TextUtils.isEmpty(c2895k.f10678i)) {
            sb.append("SUMMARY;").append(m12046a(c2895k.f10678i)).append(f10649a);
        }
        if (!TextUtils.isEmpty(c2895k.f10682m)) {
            sb.append("ALLDAY:").append(c2895k.f10682m).append(f10649a);
        }
        if (!TextUtils.isEmpty(c2895k.f10674e)) {
            sb.append("ALARM:").append(c2895k.f10674e).append(f10649a);
        }
        if (!TextUtils.isEmpty(c2895k.f10681l)) {
            sb.append("TZ:").append(c2895k.f10681l).append(f10649a);
        }
        if (!TextUtils.isEmpty(c2895k.f10677h)) {
            String str = "TENTATIVE";
            if ("TENTATIVE".equals(c2895k.f10677h)) {
                str = "TENTATIVE";
            } else if ("CONFIRMED".equals(c2895k.f10677h)) {
                str = "CONFIRMED";
            } else if ("CANCELLED".equals(c2895k.f10677h)) {
                str = "CANCELLED";
            } else if (Spam.ACTIVITY_CANCEL.equals(c2895k.f10677h) || Spam.ACTIVITY_REPORT.equals(c2895k.f10677h) || Spam.ACTIVITY_CHECK.equals(c2895k.f10677h)) {
                switch (Integer.parseInt(c2895k.f10677h)) {
                    case 0:
                        str = "TENTATIVE";
                        break;
                    case 1:
                        str = "CONFIRMED";
                        break;
                    case 2:
                        str = "CANCELLED";
                        break;
                }
            }
            sb.append("STATUS:").append(str).append(f10649a);
        }
        sb.append("END:VEVENT").append(f10649a);
        return sb.toString();
    }

    /* renamed from: a */
    private String m12046a(String str) {
        int length = 0;
        try {
            String[] strArrSplit = str.split("[ \t\n=]");
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArrSplit) {
                if (str2.length() > 0) {
                    int iIndexOf = str.indexOf(str2, length);
                    String str3 = "";
                    if (iIndexOf != length) {
                        while (length < iIndexOf) {
                            if (str.charAt(length) == " ".charAt(0)) {
                                if (length + 1 < iIndexOf && str.charAt(length + 1) == "\n".charAt(0)) {
                                    str3 = "=20";
                                } else {
                                    str3 = " ";
                                }
                            } else if (str.charAt(length) == "\t".charAt(0)) {
                                if (length + 1 < iIndexOf && str.charAt(length + 1) == "\n".charAt(0)) {
                                    str3 = "=09";
                                } else {
                                    str3 = "\t";
                                }
                            } else if (str.charAt(length) == "=".charAt(0)) {
                                str3 = "=3D";
                            } else if (str.charAt(length) == "\n".charAt(0)) {
                                str3 = "=0D=0A";
                            }
                            sb.append(str3);
                            length++;
                        }
                    }
                    sb.append(URLEncoder.encode(str2, "UTF-8").replaceAll("%", "="));
                    length = str2.length() + iIndexOf;
                }
            }
            return "CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:" + sb.toString();
        } catch (Exception e) {
            C4904y.m18634a("Cannot encode", "VCardComposer");
            return "";
        }
    }
}
