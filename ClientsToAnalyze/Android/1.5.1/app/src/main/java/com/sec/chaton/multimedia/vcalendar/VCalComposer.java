package com.sec.chaton.multimedia.vcalendar;

import com.sec.chaton.multimedia.vcalendar.VCalendarStruct;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.TimeAdapter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

/* loaded from: classes.dex */
public class VCalComposer {

    /* renamed from: a */
    private static String f2182a = "\r\n";

    /* renamed from: b */
    private String f2183b = null;

    /* renamed from: a */
    private String m2555a(VCalendarStruct.EventStruct eventStruct) {
        StringBuilder sb = new StringBuilder();
        sb.append("BEGIN:VEVENT").append(f2182a);
        if (!m2556a(eventStruct.f2246k)) {
            sb.append("UID:").append(eventStruct.f2246k).append(f2182a);
        }
        if (!m2556a(eventStruct.f2236a)) {
            sb.append("DESCRIPTION;").append(m2557b(eventStruct.f2236a)).append(f2182a);
        }
        if (!m2556a(eventStruct.f2238c)) {
            sb.append("DTSTART:").append(TimeAdapter.m3680a(new Date(Long.parseLong(eventStruct.f2238c)))).append(f2182a);
        }
        if (!m2556a(eventStruct.f2237b)) {
            sb.append("DTEND:").append(TimeAdapter.m3680a(new Date(Long.parseLong(eventStruct.f2237b)))).append(f2182a);
        }
        if (!m2556a(eventStruct.f2239d)) {
            sb.append("DUE:").append(eventStruct.f2239d).append(f2182a);
        }
        if (!m2556a(eventStruct.f2245j)) {
            sb.append("LOCATION;").append(m2557b(eventStruct.f2245j)).append(f2182a);
        }
        if (!m2556a(eventStruct.f2241f)) {
            sb.append("COMPLETED:").append(TimeAdapter.m3680a(new Date(Long.parseLong(eventStruct.f2241f)))).append(f2182a);
        }
        if (!m2556a(eventStruct.f2242g)) {
            sb.append("RRULE:").append(eventStruct.f2242g).append(f2182a);
        }
        if (!m2556a(eventStruct.f2244i)) {
            sb.append("SUMMARY;").append(m2557b(eventStruct.f2244i)).append(f2182a);
        }
        if (!m2556a(eventStruct.f2248m)) {
            sb.append("ALLDAY:").append(eventStruct.f2248m).append(f2182a);
        }
        if (!m2556a(eventStruct.f2240e)) {
            sb.append("ALARM:").append(eventStruct.f2240e).append(f2182a);
        }
        if (!m2556a(eventStruct.f2247l)) {
            sb.append("TZ:").append(eventStruct.f2247l).append(f2182a);
        }
        if (!m2556a(eventStruct.f2243h)) {
            String str = "TENTATIVE";
            if (!eventStruct.f2243h.equals("TENTATIVE")) {
                if (!eventStruct.f2243h.equals("CONFIRMED")) {
                    if (!eventStruct.f2243h.equals("CANCELLED")) {
                        if (eventStruct.f2243h.equals("0") || eventStruct.f2243h.equals("1") || eventStruct.f2243h.equals("2")) {
                            switch (Integer.parseInt(eventStruct.f2243h)) {
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
                    } else {
                        str = "CANCELLED";
                    }
                } else {
                    str = "CONFIRMED";
                }
            } else {
                str = "TENTATIVE";
            }
            sb.append("STATUS:").append(str).append(f2182a);
        }
        sb.append("END:VEVENT").append(f2182a);
        return sb.toString();
    }

    /* renamed from: a */
    private boolean m2556a(String str) {
        return str == null || str.trim().equals("");
    }

    /* renamed from: b */
    private String m2557b(String str) {
        try {
            String[] strArrSplit = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArrSplit) {
                sb.append(URLEncoder.encode(str2, "UTF-8").replaceAll("%", "=") + " ");
            }
            return "CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:" + sb.toString();
        } catch (UnsupportedEncodingException e) {
            ChatONLogWriter.m3499a("Cannot encode", "VCardComposer");
            return null;
        }
    }

    /* renamed from: a */
    public String m2558a(VCalendarStruct vCalendarStruct, int i) throws VCalException {
        StringBuilder sb = new StringBuilder();
        if (i != 1 && i != 2) {
            throw new VCalException("version not match 1.0 or 2.0.");
        }
        if (i == 1) {
            this.f2183b = "vcalendar1.0";
        } else {
            this.f2183b = "vcalendar2.0";
        }
        sb.append("BEGIN:VCALENDAR").append(f2182a);
        if (i == 1) {
            sb.append("VERSION:1.0").append(f2182a);
        } else {
            sb.append("VERSION:2.0").append(f2182a);
        }
        sb.append("PRODID:vCal ID default").append(f2182a);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= vCalendarStruct.f2235a.size()) {
                sb.append("END:VCALENDAR").append(f2182a).append(f2182a);
                return sb.toString();
            }
            sb.append(m2555a((VCalendarStruct.EventStruct) vCalendarStruct.f2235a.get(i3)));
            i2 = i3 + 1;
        }
    }
}
