package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bk */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0553bk implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2512a;

    DialogInterfaceOnClickListenerC0553bk(BuddyFragment buddyFragment) {
        this.f2512a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2512a.getActivity().finish();
    }
}
