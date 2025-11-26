package com.sec.chaton.buddy;

import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.widget.C5179v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cn */
/* loaded from: classes.dex */
class C1177cn implements InterfaceC2243d {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4404a;

    C1177cn(BuddyFragment buddyFragment) {
        this.f4404a = buddyFragment;
    }

    @Override // com.sec.chaton.p057e.p059b.InterfaceC2243d
    /* renamed from: a */
    public void mo7130a(int i, boolean z, Object obj) {
        if (this.f4404a.getActivity() != null && z && i == 2 && (obj instanceof C1106c)) {
            C5179v.m19811a(this.f4404a.getActivity(), this.f4404a.getResources().getString(R.string.buddy_profile_block_toast_success, ((C1106c) obj).m7051b()), 0).show();
            this.f4404a.m6574x();
        }
    }
}
