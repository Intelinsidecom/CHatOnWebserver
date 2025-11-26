package com.sec.chaton.buddy;

import com.sec.chaton.account.C0210g;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.InterfaceC1745ba;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bb */
/* loaded from: classes.dex */
class C0290bb implements InterfaceC1745ba {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1386a;

    C0290bb(BuddyFragment buddyFragment) {
        this.f1386a = buddyFragment;
    }

    @Override // com.sec.chaton.util.InterfaceC1745ba
    /* renamed from: a */
    public boolean mo1790a() {
        if (C1789u.m6075a().contains("uid")) {
            C0210g.m1815b("getAllBuddies");
            new C0633e(null).m2854a(-1, -1);
            return true;
        }
        return true;
    }
}
