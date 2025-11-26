package com.sec.chaton.buddy;

import com.sec.chaton.R;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.p025d.p027b.InterfaceC0641d;
import com.sec.widget.C1619g;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.k */
/* loaded from: classes.dex */
class C0446k implements InterfaceC0641d {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1439a;

    C0446k(BuddyFragment buddyFragment) {
        this.f1439a = buddyFragment;
    }

    @Override // com.sec.chaton.p025d.p027b.InterfaceC0641d
    /* renamed from: a */
    public void mo2364a(int i, boolean z, Object obj) {
        if (this.f1439a.getActivity() != null && z && i == 2 && (obj instanceof C0363a)) {
            C1619g.m5889a(this.f1439a.f1153k, this.f1439a.getResources().getString(R.string.buddy_profile_block_toast_success, ((C0363a) obj).m2314b()), 0).show();
            this.f1439a.m2169o();
        }
    }
}
