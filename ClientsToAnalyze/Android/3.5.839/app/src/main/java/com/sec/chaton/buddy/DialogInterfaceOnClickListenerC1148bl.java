package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bl */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1148bl implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4367a;

    DialogInterfaceOnClickListenerC1148bl(BuddyFragment buddyFragment) {
        this.f4367a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4367a.getActivity().finish();
    }
}
