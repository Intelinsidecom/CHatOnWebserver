package com.sec.chaton.userprofile;

import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.util.C1786r;

/* compiled from: MyPageRelationshipRankFragment.java */
/* renamed from: com.sec.chaton.userprofile.ap */
/* loaded from: classes.dex */
class C1639ap implements InterfaceC0677d {

    /* renamed from: a */
    final /* synthetic */ MyPageRelationshipRankFragment f6128a;

    C1639ap(MyPageRelationshipRankFragment myPageRelationshipRankFragment) {
        this.f6128a = myPageRelationshipRankFragment;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0677d
    /* renamed from: a */
    public void mo2365a(int i, boolean z, Object obj) {
        if (z) {
            C1786r.m6061b("Query Result OK. refreshTime=" + this.f6128a.f5943r, getClass().getSimpleName());
            if (this.f6128a.f5931e != null) {
                C1786r.m6061b("mProgressDialog_refresh result ok", getClass().getSimpleName());
                this.f6128a.f5931e.dismiss();
            }
            this.f6128a.m5658a(this.f6128a.f5942q);
            return;
        }
        C1786r.m6061b("Query Result NOK...", getClass().getSimpleName());
        if (this.f6128a.f5931e != null) {
            C1786r.m6061b("mProgressDialog_refresh result nok", getClass().getSimpleName());
            this.f6128a.f5931e.dismiss();
        }
    }
}
