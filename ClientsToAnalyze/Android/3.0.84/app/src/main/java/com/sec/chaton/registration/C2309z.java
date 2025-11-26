package com.sec.chaton.registration;

import com.sec.chaton.R;
import com.sec.chaton.samsungaccount.InterfaceC2347bi;
import com.sec.chaton.util.C3214cb;

/* compiled from: ActivitySyncSignInPopup.java */
/* renamed from: com.sec.chaton.registration.z */
/* loaded from: classes.dex */
class C2309z implements InterfaceC2347bi {

    /* renamed from: a */
    final /* synthetic */ ActivitySyncSignInPopup f8616a;

    C2309z(ActivitySyncSignInPopup activitySyncSignInPopup) {
        this.f8616a = activitySyncSignInPopup;
    }

    @Override // com.sec.chaton.samsungaccount.InterfaceC2347bi
    /* renamed from: a */
    public void mo8678a(String str) {
        this.f8616a.m8400a(this.f8616a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8616a.f8136y, this.f8616a.f8137z);
        C3214cb.m11253a(str, this.f8616a.f8118g, true);
        this.f8616a.m8407b(false);
    }
}
