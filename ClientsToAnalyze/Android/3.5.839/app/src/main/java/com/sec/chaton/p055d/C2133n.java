package com.sec.chaton.p055d;

import android.os.Handler;
import com.sec.chaton.block.C1093u;
import com.sec.chaton.p055d.p056a.C1950bw;
import com.sec.chaton.p055d.p056a.C1982da;
import com.sec.chaton.p065io.entry.GetHideBuddyList;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import java.util.ArrayList;

/* compiled from: HideControl.java */
/* renamed from: com.sec.chaton.d.n */
/* loaded from: classes.dex */
public class C2133n {

    /* renamed from: a */
    private Handler f7737a;

    public C2133n(Handler handler) {
        this.f7737a = handler;
    }

    /* renamed from: a */
    public void m9558a() {
        C4904y.m18641c("access server /buddy/hide/list", getClass().getSimpleName());
        C2472w.m10687a().m10690b().m10662a(new C1950bw(new C2456g(EnumC4868cf.CONTACT, "/buddy/hide/list").m10637a(EnumC2457h.GET).m10639a(GetHideBuddyList.class).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a()), 701, this.f7737a);
    }

    /* renamed from: a */
    public void m9559a(String str) {
        C2472w.m10687a().m10691c().m10662a(new C1982da(new C2456g(EnumC4868cf.CONTACT, "/buddy/hide").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "post").m10643b(C2407b.class).m10635a(), str, true), 702, this.f7737a);
    }

    /* renamed from: a */
    public void m9561a(String[] strArr) {
        C2472w.m10687a().m10691c().m10662a(new C1982da(new C2456g(EnumC4868cf.CONTACT, "/buddy/hide").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "post").m10643b(C2407b.class).m10635a(), strArr, true), 703, this.f7737a);
    }

    /* renamed from: b */
    public void m9563b(String[] strArr) {
        C2472w.m10687a().m10691c().m10662a(new C1982da(new C2456g(EnumC4868cf.CONTACT, "/buddy/hide").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "post").m10643b(C2407b.class).m10635a(), strArr, true), 706, this.f7737a);
    }

    /* renamed from: b */
    public void m9562b(String str) {
        C2472w.m10687a().m10691c().m10662a(new C1982da(new C2456g(EnumC4868cf.CONTACT, "/buddy/hide").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "post").m10643b(C2407b.class).m10635a(), str, false), 704, this.f7737a);
    }

    /* renamed from: a */
    public void m9560a(ArrayList<C1093u> arrayList) {
        C2472w.m10687a().m10691c().m10662a(new C1982da(new C2456g(EnumC4868cf.CONTACT, "/buddy/hide").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "post").m10643b(C2407b.class).m10635a(), arrayList, false), 705, this.f7737a);
    }
}
