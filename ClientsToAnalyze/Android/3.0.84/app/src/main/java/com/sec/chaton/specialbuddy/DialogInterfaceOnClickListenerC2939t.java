package com.sec.chaton.specialbuddy;

import android.content.DialogInterface;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.t */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2939t implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f10475a;

    DialogInterfaceOnClickListenerC2939t(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f10475a = specialBuddyChatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
