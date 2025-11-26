package com.sec.chaton.buddy;

import com.sec.chaton.R;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.widget.C3641ai;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hr */
/* loaded from: classes.dex */
class C0761hr implements InterfaceC1413d {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3028a;

    C0761hr(SpecialBuddyFragment specialBuddyFragment) {
        this.f3028a = specialBuddyFragment;
    }

    @Override // com.sec.chaton.p027e.p029b.InterfaceC1413d
    /* renamed from: a */
    public void mo4048a(int i, boolean z, Object obj) {
        if (!z) {
            this.f3028a.m3908k();
        } else if (i == 2) {
            this.f3028a.m3908k();
            C3641ai.m13211a(this.f3028a.f2288Y, this.f3028a.getResources().getString(R.string.buddy_profile_block_toast_success, this.f3028a.f2302g.m4001b()), 0).show();
            this.f3028a.f2288Y.finish();
        }
    }
}
