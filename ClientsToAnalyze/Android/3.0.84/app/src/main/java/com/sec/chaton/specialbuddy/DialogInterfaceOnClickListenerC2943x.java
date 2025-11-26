package com.sec.chaton.specialbuddy;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.x */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2943x implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f10479a;

    DialogInterfaceOnClickListenerC2943x(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f10479a = specialBuddyChatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GlobalApplication.m6454c(this.f10479a.m6961f());
    }
}
