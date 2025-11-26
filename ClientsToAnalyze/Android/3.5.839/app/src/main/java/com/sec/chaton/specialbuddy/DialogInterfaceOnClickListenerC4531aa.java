package com.sec.chaton.specialbuddy;

import android.content.DialogInterface;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.aa */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4531aa implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f16392a;

    DialogInterfaceOnClickListenerC4531aa(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f16392a = specialBuddyChatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
