package com.sec.chaton.userprofile;

import com.sec.chaton.p017e.p019b.InterfaceC0687n;
import com.sec.chaton.util.C1786r;

/* compiled from: MyPageRelationshipRankFragment.java */
/* renamed from: com.sec.chaton.userprofile.aq */
/* loaded from: classes.dex */
class C1640aq implements InterfaceC0687n {

    /* renamed from: a */
    final /* synthetic */ MyPageRelationshipRankFragment f6129a;

    C1640aq(MyPageRelationshipRankFragment myPageRelationshipRankFragment) {
        this.f6129a = myPageRelationshipRankFragment;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0687n
    /* renamed from: a */
    public void mo3119a() {
        C1786r.m6066e("onRelationUpdateCompleted.", getClass().getSimpleName());
        this.f6129a.f5932f.dismiss();
        this.f6129a.m5658a(this.f6129a.f5942q);
    }
}
