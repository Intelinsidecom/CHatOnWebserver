package com.sec.chaton.buddy;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bq */
/* loaded from: classes.dex */
class C1153bq implements InterfaceC1257dr {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4372a;

    C1153bq(BuddyFragment buddyFragment) {
        this.f4372a = buddyFragment;
    }

    @Override // com.sec.chaton.buddy.InterfaceC1257dr
    /* renamed from: a */
    public void mo7134a(boolean z) {
        int iM6605h = this.f4372a.m6605h();
        boolean zM6435aq = this.f4372a.m6435aq();
        if (iM6605h <= 0) {
            this.f4372a.f3674bC.setEnabled(false);
            return;
        }
        if (!zM6435aq || this.f4372a.f3660ao == 5 || this.f4372a.f3695bZ) {
            this.f4372a.f3674bC.setEnabled(true);
        } else {
            this.f4372a.f3674bC.setEnabled(false);
        }
        if (this.f4372a.f3660ao == 1000) {
            this.f4372a.f3674bC.setEnabled(true);
        }
    }
}
