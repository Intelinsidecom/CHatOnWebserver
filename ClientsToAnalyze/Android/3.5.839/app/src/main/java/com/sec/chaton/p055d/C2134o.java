package com.sec.chaton.p055d;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.chat.translate.C1865r;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.AsyncTaskC1980cz;
import com.sec.chaton.p055d.p056a.AsyncTaskC2064w;
import com.sec.chaton.p055d.p056a.C1934bg;
import com.sec.chaton.p055d.p056a.C1937bj;
import com.sec.chaton.p055d.p056a.C1943bp;
import com.sec.chaton.p055d.p056a.C1944bq;
import com.sec.chaton.p055d.p056a.C1945br;
import com.sec.chaton.p055d.p056a.C1971cq;
import com.sec.chaton.p055d.p056a.C1972cr;
import com.sec.chaton.p055d.p056a.C1973cs;
import com.sec.chaton.p055d.p056a.C1979cy;
import com.sec.chaton.p055d.p056a.C2021em;
import com.sec.chaton.p055d.p056a.C2022en;
import com.sec.chaton.p055d.p056a.C2023eo;
import com.sec.chaton.p055d.p056a.C2029eu;
import com.sec.chaton.p055d.p056a.C2030ev;
import com.sec.chaton.p055d.p056a.C2031ew;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p065io.entry.ChatMemberListEntry;
import com.sec.chaton.p065io.entry.ChatProfileEntry;
import com.sec.chaton.p065io.entry.GetAllMessageList;
import com.sec.chaton.p065io.entry.GetUnReadMessageList;
import com.sec.chaton.p065io.entry.TranslationAuthEntry;
import com.sec.chaton.p065io.entry.TranslationEntry;
import com.sec.chaton.p065io.entry.inner.MsgTid;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2433c;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4867ce;
import com.sec.chaton.util.EnumC4868cf;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.Future;

/* compiled from: HttpMessageControl.java */
/* renamed from: com.sec.chaton.d.o */
/* loaded from: classes.dex */
public class C2134o {
    /* renamed from: a */
    public static Future<C0778b> m9565a(String str, String str2, String str3) {
        return C2472w.m10687a().m10692d().m10661a(new C2029eu(new C2456g(EnumC4868cf.TRANSLATION, "/stp/v2/text/translate").m10637a(EnumC2457h.POST).m10644b("User-Agent", C1865r.m9068a()).m10644b("OSVersion", Build.VERSION.RELEASE).m10644b("Accept", "application/octet-stream,application/json").m10644b("Content-Type", "application/octet-stream").m10641a("option", Spam.ACTIVITY_REPORT).m10641a("language", str2).m10641a("sid", "fs24s8z0hh").m10641a("cid", "fs24s8z0hh").m10641a("access_token", str).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10642a(false).m10645b(false).m10643b(C2031ew.class).m10638a(new C2030ev()).m10639a(TranslationEntry.class).m10635a(), str3));
    }

    /* renamed from: a */
    public static Future<C0778b> m9564a(String str, String str2) {
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.TRANSLATION_AUTH, "/stp/v2/getuserinfo").m10637a(EnumC2457h.GET).m10644b("User-Agent", C1865r.m9068a()).m10644b("OSVersion", Build.VERSION.RELEASE).m10644b("Accept", "application/json;text/xml").m10644b("Content-Type", "application/json;charset=UTF-8").m10641a("enkey", str2).m10641a("sid", "fs24s8z0hh").m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10642a(false).m10645b(false).m10643b(C1973cs.class).m10638a(new C1972cr()).m10639a(TranslationAuthEntry.class);
        if (!TextUtils.isEmpty(str)) {
            c2456gM10639a.m10641a("access_token", str);
        }
        String strM18258z = C4822an.m18258z();
        String strM18191A = C4822an.m18191A();
        if (!TextUtils.isEmpty(strM18258z) && !TextUtils.isEmpty(strM18191A)) {
            c2456gM10639a.m10641a("mcc", strM18258z);
            c2456gM10639a.m10641a("mnc", strM18191A);
        }
        return C2472w.m10687a().m10692d().m10661a(new C1971cq(c2456gM10639a.m10635a()));
    }

    /* renamed from: a */
    public static void m9567a(Handler handler) {
        if (C4822an.m18218a()) {
            long jM18118a = C4809aa.m18104a().m18118a("get_all_unread_message_timestamp", 0L);
            String strM18121a = C4809aa.m18104a().m18121a("get_all_unread_message_nextstartkey", "");
            if (C4904y.f17872b) {
                C4904y.m18639b("get_all_unread_message_timestamp : " + Long.toString(jM18118a) + ", get_all_unread_message_nextstartkey : " + strM18121a, "HttpMessageControl");
            }
            C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/inbox/page").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(VKApiConst.COUNT, String.valueOf(100)).m10639a(GetUnReadMessageList.class);
            if (jM18118a != 0) {
                c2456gM10639a.m10641a("senttime", Long.toString(jM18118a + 1));
            }
            if (!TextUtils.isEmpty(strM18121a)) {
                c2456gM10639a.m10641a("startkey", strM18121a);
            }
            C2472w.m10687a().m10692d().m10662a(new C1937bj(c2456gM10639a.m10635a()), 801, handler);
        }
    }

    /* renamed from: a */
    public static void m9574a(Handler handler, List<MsgTid> list, long j, String str) {
        C2472w.m10687a().m10692d().m10662a(new C2021em(new C2456g(EnumC4868cf.CONTACT, "/inbox").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "noans").m10635a(), list, j, str), 802, handler);
    }

    /* renamed from: a */
    public static void m9570a(Handler handler, String str, String str2, long j) {
        m9571a(handler, str, str2, j, false);
    }

    /* renamed from: a */
    public static void m9571a(Handler handler, String str, String str2, long j, boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18641c("InboxNO : " + str + ", SessionID : " + str2 + ", TimeStame : " + String.valueOf(j), C2134o.class.getSimpleName());
        }
        C2472w.m10687a().m10692d().m10662a(new C1943bp(new C2456g(EnumC4868cf.CONTACT, "/chat/memberlist").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("sessionid", str2).m10641a("timestamp", String.valueOf(j)).m10641a("mode", "multidevice").m10639a(ChatMemberListEntry.class).m10643b(C2407b.class).m10635a(), str, z), 803, handler);
    }

    /* renamed from: a */
    public static void m9572a(Handler handler, String str, String str2, EnumC2300t enumC2300t, String str3, Long l, int i) {
        if (C4904y.f17872b) {
            C4904y.m18641c("InboxNO : " + str + ", SessionID : " + str2 + ", TID : " + str3 + ", LstMsgTime : " + l, C2134o.class.getSimpleName());
        }
        C2456g c2456gM10641a = new C2456g(EnumC4868cf.CONTACT, "/chat/allmessages").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("sessionid", str2).m10641a("tid", str3).m10641a("senttime", String.valueOf(l)).m10641a(VKApiConst.COUNT, String.valueOf(i));
        if (enumC2300t == EnumC2300t.TOPIC) {
            c2456gM10641a.m10641a("beforejoin", "true");
        }
        c2456gM10641a.m10639a(GetAllMessageList.class).m10643b(C2407b.class);
        C2472w.m10687a().m10692d().m10662a(new C1934bg(c2456gM10641a.m10635a(), str, str2, enumC2300t), 811, handler);
    }

    /* renamed from: a */
    public static void m9566a() {
        if (C4904y.f17872b) {
            C4904y.m18639b("getChatONCryptoKey", C2134o.class.getSimpleName());
        }
        C2472w.m10687a().m10692d().m10661a(new C1944bq(new C2456g(EnumC4868cf.CONTACT, "/v5/version").m10635a()));
    }

    /* renamed from: a */
    public static void m9569a(Handler handler, String str, String str2) {
        new AsyncTaskC2064w(handler, str, str2).execute(new String[0]);
    }

    /* renamed from: b */
    public static void m9575b(Handler handler, String str, String str2) {
        String strM10534a;
        String strM18121a = C4809aa.m18104a().m18121a("uid", "");
        if (C4809aa.m18104a().m18119a("is_file_server_primary ", (Boolean) true).booleanValue()) {
            strM10534a = C2433c.m10534a(EnumC4867ce.PRIMARY, EnumC4868cf.FILE);
        } else {
            strM10534a = C2433c.m10534a(EnumC4867ce.SECONDARY, EnumC4868cf.FILE);
        }
        C2472w.m10687a().m10692d().m10662a(new C2022en(new C2456g(EnumC4868cf.CONTACT, "/chat/profileimage").m10637a(EnumC2457h.POST).m10641a("uid", strM18121a).m10641a("imei", C4822an.m18228d()).m10641a("sessionid", str).m10641a("imageaddr", strM10534a + "/file/image/" + strM18121a + "/").m10641a("imagefilepath", str2).m10635a()), 805, handler);
    }

    /* renamed from: c */
    public static void m9576c(Handler handler, String str, String str2) {
        C2456g c2456gM10641a = new C2456g(EnumC4868cf.CONTACT, "/chat/title").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("sessionid", str);
        try {
            c2456gM10641a.m10641a("title", URLEncoder.encode(str2, Charset.forName("UTF-8").name()));
        } catch (UnsupportedEncodingException e) {
            c2456gM10641a.m10641a("title", str2.replace(" ", ""));
            C4904y.m18634a(e.getMessage(), "setChatProfileTitle");
        }
        C2472w.m10687a().m10692d().m10662a(new C2023eo(c2456gM10641a.m10635a()), 806, handler);
    }

    /* renamed from: d */
    public static void m9577d(Handler handler, String str, String str2) {
        if (C4822an.m18204N()) {
            if (TextUtils.isEmpty(str)) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("[getChatProfileImageTitle] session ID is null. return", "HttpMessageControl");
                }
            } else {
                C2472w.m10687a().m10692d().m10662a(new C1945br(str2, new C2456g(EnumC4868cf.CONTACT, "/chat/titleprofile").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("sessionid", str).m10639a(ChatProfileEntry.class).m10643b(C2407b.class).m10635a()), 807, handler);
            }
        }
    }

    /* renamed from: a */
    public static void m9573a(Handler handler, String str, String str2, String str3) {
        new AsyncTaskC1980cz(handler, str, str2, str3).execute(new String[0]);
    }

    /* renamed from: a */
    public static void m9568a(Handler handler, String str) {
        String strM18595a;
        String strEncode = null;
        try {
            strEncode = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String string = new StringBuffer().append("imei=").append(C4822an.m18228d()).append("&groupname=").append(strEncode).toString();
        try {
            strM18595a = GlobalApplication.m10284c().m18595a();
        } catch (Exception e2) {
            C4904y.m18634a("Encryption Error", "HttpMessageControl");
        }
        if (TextUtils.isEmpty(strM18595a)) {
            throw new IOException("Fail in getting a key");
        }
        string = C4808a.m18098a(new C4808a(C4808a.m18100b(strM18595a), C4808a.m18101c(strM18595a)).m18102b(string.getBytes()));
        C2472w.m10687a().m10692d().m10661a(new C1979cy(new C2456g(EnumC4868cf.FILE, "/delgroupimage").m10637a(EnumC2457h.GET).m10640a("image/jpeg").m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("param", string).m10635a()));
    }
}
