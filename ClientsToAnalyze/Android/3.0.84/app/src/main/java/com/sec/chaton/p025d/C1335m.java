package com.sec.chaton.p025d;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.chat.p024b.C0965p;
import com.sec.chaton.p025d.p026a.AsyncTaskC1146aa;
import com.sec.chaton.p025d.p026a.AsyncTaskC1218cs;
import com.sec.chaton.p025d.p026a.C1176bd;
import com.sec.chaton.p025d.p026a.C1179bg;
import com.sec.chaton.p025d.p026a.C1187bo;
import com.sec.chaton.p025d.p026a.C1188bp;
import com.sec.chaton.p025d.p026a.C1189bq;
import com.sec.chaton.p025d.p026a.C1210ck;
import com.sec.chaton.p025d.p026a.C1211cl;
import com.sec.chaton.p025d.p026a.C1212cm;
import com.sec.chaton.p025d.p026a.C1217cr;
import com.sec.chaton.p025d.p026a.C1241do;
import com.sec.chaton.p025d.p026a.C1242dp;
import com.sec.chaton.p025d.p026a.C1243dq;
import com.sec.chaton.p025d.p026a.C1249dw;
import com.sec.chaton.p025d.p026a.C1250dx;
import com.sec.chaton.p025d.p026a.C1251dy;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p035io.entry.ChatMemberListEntry;
import com.sec.chaton.p035io.entry.ChatProfileEntry;
import com.sec.chaton.p035io.entry.GetAllMessageList;
import com.sec.chaton.p035io.entry.GetUnReadMessageList;
import com.sec.chaton.p035io.entry.TranslationAuthEntry;
import com.sec.chaton.p035io.entry.TranslationEntry;
import com.sec.chaton.p035io.entry.inner.MsgTid;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1554c;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3218cf;
import com.sec.chaton.util.EnumC3219cg;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: HttpMessageControl.java */
/* renamed from: com.sec.chaton.d.m */
/* loaded from: classes.dex */
public class C1335m {
    /* renamed from: a */
    public static C1249dw m5779a(String str, String str2, String str3) {
        C1249dw c1249dw = new C1249dw(null, new C1582j(EnumC3219cg.TRANSLATION, "/stp/v1/text/translate").m6710a(EnumC1583k.POST).m6718b("User-Agent", C0965p.m5182a()).m6718b("OSVersion", Build.VERSION.RELEASE).m6718b("Accept", "application/octet-stream,application/json").m6718b("Content-Type", "application/octet-stream").m6714a("option", "1").m6714a("language", str2).m6714a("sid", "fs24s8z0hh").m6714a("cid", "fs24s8z0hh").m6714a("access_token", str).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6709a(813).m6715a(false).m6719b(false).m6717b(C1251dy.class).m6711a(new C1250dx()).m6712a(TranslationEntry.class).m6708a(), str3);
        C1595w.m6742a().m6747d().m6723a(c1249dw);
        return c1249dw;
    }

    /* renamed from: a */
    public static C1210ck m5778a(String str) {
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.TRANSLATION_AUTH, "/stp/v1/getuserinfo").m6710a(EnumC1583k.GET).m6718b("User-Agent", C0965p.m5182a()).m6718b("OSVersion", Build.VERSION.RELEASE).m6718b("Accept", "application/json;text/xml").m6718b("Content-Type", "application/json;charset=UTF-8").m6714a("option", "21").m6714a("access_token", str).m6714a("client_id", "fs24s8z0hh").m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6709a(812).m6715a(false).m6719b(false).m6717b(C1212cm.class).m6711a(new C1211cl()).m6712a(TranslationAuthEntry.class);
        String strM11083u = C3171am.m11083u();
        String strM11084v = C3171am.m11084v();
        if (!TextUtils.isEmpty(strM11083u) && !TextUtils.isEmpty(strM11084v)) {
            c1582jM6712a.m6714a("mcc", strM11083u);
            c1582jM6712a.m6714a("mnc", strM11084v);
        }
        C1210ck c1210ck = new C1210ck(null, c1582jM6712a.m6708a());
        C1595w.m6742a().m6747d().m6723a(c1210ck);
        return c1210ck;
    }

    /* renamed from: a */
    public static void m5781a(Handler handler) {
        long jM10976a = C3159aa.m10962a().m10976a("get_all_unread_message_timestamp", 0L);
        String strM10979a = C3159aa.m10962a().m10979a("get_all_unread_message_nextstartkey", "");
        if (C3250y.f11734b) {
            C3250y.m11450b("get_all_unread_message_timestamp : " + Long.toString(jM10976a) + ", get_all_unread_message_nextstartkey : " + strM10979a, "HttpMessageControl");
        }
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/inbox/page").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("count", String.valueOf(100)).m6709a(801).m6712a(GetUnReadMessageList.class);
        if (jM10976a != 0) {
            c1582jM6712a.m6714a("senttime", Long.toString(jM10976a + 1));
        }
        if (!TextUtils.isEmpty(strM10979a)) {
            c1582jM6712a.m6714a("startkey", strM10979a);
        }
        C1595w.m6742a().m6747d().m6723a(new C1179bg(handler, c1582jM6712a.m6708a()));
    }

    /* renamed from: a */
    public static void m5787a(Handler handler, List<MsgTid> list, long j, String str) {
        C1595w.m6742a().m6747d().m6723a(new C1241do(handler, new C1582j(EnumC3219cg.CONTACT, "/inbox").m6710a(EnumC1583k.POST).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6709a(802).m6708a(), list, j, str));
    }

    /* renamed from: a */
    public static void m5784a(Handler handler, String str, String str2, long j) {
        if (C3250y.f11734b) {
            C3250y.m11453c("InboxNO : " + str + ", SessionID : " + str2 + ", TimeStame : " + String.valueOf(j), C1335m.class.getSimpleName());
        }
        C1595w.m6742a().m6747d().m6723a(new C1187bo(handler, new C1582j(EnumC3219cg.CONTACT, "/chat/memberlist").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("sessionid", str2).m6714a("timestamp", String.valueOf(j)).m6714a(RtspHeaders.Values.MODE, "multidevice").m6709a(803).m6712a(ChatMemberListEntry.class).m6717b(C1537b.class).m6708a(), str));
    }

    /* renamed from: a */
    public static void m5785a(Handler handler, String str, String str2, EnumC1450r enumC1450r, String str3, Long l, int i) {
        if (C3250y.f11734b) {
            C3250y.m11453c("InboxNO : " + str + ", SessionID : " + str2 + ", TID : " + str3 + ", LstMsgTime : " + l, C1335m.class.getSimpleName());
        }
        C1595w.m6742a().m6747d().m6723a(new C1176bd(handler, new C1582j(EnumC3219cg.CONTACT, "/chat/allmessages").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("sessionid", str2).m6714a("tid", str3).m6714a("senttime", String.valueOf(l)).m6714a("count", String.valueOf(i)).m6709a(811).m6712a(GetAllMessageList.class).m6717b(C1537b.class).m6708a(), str, str2, enumC1450r));
    }

    /* renamed from: a */
    public static void m5780a() {
        if (C3250y.f11734b) {
            C3250y.m11450b("getChatONCryptoKey", C1335m.class.getSimpleName());
        }
        C1595w.m6742a().m6747d().m6723a(new C1188bp(null, new C1582j(EnumC3219cg.CONTACT, "/v5/version").m6709a(803).m6708a()));
    }

    /* renamed from: a */
    public static void m5783a(Handler handler, String str, String str2) {
        new AsyncTaskC1146aa(handler, str, str2).execute(new String[0]);
    }

    /* renamed from: b */
    public static void m5788b(Handler handler, String str, String str2) {
        String strM6590a;
        String strM10979a = C3159aa.m10962a().m10979a("uid", "");
        if (C3159aa.m10962a().m10977a("is_file_server_primary ", (Boolean) true).booleanValue()) {
            strM6590a = C1554c.m6590a(EnumC3218cf.PRIMARY, EnumC3219cg.FILE);
        } else {
            strM6590a = C1554c.m6590a(EnumC3218cf.SECONDARY, EnumC3219cg.FILE);
        }
        C1595w.m6742a().m6747d().m6723a(new C1242dp(handler, new C1582j(EnumC3219cg.CONTACT, "/chat/profileimage").m6710a(EnumC1583k.POST).m6709a(805).m6714a("uid", strM10979a).m6714a("imei", C3171am.m11045a()).m6714a("sessionid", str).m6714a("imageaddr", strM6590a + "/file/image/" + strM10979a + "/").m6714a("imagefilepath", str2).m6708a()));
    }

    /* renamed from: c */
    public static void m5789c(Handler handler, String str, String str2) {
        C1582j c1582jM6714a = new C1582j(EnumC3219cg.CONTACT, "/chat/title").m6710a(EnumC1583k.POST).m6709a(806).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("sessionid", str);
        try {
            c1582jM6714a.m6714a("title", URLEncoder.encode(str2, Charset.forName("UTF-8").name()));
        } catch (UnsupportedEncodingException e) {
            c1582jM6714a.m6714a("title", str2.replace(" ", ""));
            C3250y.m11442a(e.getMessage(), "setChatProfileTitle");
        }
        C1595w.m6742a().m6747d().m6723a(new C1243dq(handler, c1582jM6714a.m6708a()));
    }

    /* renamed from: d */
    public static void m5790d(Handler handler, String str, String str2) {
        C1595w.m6742a().m6747d().m6723a(new C1189bq(handler, str2, new C1582j(EnumC3219cg.CONTACT, "/chat/titleprofile").m6710a(EnumC1583k.GET).m6709a(807).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("sessionid", str).m6712a(ChatProfileEntry.class).m6717b(C1537b.class).m6708a()));
    }

    /* renamed from: a */
    public static void m5786a(Handler handler, String str, String str2, String str3) {
        new AsyncTaskC1218cs(handler, str, str2, str3).execute(new String[0]);
    }

    /* renamed from: a */
    public static void m5782a(Handler handler, String str) throws UnsupportedEncodingException {
        String strEncode = null;
        try {
            strEncode = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        C1595w.m6742a().m6747d().m6723a(new C1217cr(handler, new C1582j(EnumC3219cg.FILE, "/delgroupimage").m6710a(EnumC1583k.GET).m6713a("image/jpeg").m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("groupname", strEncode).m6708a()));
    }
}
