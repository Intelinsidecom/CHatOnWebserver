package com.sec.chaton.p055d;

import android.os.Handler;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.C1915ao;
import com.sec.chaton.p055d.p056a.C1970cp;
import com.sec.chaton.p065io.entry.NewUpdateListEntry;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.EnumC4868cf;
import java.util.ArrayList;
import java.util.concurrent.Future;

/* compiled from: UpdatesControl.java */
/* renamed from: com.sec.chaton.d.bz */
/* loaded from: classes.dex */
public class C2120bz {

    /* renamed from: a */
    private Handler f7696a;

    /* renamed from: b */
    private Future<C0778b> f7697b = null;

    public C2120bz(Handler handler) {
        this.f7696a = handler;
    }

    /* renamed from: a */
    public void m9466a() {
        this.f7697b = C2472w.m10687a().m10691c().m10662a(new C1970cp(new C2456g(EnumC4868cf.CONTACT, "/newupdate/list").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(VKApiConst.COUNT, "10").m10641a("timestamp", Long.valueOf(System.currentTimeMillis()).toString()).m10643b(C2407b.class).m10639a(NewUpdateListEntry.class).m10635a()), 8001, this.f7696a);
    }

    /* renamed from: a */
    public void m9467a(String str) {
        this.f7697b = C2472w.m10687a().m10691c().m10662a(new C1970cp(new C2456g(EnumC4868cf.CONTACT, "/newupdate/list").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(VKApiConst.COUNT, "10").m10641a("timestamp", Long.valueOf(Long.parseLong(str) - 1).toString()).m10643b(C2407b.class).m10639a(NewUpdateListEntry.class).m10635a()), 8001, this.f7696a);
    }

    /* renamed from: a */
    public void m9468a(ArrayList<String> arrayList) {
        C2472w.m10687a().m10691c().m10662a(new C1915ao(new C2456g(EnumC4868cf.CONTACT, "/newupdate/delete").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(VKApiConst.COUNT, "10").m10641a("mode", "returnlist").m10643b(C2407b.class).m10639a(NewUpdateListEntry.class).m10635a(), arrayList), 8002, this.f7696a);
    }
}
