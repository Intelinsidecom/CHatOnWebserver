package com.sec.chaton.multimedia.vcalendar;

import android.text.TextUtils;
import com.sec.chaton.util.C1769by;
import com.sec.chaton.util.C1786r;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import weibo4android.org.json.HTTP;

/* compiled from: VCalComposer.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.a */
/* loaded from: classes.dex */
public class C1021a {

    /* renamed from: a */
    private static String f3752a = HTTP.CRLF;

    /* renamed from: b */
    private String f3753b = null;

    /* renamed from: a */
    public String m3981a(C1029i c1029i, int i) throws C1022b {
        StringBuilder sb = new StringBuilder();
        if (i != 1 && i != 2) {
            throw new C1022b("version not match 1.0 or 2.0.");
        }
        if (i == 1) {
            this.f3753b = "vcalendar1.0";
        } else {
            this.f3753b = "vcalendar2.0";
        }
        sb.append("BEGIN:VCALENDAR").append(f3752a);
        if (i == 1) {
            sb.append("VERSION:1.0").append(f3752a);
        } else {
            sb.append("VERSION:2.0").append(f3752a);
        }
        sb.append("PRODID:vCal ID default").append(f3752a);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < c1029i.f3772a.size()) {
                sb.append(m3979a((C1030j) c1029i.f3772a.get(i3)));
                i2 = i3 + 1;
            } else {
                sb.append("END:VCALENDAR").append(f3752a).append(f3752a);
                return sb.toString();
            }
        }
    }

    /* renamed from: a */
    private String m3979a(C1030j c1030j) {
        StringBuilder sb = new StringBuilder();
        sb.append("BEGIN:VEVENT").append(f3752a);
        if (!TextUtils.isEmpty(c1030j.f3783k)) {
            sb.append("UID:").append(c1030j.f3783k).append(f3752a);
        }
        if (!TextUtils.isEmpty(c1030j.f3773a)) {
            sb.append("DESCRIPTION;").append(m3980a(c1030j.f3773a)).append(f3752a);
        }
        if (!TextUtils.isEmpty(c1030j.f3775c)) {
            sb.append("DTSTART:").append(C1769by.m6007a(new Date(Long.parseLong(c1030j.f3775c)))).append(f3752a);
        }
        if (!TextUtils.isEmpty(c1030j.f3774b)) {
            sb.append("DTEND:").append(C1769by.m6007a(new Date(Long.parseLong(c1030j.f3774b)))).append(f3752a);
        }
        if (!TextUtils.isEmpty(c1030j.f3776d)) {
            sb.append("DUE:").append(c1030j.f3776d).append(f3752a);
        }
        if (!TextUtils.isEmpty(c1030j.f3782j)) {
            sb.append("LOCATION;").append(m3980a(c1030j.f3782j)).append(f3752a);
        }
        if (!TextUtils.isEmpty(c1030j.f3778f)) {
            sb.append("COMPLETED:").append(C1769by.m6007a(new Date(Long.parseLong(c1030j.f3778f)))).append(f3752a);
        }
        if (!TextUtils.isEmpty(c1030j.f3779g)) {
            sb.append("RRULE:").append(c1030j.f3779g).append(f3752a);
        }
        if (!TextUtils.isEmpty(c1030j.f3781i)) {
            sb.append("SUMMARY;").append(m3980a(c1030j.f3781i)).append(f3752a);
        }
        if (!TextUtils.isEmpty(c1030j.f3785m)) {
            sb.append("ALLDAY:").append(c1030j.f3785m).append(f3752a);
        }
        if (!TextUtils.isEmpty(c1030j.f3777e)) {
            sb.append("ALARM:").append(c1030j.f3777e).append(f3752a);
        }
        if (!TextUtils.isEmpty(c1030j.f3784l)) {
            sb.append("TZ:").append(c1030j.f3784l).append(f3752a);
        }
        if (!TextUtils.isEmpty(c1030j.f3780h)) {
            String str = "TENTATIVE";
            if ("TENTATIVE".equals(c1030j.f3780h)) {
                str = "TENTATIVE";
            } else if ("CONFIRMED".equals(c1030j.f3780h)) {
                str = "CONFIRMED";
            } else if ("CANCELLED".equals(c1030j.f3780h)) {
                str = "CANCELLED";
            } else if ("0".equals(c1030j.f3780h) || "1".equals(c1030j.f3780h) || "2".equals(c1030j.f3780h)) {
                switch (Integer.parseInt(c1030j.f3780h)) {
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
            sb.append("STATUS:").append(str).append(f3752a);
        }
        sb.append("END:VEVENT").append(f3752a);
        return sb.toString();
    }

    /* renamed from: a */
    private String m3980a(String str) {
        try {
            String[] strArrSplit = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArrSplit) {
                sb.append(URLEncoder.encode(str2, "UTF-8").replaceAll("%", "=") + " ");
            }
            return "CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:" + sb.toString();
        } catch (UnsupportedEncodingException e) {
            C1786r.m6054a("Cannot encode", "VCardComposer");
            return null;
        }
    }
}
