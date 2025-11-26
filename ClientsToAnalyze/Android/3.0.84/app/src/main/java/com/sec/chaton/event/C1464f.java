package com.sec.chaton.event;

import android.text.TextUtils;
import com.sec.chaton.p035io.entry.inner.Event;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3227co;
import com.sec.chaton.util.C3250y;
import java.io.File;

/* compiled from: EventPageHelper.java */
/* renamed from: com.sec.chaton.event.f */
/* loaded from: classes.dex */
public class C1464f {

    /* renamed from: a */
    private static final String f5442a = C1464f.class.getSimpleName();

    /* renamed from: a */
    public static void m6387a() {
        C3250y.m11450b("remove all preference for event", f5442a);
        C3160ab c3160abM10962a = C3159aa.m10962a();
        c3160abM10962a.m10981a("event_id");
        c3160abM10962a.m10981a("event_banner_url");
        c3160abM10962a.m10981a("event_dialog_checkbox");
        c3160abM10962a.m10981a("event_do_not_show_popup_time");
        c3160abM10962a.m10981a("event_image_downloaded");
        c3160abM10962a.m10981a("event_show_popup");
        c3160abM10962a.m10981a("event_title");
        c3160abM10962a.m10981a("event_end_date");
        c3160abM10962a.m10981a("event_start_date");
        c3160abM10962a.m10981a("event_winner_end_date");
        c3160abM10962a.m10981a("event_winner_start_date");
        c3160abM10962a.m10981a("event_web_url");
        c3160abM10962a.m10981a("event_url_loaded");
        c3160abM10962a.m10981a("event_winner_url_loaded");
        c3160abM10962a.m10981a("notification_api_event_timestamp");
    }

    /* renamed from: b */
    public static void m6391b() {
        File fileM6407n = m6407n();
        if (fileM6407n != null && fileM6407n.exists()) {
            fileM6407n.delete();
        }
        m6389a(false);
    }

    /* renamed from: a */
    public static void m6388a(Event event) {
        C3160ab c3160abM10962a = C3159aa.m10962a();
        c3160abM10962a.m10984b("event_id", Integer.valueOf(Integer.parseInt(event.eventid)));
        c3160abM10962a.m10986b("event_title", event.title);
        c3160abM10962a.m10983b("event_dialog_checkbox", (Boolean) false);
        c3160abM10962a.m10982a("event_start_date", Long.valueOf(Long.parseLong(event.startdate)));
        c3160abM10962a.m10982a("event_end_date", Long.valueOf(Long.parseLong(event.enddate)));
        c3160abM10962a.m10982a("event_winner_start_date", Long.valueOf(Long.parseLong(event.winnerstartdate)));
        c3160abM10962a.m10982a("event_winner_end_date", Long.valueOf(Long.parseLong(event.winnerenddate)));
        if (!event.bannerurl.equals(c3160abM10962a.m10979a("event_banner_url", (String) null))) {
            m6391b();
        }
        c3160abM10962a.m10986b("event_banner_url", event.bannerurl);
        c3160abM10962a.m10986b("event_web_url", event.weburl);
    }

    /* renamed from: b */
    public static void m6392b(Event event) {
        C3160ab c3160abM10962a = C3159aa.m10962a();
        Long lValueOf = Long.valueOf(Long.parseLong(event.startdate));
        Long lValueOf2 = Long.valueOf(Long.parseLong(event.enddate));
        Long lValueOf3 = Long.valueOf(Long.parseLong(event.winnerstartdate));
        Long lValueOf4 = Long.valueOf(Long.parseLong(event.winnerenddate));
        if (!event.title.equals(c3160abM10962a.m10979a("event_title", (String) null))) {
            c3160abM10962a.m10986b("event_title", event.title);
            C3250y.m11450b("event title information updated", f5442a);
        }
        if (lValueOf.longValue() != c3160abM10962a.m10976a("event_start_date", 0L)) {
            c3160abM10962a.m10982a("event_start_date", lValueOf);
            C3250y.m11450b("event startdate information updated", f5442a);
        }
        if (lValueOf2.longValue() != c3160abM10962a.m10976a("event_end_date", 0L)) {
            c3160abM10962a.m10982a("event_end_date", lValueOf2);
            C3250y.m11450b("event enddate information updated", f5442a);
        }
        if (lValueOf3.longValue() != c3160abM10962a.m10976a("event_winner_start_date", 0L)) {
            c3160abM10962a.m10982a("event_winner_start_date", lValueOf3);
            C3250y.m11450b("event winnerstartdate information updated", f5442a);
        }
        if (lValueOf4.longValue() != c3160abM10962a.m10976a("event_winner_end_date", 0L)) {
            c3160abM10962a.m10982a("event_winner_end_date", lValueOf4);
            C3250y.m11450b("event winnerenddate information updated", f5442a);
        }
        if (!event.bannerurl.equals(c3160abM10962a.m10979a("event_banner_url", (String) null))) {
            m6391b();
            c3160abM10962a.m10986b("event_banner_url", event.bannerurl);
            C3250y.m11450b("event bannerurl information updated", f5442a);
        }
        if (!event.weburl.equals(c3160abM10962a.m10979a("event_web_url", (String) null))) {
            c3160abM10962a.m10986b("event_web_url", event.weburl);
            C3250y.m11450b("event weburl information updated", f5442a);
        }
    }

    /* renamed from: c */
    public static boolean m6396c(Event event) {
        return C3159aa.m10962a().m10978a("event_id", (Integer) (-1)).intValue() == Integer.parseInt(event.eventid);
    }

    /* renamed from: c */
    public static boolean m6395c() {
        if (m6397d() && m6398e() && m6400g() && (!TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", "")) || C3171am.m11080r())) {
            if (!m6403j()) {
                return true;
            }
            if (Long.valueOf(System.currentTimeMillis()).longValue() >= Long.valueOf(C3227co.m11338a(Long.valueOf(C3159aa.m10962a().m10976a("event_do_not_show_popup_time", 0L)).longValue(), 5)).longValue()) {
                m6393b(false);
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m6397d() {
        return C3159aa.m10962a().m10987b("event_id");
    }

    /* renamed from: e */
    public static boolean m6398e() {
        File fileM6407n = m6407n();
        return fileM6407n != null && fileM6407n.exists() && m6402i();
    }

    /* renamed from: f */
    public static boolean m6399f() {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        Long lValueOf2 = Long.valueOf(C3159aa.m10962a().m10976a("event_start_date", 0L));
        Long lValueOf3 = Long.valueOf(C3159aa.m10962a().m10976a("event_winner_end_date", 0L));
        C3250y.m11450b("isWholePeriod() curTime=" + lValueOf + " eventStartTime=" + lValueOf2 + " winnerEndTime=" + lValueOf3, f5442a);
        return m6397d() && lValueOf2.longValue() <= lValueOf.longValue() && lValueOf.longValue() <= lValueOf3.longValue();
    }

    /* renamed from: g */
    public static boolean m6400g() {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        Long lValueOf2 = Long.valueOf(C3159aa.m10962a().m10976a("event_start_date", 0L));
        Long lValueOf3 = Long.valueOf(C3159aa.m10962a().m10976a("event_end_date", 0L));
        C3250y.m11450b("isEventPeriod() curTime=" + lValueOf + " startTime=" + lValueOf2 + " endTime=" + lValueOf3, f5442a);
        return lValueOf2.longValue() <= lValueOf.longValue() && lValueOf.longValue() <= lValueOf3.longValue();
    }

    /* renamed from: h */
    public static boolean m6401h() {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        Long lValueOf2 = Long.valueOf(C3159aa.m10962a().m10976a("event_winner_start_date", 0L));
        Long lValueOf3 = Long.valueOf(C3159aa.m10962a().m10976a("event_winner_end_date", 0L));
        C3250y.m11450b("isWinnerPeriod() curTime=" + lValueOf + " winnerStartTime=" + lValueOf2 + " winnerEndTime=" + lValueOf3, f5442a);
        return lValueOf2.longValue() <= lValueOf.longValue() && lValueOf.longValue() <= lValueOf3.longValue();
    }

    /* renamed from: a */
    public static void m6389a(boolean z) {
        C3250y.m11450b("setDownloadBannerImage = " + z, f5442a);
        C3159aa.m10962a().m10983b("event_image_downloaded", Boolean.valueOf(z));
    }

    /* renamed from: b */
    public static void m6393b(boolean z) {
        C3250y.m11450b("setEnabledDoNotShowPopup = " + z, f5442a);
        C3159aa.m10962a().m10983b("event_dialog_checkbox", Boolean.valueOf(z));
    }

    /* renamed from: i */
    public static boolean m6402i() {
        return C3159aa.m10962a().m10977a("event_image_downloaded", (Boolean) false).booleanValue();
    }

    /* renamed from: j */
    public static boolean m6403j() {
        return C3159aa.m10962a().m10977a("event_dialog_checkbox", (Boolean) false).booleanValue();
    }

    /* renamed from: k */
    public static String m6404k() {
        return C3159aa.m10962a().m10979a("event_banner_url", (String) null);
    }

    /* renamed from: c */
    public static void m6394c(boolean z) {
        if (m6400g()) {
            C3159aa.m10962a().m10983b("event_url_loaded", Boolean.valueOf(z));
        } else if (m6401h()) {
            C3159aa.m10962a().m10983b("event_winner_url_loaded", Boolean.valueOf(z));
        }
    }

    /* renamed from: l */
    public static Boolean m6405l() {
        if (m6400g()) {
            return C3159aa.m10962a().m10977a("event_url_loaded", (Boolean) false);
        }
        if (m6401h()) {
            return C3159aa.m10962a().m10977a("event_winner_url_loaded", (Boolean) false);
        }
        return false;
    }

    /* renamed from: m */
    public static int m6406m() {
        if (!m6397d()) {
            return 0;
        }
        if ((!m6400g() && !m6401h()) || !m6398e() || m6405l().booleanValue()) {
            return 0;
        }
        return 1;
    }

    /* renamed from: n */
    public static File m6407n() {
        if (!m6402i()) {
            return null;
        }
        String strM6404k = m6404k();
        String strM11328b = C3223ck.m11328b();
        if (strM6404k == null) {
            return null;
        }
        String strSubstring = strM6404k.substring(strM6404k.lastIndexOf("/"));
        C3250y.m11450b("getSavedBannerImageFile() dir = " + strM11328b + ", filename = " + strSubstring, f5442a);
        return new File(strM11328b, strSubstring);
    }

    /* renamed from: a */
    public static boolean m6390a(Long l) {
        return Long.valueOf(System.currentTimeMillis()).longValue() > l.longValue();
    }
}
