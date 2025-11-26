package com.sec.chaton.specialbuddy;

import com.sec.chaton.R;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.widget.C2153y;

/* compiled from: SpecialBuddyInfo.java */
/* renamed from: com.sec.chaton.specialbuddy.e */
/* loaded from: classes.dex */
class C1508e implements InterfaceC0677d {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyInfo f5426a;

    C1508e(SpecialBuddyInfo specialBuddyInfo) {
        this.f5426a = specialBuddyInfo;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0677d
    /* renamed from: a */
    public void mo2365a(int i, boolean z, Object obj) {
        if (!z) {
            this.f5426a.m5211g();
            return;
        }
        if (i == 2 && !this.f5426a.isFinishing()) {
            this.f5426a.m5211g();
            C2153y.m7536a(this.f5426a.f5404a, this.f5426a.getResources().getString(R.string.buddy_profile_block_toast_success, this.f5426a.f5412l), 0).show();
            this.f5426a.f5405b.setVisibility(8);
            this.f5426a.f5406c.setVisibility(0);
        }
    }
}
