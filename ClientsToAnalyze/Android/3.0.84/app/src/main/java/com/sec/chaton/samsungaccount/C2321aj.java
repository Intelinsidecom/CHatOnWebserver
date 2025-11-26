package com.sec.chaton.samsungaccount;

import com.sec.chaton.R;
import com.sec.chaton.util.C3214cb;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.aj */
/* loaded from: classes.dex */
class C2321aj implements InterfaceC2347bi {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8743a;

    C2321aj(MainActivity mainActivity) {
        this.f8743a = mainActivity;
    }

    @Override // com.sec.chaton.samsungaccount.InterfaceC2347bi
    /* renamed from: a */
    public void mo8678a(String str) {
        this.f8743a.m8743a(this.f8743a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8743a.f8650A, this.f8743a.f8651B);
        if (this.f8743a.f8727x) {
            C3214cb.m11253a(str, this.f8743a.f8714k, true);
            this.f8743a.m8765c(false);
        } else {
            C3214cb.m11253a(str, this.f8743a.f8714k, false);
            this.f8743a.f8721r.mo5479a(this.f8743a.f8678aC);
            this.f8743a.f8678aC.m11091a(1001, 30000);
        }
    }
}
