package com.sec.chaton.p055d;

import android.os.Handler;
import com.sec.chaton.p051c.C1428b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.settings.moreapps.entry.PlusListEntry;
import com.sec.chaton.settings.moreapps.p098a.C3668b;
import com.sec.chaton.settings.moreapps.p098a.C3669c;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.common.util.C5034k;

/* compiled from: PlusListControl.java */
/* renamed from: com.sec.chaton.d.af */
/* loaded from: classes.dex */
public class C2073af {

    /* renamed from: a */
    private Handler f7559a;

    /* renamed from: a */
    public static C2073af m9284a(Handler handler) {
        return new C2073af(handler);
    }

    public C2073af(Handler handler) {
        this.f7559a = handler;
    }

    /* renamed from: a */
    public C3668b m9285a() {
        C3668b c3668b = new C3668b(new C2456g(EnumC4868cf.CONTACT, C1428b.f5102h).m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(C1428b.f5093I, C4822an.m18248p()).m10641a("countrycd", C4822an.m18257y()).m10641a("devicewidth", Integer.toString(C5034k.m19100e())).m10641a("deviceheight", Integer.toString(C5034k.m19101f())).m10641a("platform", "android").m10643b(C3669c.class).m10639a(PlusListEntry.class).m10635a());
        C2472w.m10687a().m10691c().m10662a(c3668b, 101, this.f7559a);
        return c3668b;
    }
}
