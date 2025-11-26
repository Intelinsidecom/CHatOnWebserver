package com.sec.chaton.p015d;

import android.os.Handler;
import com.sec.chaton.chat.p014b.C0486a;
import com.sec.chaton.p015d.p016a.C0541ai;
import com.sec.chaton.p015d.p016a.C0548ap;
import com.sec.chaton.p015d.p016a.C0576bq;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.p028io.entry.ChatMemberListEntry;
import com.sec.chaton.p028io.entry.GetUnReadMessageList;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;
import java.util.List;

/* compiled from: HttpMessageControl.java */
/* renamed from: com.sec.chaton.d.g */
/* loaded from: classes.dex */
public class C0635g {

    /* renamed from: a */
    private Handler f2475a;

    public C0635g(Handler handler) {
        this.f2475a = handler;
    }

    /* renamed from: a */
    public void m2887a() {
        C0802l.m3412a().offer(new C0541ai(this.f2475a, new C0800j(EnumC1765bu.CONTACT, "/inboxes").m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3405a(801).m3407a(GetUnReadMessageList.class).m3404a()));
    }

    /* renamed from: a */
    public void m2888a(List list) {
        C0802l.m3412a().offer(new C0576bq(this.f2475a, new C0800j(EnumC1765bu.CONTACT, "/inbox").m3406a(EnumC0801k.POST).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3405a(802).m3404a(), list));
    }

    /* renamed from: a */
    public static void m2886a(Handler handler, String str, String str2, long j) {
        if (C1786r.f6452b) {
            C1786r.m6063c("InboxNO : " + str + ", SessionID : " + str2 + ", TimeStame : " + String.valueOf(j), C0635g.class.getSimpleName());
        }
        C0802l.m3412a().offer(new C0548ap(handler, new C0800j(EnumC1765bu.CONTACT, "/chat/memberlist").m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("sessionid", str2).m3409a("timestamp", String.valueOf(j)).m3405a(803).m3407a(ChatMemberListEntry.class).m3410b(C0486a.class).m3404a(), str));
    }
}
