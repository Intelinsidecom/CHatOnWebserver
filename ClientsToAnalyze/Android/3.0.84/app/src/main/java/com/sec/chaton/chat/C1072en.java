package com.sec.chaton.chat;

import android.text.TextUtils;
import com.sec.chaton.chat.notification.C1111g;
import com.sec.chaton.p016a.C0296at;
import com.sec.chaton.p016a.C0299aw;
import com.sec.chaton.p016a.C0307bd;
import com.sec.chaton.p016a.C0330c;
import com.sec.chaton.p016a.C0336cf;
import com.sec.chaton.p016a.C0339ci;
import com.sec.chaton.p016a.C0369dl;
import com.sec.chaton.p016a.C0375dr;
import com.sec.chaton.p016a.C0378du;
import com.sec.chaton.p016a.C0385ea;
import com.sec.chaton.p016a.C0391f;
import com.sec.chaton.p016a.EnumC0354cx;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p035io.entry.PushEntry;
import com.sec.chaton.p042k.p043a.C1600a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ChatMessageLogWriter.java */
/* renamed from: com.sec.chaton.chat.en */
/* loaded from: classes.dex */
public class C1072en {

    /* renamed from: a */
    public static String f4303a = C1072en.class.getSimpleName();

    /* renamed from: a */
    public static String m5295a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.length() > i) {
            return str.substring(0, i);
        }
        return str;
    }

    /* renamed from: a */
    public static void m5307a(ArrayList<C1111g> arrayList, String str) {
        if (C3250y.f11735c && arrayList != null) {
            int size = arrayList.size() > 7 ? 7 : arrayList.size();
            for (int i = 0; i < size; i++) {
                C1111g c1111g = arrayList.get(i);
                StringBuilder sb = new StringBuilder("[NOTIPannel] ");
                sb.append("UID : ").append(C3159aa.m10962a().m10979a("uid", "")).append(", ").append("Sender : ").append(c1111g.f4499b).append(", ").append("MsgID : ").append(String.valueOf(c1111g.f4511n)).append(", ").append("ChatMsg : ").append(m5295a(c1111g.f4500c, 5)).append(", ").append("ChatMsgLength : ").append(c1111g.f4500c.length());
                C3250y.m11453c(sb.toString(), str);
            }
        }
    }

    /* renamed from: a */
    public static void m5297a(String str, long j, String str2, String str3, EnumC1455w enumC1455w, String str4) {
        if (C3250y.f11735c) {
            StringBuilder sb = new StringBuilder();
            sb.append("UID : ").append(C3159aa.m10962a().m10979a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("Sender : ").append(str2).append(", ").append("MsgID : ").append(String.valueOf(j)).append(", ").append("ContentType : ").append(enumC1455w).append(", ").append("ChatMsg : ").append(m5295a(str3, 5)).append(", ").append("ChatMsgLength : ").append(str3.length());
            C3250y.m11453c(sb.toString(), str4);
        }
    }

    /* renamed from: a */
    public static void m5306a(String str, String str2) {
        if (C3250y.f11735c) {
            try {
                PushEntry pushEntry = (PushEntry) new C1600a(str).m6782a(PushEntry.class);
                String strM5295a = m5295a(pushEntry.message, 5);
                int length = pushEntry.message.length();
                pushEntry.message = strM5295a;
                StringBuilder sb = new StringBuilder(pushEntry.toString());
                sb.append("ChatMsgLength : ").append(String.valueOf(length)).append("\n");
                C3250y.m11453c(sb.toString(), str2);
            } catch (Exception e) {
                C3250y.m11443a(e, f4303a);
            }
        }
    }

    /* renamed from: a */
    public static void m5300a(String str, C0307bd c0307bd, String str2) {
        if (C3250y.f11735c) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c0307bd.m1729g().size(); i++) {
                sb.append("[").append(i).append("] ").append("ChatType : ").append(c0307bd.m1723a(i).m2055p()).append(", ").append("Sender : ").append(c0307bd.m1723a(i).m2043d()).append(", ").append("Receiver : ").append(C3250y.m11437a((List<? extends Object>) c0307bd.m1723a(i).m2044e())).append(", ").append("Time : ").append(c0307bd.m1723a(i).m2051l()).append(", ").append("MsgID : ").append(c0307bd.m1723a(i).m2047h()).append(", ").append("MsgType : ").append(c0307bd.m1723a(i).m2053n()).append(", ").append("ChatMsg : ").append(m5295a(c0307bd.m1723a(i).m2049j(), 5)).append(", ").append("ChatMsgLength : ").append(c0307bd.m1723a(i).m2049j().length());
            }
            StringBuilder sb2 = new StringBuilder("[DeliveryChat]");
            sb2.append("UID : ").append(C3159aa.m10962a().m10979a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("ChatType : ").append(c0307bd.m1728f()).append(", ").append("SessionID : ").append(c0307bd.m1726d()).append(", ").append("InboxMessageCount : ").append(c0307bd.m1730h()).append(", ").append("NextPaginationKey : ").append(c0307bd.m1736n()).append(sb.toString());
            C3250y.m11453c(sb2.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m5299a(String str, C0299aw c0299aw, String str2) {
        if (C3250y.f11735c) {
            StringBuilder sb = new StringBuilder("p#ch@t[ChatRequest],");
            sb.append("UID : ").append(C3159aa.m10962a().m10979a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("ChatType : ").append(c0299aw.m1662h()).append(", ").append("SessionID : ").append(c0299aw.m1664j()).append(", ").append("Sender : ").append(c0299aw.m1666l()).append(", ").append("Receiver : ").append(C3250y.m11437a((List<? extends Object>) c0299aw.m1667m())).append(", ").append("Time : " + System.currentTimeMillis()).append(", ").append("MsgID : ").append(c0299aw.m1658d()).append(", ").append("MsgType : ").append(c0299aw.m1660f()).append(", ").append("ChatMsg : ").append(m5295a(c0299aw.m1673s(), 5)).append(", ").append("ChatMsgLength : ").append(c0299aw.m1673s().length()).append(", ").append("LastSessionMergeTime : ").append(c0299aw.m1677w());
            C3250y.m11453c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m5298a(String str, C0296at c0296at, String str2) {
        if (C3250y.f11735c) {
            StringBuilder sb = new StringBuilder("p#ch@t[ChatReply],");
            sb.append("UID : ").append(C3159aa.m10962a().m10979a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("SessionID : ").append(c0296at.m1600f()).append(", ").append("Time : " + System.currentTimeMillis()).append(", ").append("ReceivedTime : ").append(c0296at.m1604j()).append(", ").append("MsgID : ").append(c0296at.m1598d()).append(", ").append("ResultCode : ").append(c0296at.m1606l().m2494d()).append(", ").append("ResultMessage : ").append(c0296at.m1606l().m2496f()).append(", ").append("Server_address : ").append(c0296at.m1602h() != null ? c0296at.m1602h().m2698d() : "null").append(", ").append("Server_port : ").append(c0296at.m1602h() != null ? Integer.valueOf(c0296at.m1602h().m2700f()) : "null");
            C3250y.m11453c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m5305a(String str, C0391f c0391f, String str2) {
        if (C3250y.f11735c) {
            StringBuilder sb = new StringBuilder("[AllowChatRequest]");
            sb.append("UID : ").append(C3159aa.m10962a().m10979a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("ChatType : ").append(c0391f.m2775f()).append(", ").append("SessionID : ").append(c0391f.m2777h()).append(", ").append("Sender : ").append(c0391f.m2779j()).append(", ").append("Receiver : ").append(c0391f.m2781l()).append(", ").append("MsgID : ").append(c0391f.m2773d()).append(", ").append("LastSessionMergeTime : ").append(c0391f.m2791v()).append(", ").append("MaxMessageCount : ").append(c0391f.m2787r());
            C3250y.m11453c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m5301a(String str, C0330c c0330c, String str2) {
        if (C3250y.f11735c) {
            StringBuilder sb = new StringBuilder("[AllowChatReply]");
            sb.append("UID : ").append(C3159aa.m10962a().m10979a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("MsgID : ").append(c0330c.m1995d()).append(", ").append("ResultCode : ").append(c0330c.m1997f().m2494d()).append(", ").append("ResultMsg : ").append(c0330c.m1997f().m2496f());
            C3250y.m11453c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m5304a(String str, C0375dr c0375dr, String str2) {
        if (C3250y.f11735c) {
            List<C0378du> listM2600r = c0375dr.m2600r();
            StringBuilder sb = new StringBuilder();
            EnumC0354cx enumC0354cx = EnumC0354cx.TEXT;
            int i = 0;
            Iterator<C0378du> it = listM2600r.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    C0378du next = it.next();
                    sb.append("[").append(i2).append("]").append("MsgID : ").append(next.m2637d()).append(", ").append("MsgType : ").append(next.m2639f()).append(", ").append("ChatMsg : ").append(m5295a(next.m2641h(), 5)).append(", ").append("ChatMsgLength : ").append(next.m2641h());
                    i = i2 + 1;
                } else {
                    StringBuilder sb2 = new StringBuilder("[SerialChatRequest],");
                    sb2.append("UID : ").append(C3159aa.m10962a().m10979a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("ChatType : ").append(c0375dr.m2588f()).append(", ").append("SessionID : ").append(c0375dr.m2590h()).append(", ").append("Sender : ").append(c0375dr.m2592j()).append(", ").append("Receiver : ").append(C3250y.m11437a((List<? extends Object>) c0375dr.m2593k())).append(", ").append("Time : " + System.currentTimeMillis()).append(", ").append("LastSessionMergeTime : ").append(c0375dr.m2599q()).append(", ").append(sb.toString());
                    C3250y.m11453c(sb2.toString(), str2);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public static void m5303a(String str, C0339ci c0339ci, String str2) {
        if (C3250y.f11735c) {
            StringBuilder sb = new StringBuilder("p#ch@t[InitChatRequest],");
            sb.append("UID : ").append(C3159aa.m10962a().m10979a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("ChatType : ").append(c0339ci.m2148h()).append(", ").append("SessionID : ").append("N/A").append(", ").append("Sender : ").append(c0339ci.m2156p()).append(", ").append("Receiver : ").append(C3250y.m11437a((List<? extends Object>) c0339ci.m2157q())).append(", ").append("Time : " + System.currentTimeMillis()).append(", ").append("MsgID : ").append(c0339ci.m2144d()).append(", ").append("MsgType : ").append(c0339ci.m2146f()).append(", ").append("ChatMsg : ").append(m5295a(c0339ci.m2159s(), 5)).append(", ").append("ChatMsgLength : ").append(c0339ci.m2159s().length());
            C3250y.m11453c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m5302a(String str, C0336cf c0336cf, String str2) {
        if (C3250y.f11735c) {
            StringBuilder sb = new StringBuilder("p#ch@t[InitChatReply],");
            sb.append("UID : ").append(C3159aa.m10962a().m10979a("uid", "")).append(", ").append("InboxNo : ").append(str).append(", ").append("SessionID : ").append(c0336cf.m2090f()).append(", ").append("Time : ").append(System.currentTimeMillis()).append(", ").append("ReceivedTime : ").append(c0336cf.m2092h()).append(", ").append("MsgID : ").append(c0336cf.m2088d()).append(", ").append("ResultCode : ").append(c0336cf.m2096l() != null ? Integer.valueOf(c0336cf.m2096l().m2494d()) : "null").append(", ").append("ResultMessage : ").append(c0336cf.m2094j() != null ? c0336cf.m2096l().m2496f() : "null").append(", ").append("ServerInfo(address) : ").append(c0336cf.m2094j() != null ? c0336cf.m2094j().m2698d() : "null(broadcast)").append(", ").append("ServerInfo(address) : ").append(c0336cf.m2094j() != null ? Integer.valueOf(c0336cf.m2094j().m2700f()) : "null(broadcast)");
            C3250y.m11453c(sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m5296a(int i, String str, int i2, long j, String str2, String str3) {
        if (C3250y.f11735c) {
            switch (i) {
                case 1:
                    m5302a(str, C0336cf.newBuilder().m2111a("").m2113b(0L).m2105a(j).m2109a(C0369dl.newBuilder().m2507a(i2).m2512a("Failed")).build(), str3);
                    break;
                case 5:
                    m5298a(str, C0296at.newBuilder().m1621a(str2).m1623b(0L).m1615a(j).m1620a(C0385ea.newBuilder().m2710a("").m2707a(0).build()).m1619a(C0369dl.newBuilder().m2507a(i2).m2512a("Failed")).build(), str3);
                    break;
            }
        }
    }
}
