package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bm */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1149bm implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4368a;

    DialogInterfaceOnClickListenerC1149bm(BuddyFragment buddyFragment) {
        this.f4368a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4368a.getActivity().finish();
    }
}
