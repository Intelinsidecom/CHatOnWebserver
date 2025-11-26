package com.sec.chaton.userprofile;

import com.sec.chaton.p025d.p027b.InterfaceC0642e;
import com.sec.chaton.util.C1341p;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.bo */
/* loaded from: classes.dex */
class C1245bo implements InterfaceC0642e {

    /* renamed from: a */
    final /* synthetic */ RelationshipRankFragment2 f4326a;

    C1245bo(RelationshipRankFragment2 relationshipRankFragment2) {
        this.f4326a = relationshipRankFragment2;
    }

    @Override // com.sec.chaton.p025d.p027b.InterfaceC0642e
    /* renamed from: a */
    public void mo2971a() {
        C1341p.m4662e("onRelationUpdateCompleted.", getClass().getSimpleName());
        this.f4326a.f4201i.dismiss();
        this.f4326a.m4349a(this.f4326a.f4213u);
    }
}
