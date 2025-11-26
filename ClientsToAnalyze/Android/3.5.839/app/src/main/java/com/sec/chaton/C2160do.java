package com.sec.chaton;

import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.InterfaceC4854bs;
import com.sec.common.util.C5052r;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.do */
/* loaded from: classes.dex */
class C2160do implements InterfaceC4854bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7789a;

    C2160do(TabActivity tabActivity) {
        this.f7789a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC4854bs
    /* renamed from: a */
    public boolean mo7135a() {
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("UID : ", Boolean.valueOf(C4809aa.m18104a().m18129b("uid")), ", compatibility : ", C4809aa.m18104a().m18121a("compatibility", ""), ", version : ", C1427a.f5063a), TabActivity.f2029t);
        }
        if (!C4809aa.m18104a().m18129b("uid") || (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("compatibility", "")) && C1427a.f5063a.equals(C4809aa.m18104a().m18121a("compatibility", "")))) {
            return false;
        }
        new C2128i(this.f7789a.f2057aB).m9533h();
        C4904y.m18639b("Start CompatibilityTask", GlobalApplication.class.getSimpleName());
        return true;
    }
}
