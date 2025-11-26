package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.ei */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0671ei implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2892a;

    /* renamed from: b */
    final /* synthetic */ BuddyInfoFragment f2893b;

    DialogInterfaceOnClickListenerC0671ei(BuddyInfoFragment buddyInfoFragment, String str) {
        this.f2893b = buddyInfoFragment;
        this.f2892a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new AsyncTaskC0673ek(this.f2893b).execute(this.f2892a);
        dialogInterface.dismiss();
    }
}
