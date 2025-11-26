package com.sec.chaton;

import android.text.TextUtils;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.shop.p099a.C3707e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.InterfaceC4854bs;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.dp */
/* loaded from: classes.dex */
class C2161dp implements InterfaceC4854bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7790a;

    C2161dp(TabActivity tabActivity) {
        this.f7790a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC4854bs
    /* renamed from: a */
    public boolean mo7135a() {
        if (C4904y.f17872b) {
            C4904y.m18639b("upload puchase list : " + C4809aa.m18104a().m18121a("upload_purchaselist", "") + ", version : " + C1427a.f5063a, TabActivity.f2029t);
        }
        if (!C4809aa.m18104a().m18129b("uid") || !TextUtils.isEmpty(C4809aa.m18104a().m18121a("upload_purchaselist", ""))) {
            return false;
        }
        C3707e.m13998a(this.f7790a.f2058aC).m13999a();
        return true;
    }
}
