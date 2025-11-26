package com.sec.chaton.buddy;

import com.sec.chaton.p027e.p029b.InterfaceC1413d;

/* compiled from: BuddyGroupMemberEditFragment.java */
/* renamed from: com.sec.chaton.buddy.do */
/* loaded from: classes.dex */
class C0650do implements InterfaceC1413d {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupMemberEditFragment f2870a;

    C0650do(BuddyGroupMemberEditFragment buddyGroupMemberEditFragment) {
        this.f2870a = buddyGroupMemberEditFragment;
    }

    @Override // com.sec.chaton.p027e.p029b.InterfaceC1413d
    /* renamed from: a */
    public void mo4048a(int i, boolean z, Object obj) {
        this.f2870a.m3463c();
        if (z && i == 0) {
            this.f2870a.m3463c();
            this.f2870a.getActivity().setResult(-1);
            this.f2870a.getActivity().finish();
        }
    }
}
