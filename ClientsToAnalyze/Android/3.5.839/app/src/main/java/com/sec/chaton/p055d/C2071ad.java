package com.sec.chaton.p055d;

import android.os.Build;
import android.os.Handler;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p065io.entry.GetMoreAppList;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.settings.moreapps.p098a.C3667a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.EnumC4868cf;
import java.net.URLEncoder;

/* compiled from: MoreAppControl.java */
/* renamed from: com.sec.chaton.d.ad */
/* loaded from: classes.dex */
public class C2071ad {

    /* renamed from: a */
    private Handler f7556a;

    /* renamed from: a */
    public static C2071ad m9281a(Handler handler) {
        return new C2071ad(handler);
    }

    public C2071ad(Handler handler) {
        this.f7556a = handler;
    }

    /* renamed from: a */
    public C3667a m9282a() {
        C3667a c3667a = new C3667a(new C2456g(EnumC4868cf.CONTACT, "/contents/plusmenu").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("platform", "android").m10641a("osversion", Build.VERSION.SDK).m10641a("model", URLEncoder.encode(C4822an.m18231e())).m10641a(VKApiConst.LANG, C4822an.m18247o()).m10641a(VKOpenAuthActivity.VK_EXTRA_API_VERSION, C1427a.f5063a).m10641a("width", "90").m10641a("height", "90").m10643b(C2407b.class).m10639a(GetMoreAppList.class).m10635a());
        C2472w.m10687a().m10691c().m10662a(c3667a, 101, this.f7556a);
        return c3667a;
    }
}
