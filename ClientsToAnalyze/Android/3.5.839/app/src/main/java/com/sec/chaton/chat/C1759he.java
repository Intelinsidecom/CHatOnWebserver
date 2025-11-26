package com.sec.chaton.chat;

import android.os.Handler;
import com.sec.chaton.p055d.p056a.C1942bo;
import com.sec.chaton.p065io.entry.ChatListInfoEntry;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.provider.p089a.C3035a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;

/* compiled from: GetChatListInfo.java */
/* renamed from: com.sec.chaton.chat.he */
/* loaded from: classes.dex */
public class C1759he {

    /* renamed from: a */
    private Handler f6602a;

    /* renamed from: b */
    private long f6603b;

    /* renamed from: c */
    private boolean f6604c;

    /* renamed from: a */
    public static C1759he m8726a(Handler handler, long j) {
        boolean z = false;
        if (j == 0) {
            z = true;
        }
        return new C1759he(handler, j, z);
    }

    /* renamed from: a */
    public static C1759he m8727a(Handler handler, long j, boolean z) {
        return new C1759he(handler, j, z);
    }

    private C1759he(Handler handler, long j, boolean z) {
        this.f6604c = false;
        this.f6602a = handler;
        this.f6603b = j;
        this.f6604c = z;
    }

    /* renamed from: a */
    public void m8728a() {
        if (!C4822an.m18204N() && this.f6603b != 0) {
            this.f6602a.sendEmptyMessage(2301);
            return;
        }
        String strM18121a = C4809aa.m18104a().m18121a("uid", "");
        String strM18228d = C4822an.m18228d();
        if (C4904y.f17871a) {
            C4904y.m18646e("UID : " + strM18121a + ", IMEI : " + strM18228d + ", lastUpdateTime : " + String.valueOf(this.f6603b), getClass().getSimpleName());
        }
        C3035a.m12466d();
        C2456g c2456gM10643b = new C2456g(EnumC4868cf.CONTACT, "/chat/infoall/v3").m10637a(EnumC2457h.GET).m10641a("uid", strM18121a).m10641a("imei", strM18228d).m10641a("lastupdatetime", String.valueOf(this.f6603b)).m10641a("mode", "all").m10639a(ChatListInfoEntry.class).m10643b(C2407b.class);
        if (this.f6604c) {
            c2456gM10643b.m10641a("excludeexitchat", "true");
        }
        C2472w.m10687a().m10692d().m10662a(new C1942bo(c2456gM10643b.m10635a()), 2301, this.f6602a);
    }
}
