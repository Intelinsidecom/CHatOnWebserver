package com.sec.chaton.specialbuddy;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.w */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2942w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f10478a;

    DialogInterfaceOnClickListenerC2942w(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f10478a = specialBuddyChatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GlobalApplication.m6449a(this.f10478a.m6961f());
    }
}
