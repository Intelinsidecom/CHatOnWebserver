package com.sec.chaton.buddy;

import com.sec.chaton.R;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.widget.C3641ai;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cc */
/* loaded from: classes.dex */
class C0572cc implements InterfaceC1413d {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2534a;

    C0572cc(BuddyFragment buddyFragment) {
        this.f2534a = buddyFragment;
    }

    @Override // com.sec.chaton.p027e.p029b.InterfaceC1413d
    /* renamed from: a */
    public void mo4048a(int i, boolean z, Object obj) {
        if (this.f2534a.getActivity() != null && z && i == 2 && (obj instanceof C0513c)) {
            C3641ai.m13211a(this.f2534a.getActivity(), this.f2534a.getResources().getString(R.string.buddy_profile_block_toast_success, ((C0513c) obj).m3976c()), 0).show();
            this.f2534a.m3214A();
        }
    }
}
