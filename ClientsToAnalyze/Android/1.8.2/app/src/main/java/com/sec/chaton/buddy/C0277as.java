package com.sec.chaton.buddy;

import android.content.Intent;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.as */
/* loaded from: classes.dex */
class C0277as implements InterfaceC0677d {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1372a;

    C0277as(BuddyFragment buddyFragment) {
        this.f1372a = buddyFragment;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0677d
    /* renamed from: a */
    public void mo2365a(int i, boolean z, Object obj) {
        if (this.f1372a.getActivity() != null && z) {
            if (i == 2) {
                this.f1372a.getActivity().finish();
            } else if (i == 10) {
                Intent intent = new Intent();
                intent.putExtra("ACTIVITY_PURPOSE_ARG", String.valueOf(obj));
                this.f1372a.getActivity().setResult(-1, intent);
                this.f1372a.getActivity().finish();
            }
        }
    }
}
