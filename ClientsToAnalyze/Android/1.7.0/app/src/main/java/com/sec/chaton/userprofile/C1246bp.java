package com.sec.chaton.userprofile;

import com.sec.chaton.p025d.p027b.InterfaceC0641d;
import com.sec.chaton.util.C1341p;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.bp */
/* loaded from: classes.dex */
class C1246bp implements InterfaceC0641d {

    /* renamed from: a */
    final /* synthetic */ RelationshipRankFragment2 f4327a;

    C1246bp(RelationshipRankFragment2 relationshipRankFragment2) {
        this.f4327a = relationshipRankFragment2;
    }

    @Override // com.sec.chaton.p025d.p027b.InterfaceC0641d
    /* renamed from: a */
    public void mo2364a(int i, boolean z, Object obj) {
        if (z) {
            C1341p.m4658b("Query Result OK. refreshTime=" + this.f4327a.f4214v, getClass().getSimpleName());
            if (this.f4327a.f4200h != null) {
                C1341p.m4658b("mProgressDialog_refresh result ok", getClass().getSimpleName());
                this.f4327a.f4200h.dismiss();
            }
            this.f4327a.m4349a(this.f4327a.f4213u);
            return;
        }
        C1341p.m4658b("Query Result NOK...", getClass().getSimpleName());
        if (this.f4327a.f4200h != null) {
            C1341p.m4658b("mProgressDialog_refresh result nok", getClass().getSimpleName());
            this.f4327a.f4200h.dismiss();
        }
    }
}
