package com.sec.chaton.buddy;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.by */
/* loaded from: classes.dex */
class C0567by implements InterfaceC0598db {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2529a;

    C0567by(BuddyFragment buddyFragment) {
        this.f2529a = buddyFragment;
    }

    @Override // com.sec.chaton.buddy.InterfaceC0598db
    /* renamed from: a */
    public void mo3452a(int i) {
        this.f2529a.m3422a(this.f2529a.f1738B.m13106a());
        if (this.f2529a.f1791ac == 8) {
            this.f2529a.m3312ab();
            this.f2529a.m3309aa();
            if (this.f2529a.f1784aV != null && this.f2529a.f1784aV.length() > 0) {
                this.f2529a.f1858bt.requestFocus();
                this.f2529a.f1858bt.setText(this.f2529a.f1784aV);
                this.f2529a.f1858bt.setSelection(this.f2529a.f1858bt.m11463a().length());
                this.f2529a.f1784aV = null;
            }
        } else {
            this.f2529a.m3309aa();
        }
        if (this.f2529a.f1749M.getVisibility() == 0) {
            if (this.f2529a.m3314ac()) {
                this.f2529a.f1749M.setChecked(false);
            } else {
                this.f2529a.f1749M.setChecked(true);
            }
        }
    }

    @Override // com.sec.chaton.buddy.InterfaceC0598db
    /* renamed from: b */
    public void mo3453b(int i) {
    }
}
