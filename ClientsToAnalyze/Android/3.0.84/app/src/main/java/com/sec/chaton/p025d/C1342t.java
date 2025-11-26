package com.sec.chaton.p025d;

import android.os.Build;
import android.os.Handler;
import com.sec.chaton.p035io.entry.GetMoreAppList;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.settings.moreapps.p057a.C2711a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.EnumC3219cg;
import java.net.URLEncoder;

/* compiled from: MoreAppControl.java */
/* renamed from: com.sec.chaton.d.t */
/* loaded from: classes.dex */
public class C1342t {

    /* renamed from: a */
    private Handler f5067a;

    public C1342t(Handler handler) {
        this.f5067a = handler;
    }

    /* renamed from: a */
    public C2711a m5909a() {
        C2711a c2711a = new C2711a(this.f5067a, new C1582j(EnumC3219cg.CONTACT, "/contents/more").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("platform", "android").m6714a("osversion", Build.VERSION.SDK).m6714a("model", URLEncoder.encode(C3171am.m11055b())).m6714a("lang", C3171am.m11074l()).m6714a("width", "72").m6714a("height", "72").m6709a(101).m6717b(C1537b.class).m6712a(GetMoreAppList.class).m6708a());
        C1595w.m6742a().m6746c().m6723a(c2711a);
        return c2711a;
    }
}
