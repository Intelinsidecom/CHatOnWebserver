package com.sec.chaton.p020c;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.sec.chaton.p025d.p026a.C1167av;
import com.sec.chaton.p025d.p026a.C1195bw;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p035io.entry.DownloadSkinEntry;
import com.sec.chaton.p035io.entry.GetListSkinEntry;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.settings.downloads.C2591cd;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.EnumC3219cg;
import com.sec.common.util.C3347i;
import java.net.URLEncoder;

/* compiled from: SkinMessageControl.java */
/* renamed from: com.sec.chaton.c.h */
/* loaded from: classes.dex */
public class C0823h {

    /* renamed from: a */
    private Handler f3152a;

    public C0823h(Context context, Handler handler) {
        this.f3152a = handler;
    }

    /* renamed from: a */
    public C1195bw m4378a(EnumC1172b enumC1172b, int i, int i2, int i3, int i4) {
        C1195bw c1195bw = new C1195bw(this.f3152a, new C1582j(EnumC3219cg.CONTACT, "/skin").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("platform", "android").m6714a("osversion", Build.VERSION.SDK).m6714a("model", URLEncoder.encode(C3171am.m11055b())).m6714a("lang", C3171am.m11074l()).m6714a("pvwidth", String.valueOf(i)).m6714a("pvheight", String.valueOf(i2)).m6714a("dvwidth", String.valueOf(i3)).m6714a("dvheight", String.valueOf(i4)).m6714a("stwidth", String.valueOf(C2591cd.m9564a())).m6714a("stheight", String.valueOf(C2591cd.m9564a())).m6714a("rwidth", String.valueOf(C3347i.m11782e())).m6714a("rheight", String.valueOf(C3347i.m11783f())).m6714a("bgtype", "pa_ma").m6709a(1100).m6717b(C1537b.class).m6712a(GetListSkinEntry.class).m6708a(), enumC1172b);
        C1595w.m6742a().m6746c().m6723a(c1195bw);
        return c1195bw;
    }

    /* renamed from: a */
    public C1167av m4377a(EnumC1172b enumC1172b, String str, int i, int i2, String str2) {
        int i3 = 0;
        if ("pa".equals(str2)) {
            i3 = 1;
        } else if ("ma".equals(str2)) {
            i3 = 2;
        }
        C1167av c1167av = new C1167av(this.f3152a, new C1582j(EnumC3219cg.CONTACT, "/skin/download").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("platform", "android").m6714a("skinid", str).m6714a("stwidth", String.valueOf(i)).m6714a("stheight", String.valueOf(i2)).m6714a("rwidth", String.valueOf(C3347i.m11782e())).m6714a("rheight", String.valueOf(C3347i.m11783f())).m6714a("bgtype", String.valueOf(i3)).m6709a(1101).m6717b(C1537b.class).m6712a(DownloadSkinEntry.class).m6708a(), enumC1172b);
        C1595w.m6742a().m6746c().m6723a(c1167av);
        return c1167av;
    }
}
