package com.sec.chaton.buddy;

import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.InterfaceC4854bs;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cu */
/* loaded from: classes.dex */
class C1184cu implements InterfaceC4854bs {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4412a;

    C1184cu(BuddyFragment buddyFragment) {
        this.f4412a = buddyFragment;
    }

    @Override // com.sec.chaton.util.InterfaceC4854bs
    /* renamed from: a */
    public boolean mo7135a() throws Throwable {
        C4904y.m18639b("mGetAllBuddiesTaskInBuddylist run [UID] " + C4809aa.m18104a().m18129b("uid") + " [MSISDN] " + C4809aa.m18104a().m18121a("msisdn", ""), BuddyFragment.f3576a);
        if (C4809aa.m18104a().m18129b("uid")) {
            new C2128i(null).m9495a();
            if (this.f4412a.f3605L == null) {
                this.f4412a.f3605L = new C2075ah(this.f4412a.f3724cD);
            }
            if (C4822an.m18204N()) {
                this.f4412a.f3605L.m9312c(null);
            }
        }
        C4904y.m18639b("mGetAllBuddiesTaskInBuddylist finish", BuddyFragment.f3576a);
        return true;
    }
}
