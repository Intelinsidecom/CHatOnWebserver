package com.sec.chaton.userprofile;

import com.sec.chaton.p017e.p019b.InterfaceC0687n;
import com.sec.chaton.util.C1786r;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.br */
/* loaded from: classes.dex */
class C1668br implements InterfaceC0687n {

    /* renamed from: a */
    final /* synthetic */ RelationshipRankFragment2 f6161a;

    C1668br(RelationshipRankFragment2 relationshipRankFragment2) {
        this.f6161a = relationshipRankFragment2;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0687n
    /* renamed from: a */
    public void mo3119a() {
        C1786r.m6066e("onRelationUpdateCompleted.", getClass().getSimpleName());
        this.f6161a.f6001i.dismiss();
        this.f6161a.m5694a(this.f6161a.f6014w);
    }
}
