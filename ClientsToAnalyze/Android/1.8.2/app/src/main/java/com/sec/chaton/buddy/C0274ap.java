package com.sec.chaton.buddy;

import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ap */
/* loaded from: classes.dex */
class C0274ap implements InterfaceC0677d {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1369a;

    C0274ap(BuddyFragment buddyFragment) {
        this.f1369a = buddyFragment;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0677d
    /* renamed from: a */
    public void mo2365a(int i, boolean z, Object obj) {
        if (this.f1369a.getActivity() != null && z && i == 2 && (obj instanceof C0257c)) {
            Toast.makeText(this.f1369a.f1018t, this.f1369a.getResources().getString(R.string.buddy_profile_block_toast_success, ((C0257c) obj).m2324b()), 0).show();
            this.f1369a.m1901B();
        }
    }
}
