package com.sec.chaton.multimedia.vcalendar;

import android.text.TextUtils;
import com.sec.chaton.util.C3227co;
import com.sec.chaton.util.C3250y;
import java.net.URLEncoder;
import java.util.Date;
import weibo4android.org.json.HTTP;

/* compiled from: VCalComposer.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.a */
/* loaded from: classes.dex */
public class C1916a {

    /* renamed from: a */
    private static String f7328a = HTTP.CRLF;

    /* renamed from: a */
    public String m7817a(C1925j c1925j, int i) {
        StringBuilder sb = new StringBuilder();
        if (i != 1 && i != 2) {
            if (C3250y.f11737e) {
                C3250y.m11442a("version not match 1.0 or 2.0.", getClass().getSimpleName());
            }
            return null;
        }
        sb.append("BEGIN:VCALENDAR").append(f7328a);
        if (i == 1) {
            sb.append("VERSION:1.0").append(f7328a);
        } else {
            sb.append("VERSION:2.0").append(f7328a);
        }
        sb.append("PRODID:vCal ID default").append(f7328a);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < c1925j.f7348a.size()) {
                sb.append(m7815a(c1925j.f7348a.get(i3)));
                i2 = i3 + 1;
            } else {
                sb.append("END:VCALENDAR").append(f7328a).append(f7328a);
                return sb.toString();
            }
        }
    }

    /* renamed from: a */
    private String m7815a(C1926k c1926k) {
        StringBuilder sb = new StringBuilder();
        sb.append("BEGIN:VEVENT").append(f7328a);
        if (!TextUtils.isEmpty(c1926k.f7359k)) {
            sb.append("UID:").append(c1926k.f7359k).append(f7328a);
        }
        if (!TextUtils.isEmpty(c1926k.f7349a)) {
            sb.append("DESCRIPTION;").append(m7816a(c1926k.f7349a)).append(f7328a);
        }
        if (!TextUtils.isEmpty(c1926k.f7351c)) {
            sb.append("DTSTART:").append(C3227co.m11340a(new Date(Long.parseLong(c1926k.f7351c)))).append(f7328a);
        }
        if (!TextUtils.isEmpty(c1926k.f7350b)) {
            sb.append("DTEND:").append(C3227co.m11340a(new Date(Long.parseLong(c1926k.f7350b)))).append(f7328a);
        }
        if (!TextUtils.isEmpty(c1926k.f7352d)) {
            sb.append("DUE:").append(c1926k.f7352d).append(f7328a);
        }
        if (!TextUtils.isEmpty(c1926k.f7358j)) {
            sb.append("LOCATION;").append(m7816a(c1926k.f7358j)).append(f7328a);
        }
        if (!TextUtils.isEmpty(c1926k.f7354f)) {
            sb.append("COMPLETED:").append(C3227co.m11340a(new Date(Long.parseLong(c1926k.f7354f)))).append(f7328a);
        }
        if (!TextUtils.isEmpty(c1926k.f7355g)) {
            sb.append("RRULE:").append(c1926k.f7355g).append(f7328a);
        }
        if (!TextUtils.isEmpty(c1926k.f7357i)) {
            sb.append("SUMMARY;").append(m7816a(c1926k.f7357i)).append(f7328a);
        }
        if (!TextUtils.isEmpty(c1926k.f7361m)) {
            sb.append("ALLDAY:").append(c1926k.f7361m).append(f7328a);
        }
        if (!TextUtils.isEmpty(c1926k.f7353e)) {
            sb.append("ALARM:").append(c1926k.f7353e).append(f7328a);
        }
        if (!TextUtils.isEmpty(c1926k.f7360l)) {
            sb.append("TZ:").append(c1926k.f7360l).append(f7328a);
        }
        if (!TextUtils.isEmpty(c1926k.f7356h)) {
            String str = "TENTATIVE";
            if ("TENTATIVE".equals(c1926k.f7356h)) {
                str = "TENTATIVE";
            } else if ("CONFIRMED".equals(c1926k.f7356h)) {
                str = "CONFIRMED";
            } else if ("CANCELLED".equals(c1926k.f7356h)) {
                str = "CANCELLED";
            } else if ("0".equals(c1926k.f7356h) || "1".equals(c1926k.f7356h) || "2".equals(c1926k.f7356h)) {
                switch (Integer.parseInt(c1926k.f7356h)) {
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
            sb.append("STATUS:").append(str).append(f7328a);
        }
        sb.append("END:VEVENT").append(f7328a);
        return sb.toString();
    }

    /* renamed from: a */
    private String m7816a(String str) {
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
            C3250y.m11442a("Cannot encode", "VCardComposer");
            return "";
        }
    }
}
