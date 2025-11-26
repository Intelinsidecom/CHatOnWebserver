package com.sec.chaton.userprofile;

import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.util.C1786r;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.bq */
/* loaded from: classes.dex */
class C1667bq implements InterfaceC0677d {

    /* renamed from: a */
    final /* synthetic */ RelationshipRankFragment2 f6160a;

    C1667bq(RelationshipRankFragment2 relationshipRankFragment2) {
        this.f6160a = relationshipRankFragment2;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0677d
    /* renamed from: a */
    public void mo2365a(int i, boolean z, Object obj) {
        if (z) {
            C1786r.m6061b("Query Result OK. refreshTime=" + this.f6160a.f6008q, getClass().getSimpleName());
            if (this.f6160a.f6000h != null) {
                C1786r.m6061b("mProgressDialog_refresh result ok", getClass().getSimpleName());
                this.f6160a.f6000h.dismiss();
            }
            this.f6160a.m5694a(this.f6160a.f6014w);
            return;
        }
        C1786r.m6061b("Query Result NOK...", getClass().getSimpleName());
        if (this.f6160a.f6000h != null) {
            C1786r.m6061b("mProgressDialog_refresh result nok", getClass().getSimpleName());
            this.f6160a.f6000h.dismiss();
        }
    }
}
