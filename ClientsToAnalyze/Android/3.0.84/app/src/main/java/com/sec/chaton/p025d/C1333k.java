package com.sec.chaton.p025d;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.sec.chaton.p025d.p026a.C1194bv;
import com.sec.chaton.p025d.p026a.C1222cw;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p035io.entry.GetFontListEntry;
import com.sec.chaton.p035io.entry.InstallFontEntry;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.EnumC3219cg;
import java.net.URLEncoder;

/* compiled from: FontMessageControl.java */
/* renamed from: com.sec.chaton.d.k */
/* loaded from: classes.dex */
public class C1333k {

    /* renamed from: a */
    private Handler f5032a;

    public C1333k(Context context, Handler handler) {
        this.f5032a = handler;
    }

    /* renamed from: a */
    public void m5774a() {
        this.f5032a = null;
    }

    /* renamed from: a */
    public C1194bv m5772a(EnumC1172b enumC1172b, int i, int i2, int i3, int i4) {
        C1194bv c1194bv = new C1194bv(this.f5032a, new C1582j(EnumC3219cg.CONTACT, "/font").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("platform", "android").m6714a("osversion", Build.VERSION.SDK).m6714a("model", URLEncoder.encode(C3171am.m11055b())).m6714a("lang", C3171am.m11074l()).m6714a("thwidth", String.valueOf(i)).m6714a("thheight", String.valueOf(i2)).m6714a("pvwidth", String.valueOf(i3)).m6714a("pvheight", String.valueOf(i4)).m6709a(1000).m6717b(C1537b.class).m6712a(GetFontListEntry.class).m6708a(), enumC1172b);
        C1595w.m6742a().m6746c().m6723a(c1194bv);
        return c1194bv;
    }

    /* renamed from: a */
    public C1222cw m5773a(EnumC1172b enumC1172b, String str) {
        C1222cw c1222cw = new C1222cw(this.f5032a, new C1582j(EnumC3219cg.CONTACT, "/font/download").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("id", str).m6709a(1001).m6717b(C1537b.class).m6712a(InstallFontEntry.class).m6708a(), enumC1172b);
        C1595w.m6742a().m6746c().m6723a(c1222cw);
        return c1222cw;
    }
}
