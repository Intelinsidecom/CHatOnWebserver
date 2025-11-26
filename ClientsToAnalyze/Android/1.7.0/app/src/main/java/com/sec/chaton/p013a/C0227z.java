package com.sec.chaton.p013a;

import android.os.Handler;
import com.sec.chaton.chat.p024b.C0552a;
import com.sec.chaton.p013a.p014a.C0132ah;
import com.sec.chaton.p013a.p014a.C0145au;
import com.sec.chaton.p013a.p014a.C0151b;
import com.sec.chaton.p013a.p014a.C0181t;
import com.sec.chaton.p018c.C0512s;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.p033io.entry.ChatMemberListEntry;
import com.sec.chaton.p033io.entry.GetUnReadMessageList;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.EnumC1333h;
import java.util.List;

/* compiled from: HttpMessageControl.java */
/* renamed from: com.sec.chaton.a.z */
/* loaded from: classes.dex */
public class C0227z {
    /* renamed from: a */
    public static void m876a(Handler handler) {
        long j = C1323bs.m4575a().getLong("get_all_unread_message_timestamp", 0L);
        if (C1341p.f4578b) {
            C1341p.m4658b("get_all_unread_message_timestamp : " + Long.toString(j), "HttpMessageControl");
        }
        C0519z c0519zM2582a = new C0519z(EnumC1333h.CONTACT, "/inboxes").m2581a(EnumC0511r.GET).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2580a(801).m2582a(GetUnReadMessageList.class);
        if (j != 0) {
            c0519zM2582a.m2584a("timestamp", Long.toString(j));
        }
        C0512s.m2577a().offer(new C0181t(handler, c0519zM2582a.m2579a()));
    }

    /* renamed from: a */
    public static void m878a(Handler handler, List list) {
        C0512s.m2577a().offer(new C0132ah(handler, new C0519z(EnumC1333h.CONTACT, "/inbox").m2581a(EnumC0511r.POST).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2580a(802).m2579a(), list));
    }

    /* renamed from: a */
    public static void m877a(Handler handler, String str, String str2, long j) {
        if (C1341p.f4578b) {
            C1341p.m4660c("InboxNO : " + str + ", SessionID : " + str2 + ", TimeStame : " + String.valueOf(j), C0227z.class.getSimpleName());
        }
        C0512s.m2577a().offer(new C0151b(handler, new C0519z(EnumC1333h.CONTACT, "/chat/memberlist").m2581a(EnumC0511r.GET).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("sessionid", str2).m2584a("timestamp", String.valueOf(j)).m2580a(803).m2582a(ChatMemberListEntry.class).m2586b(C0552a.class).m2579a(), str));
    }

    /* renamed from: a */
    public static void m875a() {
        if (C1341p.f4578b) {
            C1341p.m4658b("getChatONCryptoKey", C0227z.class.getSimpleName());
        }
        C0512s.m2577a().offer(new C0145au(null, new C0519z(null, null).m2580a(803).m2579a()));
    }
}
