package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.ex */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1290ex implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f4823a;

    /* renamed from: b */
    final /* synthetic */ BuddyInfoFragment f4824b;

    DialogInterfaceOnClickListenerC1290ex(BuddyInfoFragment buddyInfoFragment, String str) {
        this.f4824b = buddyInfoFragment;
        this.f4823a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new AsyncTaskC1303fj(this.f4824b).execute(this.f4823a);
        dialogInterface.dismiss();
    }
}
