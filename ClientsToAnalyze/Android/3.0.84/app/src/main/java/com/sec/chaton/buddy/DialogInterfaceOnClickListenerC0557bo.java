package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bo */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0557bo implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2516a;

    DialogInterfaceOnClickListenerC0557bo(BuddyFragment buddyFragment) {
        this.f2516a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2516a.f1808at.dismiss();
    }
}
