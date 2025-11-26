package com.sec.chaton.buddy;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bt */
/* loaded from: classes.dex */
class C1156bt implements InterfaceC1261dv {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4375a;

    C1156bt(BuddyFragment buddyFragment) {
        this.f4375a = buddyFragment;
    }

    @Override // com.sec.chaton.buddy.InterfaceC1261dv
    /* renamed from: a */
    public void mo6198a(int i) {
        this.f4375a.m6581a(this.f4375a.f3602I.m19638a());
        if (this.f4375a.f3660ao == 8) {
            this.f4375a.m6331Y();
            this.f4375a.m6329X();
            if (this.f4375a.f3704bi != null && this.f4375a.f3704bi.length() > 0) {
                this.f4375a.f3677bF.requestFocus();
                this.f4375a.f3677bF.setText(this.f4375a.f3704bi);
                this.f4375a.f3677bF.setSelection(this.f4375a.f3677bF.m18658a().length());
                this.f4375a.f3704bi = null;
            }
        } else {
            this.f4375a.m6329X();
        }
        if (this.f4375a.f3616W.getVisibility() == 0) {
            if (this.f4375a.m6334Z()) {
                this.f4375a.f3616W.setChecked(false);
            } else {
                this.f4375a.f3616W.setChecked(true);
            }
        }
    }

    @Override // com.sec.chaton.buddy.InterfaceC1261dv
    /* renamed from: b */
    public void mo6199b(int i) {
    }
}
