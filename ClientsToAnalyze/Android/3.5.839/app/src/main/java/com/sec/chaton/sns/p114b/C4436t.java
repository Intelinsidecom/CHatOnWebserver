package com.sec.chaton.sns.p114b;

import android.os.Bundle;
import com.renren.android.C0724f;
import com.renren.android.p042c.C0715a;
import com.renren.android.p042c.C0720f;
import com.renren.android.p042c.C0721g;
import com.sec.chaton.sns.C4373b;

/* compiled from: RenrenManager.java */
/* renamed from: com.sec.chaton.sns.b.t */
/* loaded from: classes.dex */
class C4436t extends C4438v {

    /* renamed from: d */
    final /* synthetic */ C4432p f16009d;

    /* renamed from: e */
    private String f16010e;

    /* synthetic */ C4436t(C4432p c4432p, C4433q c4433q) {
        this(c4432p);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C4436t(C4432p c4432p) {
        super(c4432p, "GetMyInfoTask");
        this.f16009d = c4432p;
        this.f16010e = "uid,name,tinyurl,mainurl,headurl";
    }

    @Override // com.sec.chaton.sns.p114b.C4438v, com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        C0721g c0721g;
        C0720f c0720f = new C0720f(new String[]{String.valueOf(C4432p.f16001d.m2262e())});
        c0720f.m2287a(this.f16010e);
        Bundle bundleM2286a = null;
        try {
            bundleM2286a = c0720f.m2286a();
        } catch (C0724f e) {
            e.printStackTrace();
        }
        int iA = m16814a(bundleM2286a);
        if (iA == -1 && (c0721g = new C0721g(m16815b())) != null && c0721g.m2288a().size() > 0) {
            C0715a c0715a = c0721g.m2288a().get(0);
            long jM2274a = c0715a.m2274a();
            String strM2276b = c0715a.m2276b();
            String strM2277c = c0715a.m2277c();
            C4373b.m16584b(this.f16009d.f16002e, String.valueOf(jM2274a));
            C4373b.m16582a(this.f16009d.f16002e, strM2276b);
            C4373b.m16586c(this.f16009d.f16002e, strM2277c);
        }
        return iA;
    }
}
