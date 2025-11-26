package com.sec.chaton.buddy;

import com.sec.chaton.p057e.p059b.InterfaceC2243d;

/* compiled from: BuddyGroupMemberEditFragment.java */
/* renamed from: com.sec.chaton.buddy.ei */
/* loaded from: classes.dex */
class C1275ei implements InterfaceC2243d {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupMemberEditFragment f4809a;

    C1275ei(BuddyGroupMemberEditFragment buddyGroupMemberEditFragment) {
        this.f4809a = buddyGroupMemberEditFragment;
    }

    @Override // com.sec.chaton.p057e.p059b.InterfaceC2243d
    /* renamed from: a */
    public void mo7130a(int i, boolean z, Object obj) {
        this.f4809a.m6620c();
        if (z && i == 0) {
            this.f4809a.m6620c();
            if (this.f4809a.getActivity() != null) {
                this.f4809a.getActivity().setResult(-1);
                this.f4809a.getActivity().finish();
            }
        }
    }
}
