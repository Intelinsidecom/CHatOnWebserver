package com.sec.chaton.multimedia.vcalendar;

import android.text.TextUtils;
import com.sec.chaton.util.C1302ay;
import com.sec.chaton.util.C1341p;
import java.net.URLEncoder;
import java.util.Date;

/* compiled from: VCalComposer.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.i */
/* loaded from: classes.dex */
public class C0819i {

    /* renamed from: a */
    private static String f2816a = "\r\n";

    /* renamed from: c */
    private static final String f2817c = new Character('\r').toString() + new Character('\n').toString();

    /* renamed from: b */
    private String f2818b = null;

    /* renamed from: a */
    public String m3350a(C0812b c0812b, int i) throws C0818h {
        StringBuilder sb = new StringBuilder();
        if (i != 1 && i != 2) {
            throw new C0818h("version not match 1.0 or 2.0.");
        }
        if (i == 1) {
            this.f2818b = "vcalendar1.0";
        } else {
            this.f2818b = "vcalendar2.0";
        }
        sb.append("BEGIN:VCALENDAR").append(f2816a);
        if (i == 1) {
            sb.append("VERSION:1.0").append(f2816a);
        } else {
            sb.append("VERSION:2.0").append(f2816a);
        }
        sb.append("PRODID:vCal ID default").append(f2816a);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < c0812b.f2800a.size()) {
                sb.append(m3348a((C0811a) c0812b.f2800a.get(i3)));
                i2 = i3 + 1;
            } else {
                sb.append("END:VCALENDAR").append(f2816a).append(f2816a);
                return sb.toString();
            }
        }
    }

    /* renamed from: a */
    private String m3348a(C0811a c0811a) {
        StringBuilder sb = new StringBuilder();
        sb.append("BEGIN:VEVENT").append(f2816a);
        if (!TextUtils.isEmpty(c0811a.f2797k)) {
            sb.append("UID:").append(c0811a.f2797k).append(f2816a);
        }
        if (!TextUtils.isEmpty(c0811a.f2787a)) {
            sb.append("DESCRIPTION;").append(m3349a(c0811a.f2787a)).append(f2816a);
        }
        if (!TextUtils.isEmpty(c0811a.f2789c)) {
            sb.append("DTSTART:").append(C1302ay.m4548a(new Date(Long.parseLong(c0811a.f2789c)))).append(f2816a);
        }
        if (!TextUtils.isEmpty(c0811a.f2788b)) {
            sb.append("DTEND:").append(C1302ay.m4548a(new Date(Long.parseLong(c0811a.f2788b)))).append(f2816a);
        }
        if (!TextUtils.isEmpty(c0811a.f2790d)) {
            sb.append("DUE:").append(c0811a.f2790d).append(f2816a);
        }
        if (!TextUtils.isEmpty(c0811a.f2796j)) {
            sb.append("LOCATION;").append(m3349a(c0811a.f2796j)).append(f2816a);
        }
        if (!TextUtils.isEmpty(c0811a.f2792f)) {
            sb.append("COMPLETED:").append(C1302ay.m4548a(new Date(Long.parseLong(c0811a.f2792f)))).append(f2816a);
        }
        if (!TextUtils.isEmpty(c0811a.f2793g)) {
            sb.append("RRULE:").append(c0811a.f2793g).append(f2816a);
        }
        if (!TextUtils.isEmpty(c0811a.f2795i)) {
            sb.append("SUMMARY;").append(m3349a(c0811a.f2795i)).append(f2816a);
        }
        if (!TextUtils.isEmpty(c0811a.f2799m)) {
            sb.append("ALLDAY:").append(c0811a.f2799m).append(f2816a);
        }
        if (!TextUtils.isEmpty(c0811a.f2791e)) {
            sb.append("ALARM:").append(c0811a.f2791e).append(f2816a);
        }
        if (!TextUtils.isEmpty(c0811a.f2798l)) {
            sb.append("TZ:").append(c0811a.f2798l).append(f2816a);
        }
        if (!TextUtils.isEmpty(c0811a.f2794h)) {
            String str = "TENTATIVE";
            if ("TENTATIVE".equals(c0811a.f2794h)) {
                str = "TENTATIVE";
            } else if ("CONFIRMED".equals(c0811a.f2794h)) {
                str = "CONFIRMED";
            } else if ("CANCELLED".equals(c0811a.f2794h)) {
                str = "CANCELLED";
            } else if ("0".equals(c0811a.f2794h) || "1".equals(c0811a.f2794h) || "2".equals(c0811a.f2794h)) {
                switch (Integer.parseInt(c0811a.f2794h)) {
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
            sb.append("STATUS:").append(str).append(f2816a);
        }
        sb.append("END:VEVENT").append(f2816a);
        return sb.toString();
    }

    /* renamed from: a */
    private String m3349a(String str) {
        int length = 0;
        try {
            String[] strArrSplit = str.split("[ \t\n=]");
            StringBuilder sb = new StringBuilder();
            int length2 = 0;
            for (String str2 : strArrSplit) {
                if (str2.length() > 0) {
                    int iIndexOf = str.indexOf(str2, length2);
                    if (iIndexOf != length2) {
                        String str3 = null;
                        while (length2 < iIndexOf) {
                            if (str.charAt(length2) == " ".charAt(0)) {
                                if (length2 + 1 < iIndexOf && str.charAt(length2 + 1) == "\n".charAt(0)) {
                                    str3 = "=20";
                                } else {
                                    str3 = " ";
                                }
                            } else if (str.charAt(length2) == "\t".charAt(0)) {
                                if (length2 + 1 < iIndexOf && str.charAt(length2 + 1) == "\n".charAt(0)) {
                                    str3 = "=09";
                                } else {
                                    str3 = "\t";
                                }
                            } else if (str.charAt(length2) == "=".charAt(0)) {
                                str3 = "=3D";
                            } else if (str.charAt(length2) == "\n".charAt(0)) {
                                str3 = "=0D=0A";
                            }
                            sb.append(str3);
                            length += str3.length();
                            length2++;
                        }
                    }
                    String strReplaceAll = URLEncoder.encode(str2, "UTF-8").replaceAll("%", "=");
                    sb.append(strReplaceAll);
                    length += strReplaceAll.length();
                    length2 = str2.length() + iIndexOf;
                }
            }
            return "CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:" + sb.toString();
        } catch (Exception e) {
            C1341p.m4651a("Cannot encode", "VCardComposer");
            return null;
        }
    }
}
