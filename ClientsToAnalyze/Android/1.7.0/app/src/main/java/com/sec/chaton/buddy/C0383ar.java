package com.sec.chaton.buddy;

import com.sec.chaton.p025d.p027b.InterfaceC0641d;

/* compiled from: BuddyGroupMemberEditActivity.java */
/* renamed from: com.sec.chaton.buddy.ar */
/* loaded from: classes.dex */
class C0383ar implements InterfaceC0641d {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupMemberEditActivity f1352a;

    C0383ar(BuddyGroupMemberEditActivity buddyGroupMemberEditActivity) {
        this.f1352a = buddyGroupMemberEditActivity;
    }

    @Override // com.sec.chaton.p025d.p027b.InterfaceC0641d
    /* renamed from: a */
    public void mo2364a(int i, boolean z, Object obj) {
        this.f1352a.m2216d();
        if (z && i == 0) {
            this.f1352a.m2216d();
            this.f1352a.setResult(-1);
            this.f1352a.finish();
        }
    }
}
