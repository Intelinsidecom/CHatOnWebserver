package com.sec.chaton.p055d;

import android.os.Handler;
import com.sec.chaton.p055d.p056a.C1986de;
import com.sec.chaton.p065io.entry.InviteBuddyEntry;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.EnumC4868cf;
import java.util.List;

/* compiled from: SMSMessageControl.java */
/* renamed from: com.sec.chaton.d.bd */
/* loaded from: classes.dex */
public class C2098bd {

    /* renamed from: a */
    private Handler f7617a;

    public C2098bd(Handler handler) {
        this.f7617a = handler;
    }

    /* renamed from: a */
    public C1986de m9377a(List<String> list, EnumC2463n enumC2463n) {
        C1986de c1986de = new C1986de(new C2456g(EnumC4868cf.CONTACT, "/buddy/invite").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10643b(C2407b.class).m10639a(InviteBuddyEntry.class).m10635a());
        c1986de.m9138a(list);
        C2472w.m10687a().m10691c().m10664a(c1986de, enumC2463n, 1201, this.f7617a);
        return c1986de;
    }
}
