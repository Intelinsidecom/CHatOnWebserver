package com.sec.chaton.buddy;

import com.sec.chaton.R;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.widget.C2153y;

/* compiled from: SpecialBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.ev */
/* loaded from: classes.dex */
class C0391ev implements InterfaceC0677d {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyActivity f1550a;

    C0391ev(SpecialBuddyActivity specialBuddyActivity) {
        this.f1550a = specialBuddyActivity;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0677d
    /* renamed from: a */
    public void mo2365a(int i, boolean z, Object obj) {
        if (!z) {
            this.f1550a.f1253k.dismiss();
        } else if (i == 2) {
            this.f1550a.f1253k.dismiss();
            C2153y.m7536a(this.f1550a.f1254l, this.f1550a.getResources().getString(R.string.buddy_profile_block_toast_success, this.f1550a.f1251i.m2355b()), 0).show();
            this.f1550a.setResult(-1);
            this.f1550a.finish();
        }
    }
}
