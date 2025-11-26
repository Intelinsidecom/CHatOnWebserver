package com.sec.chaton.specialbuddy;

import android.content.DialogInterface;

/* compiled from: SpecialBuddyInfo.java */
/* renamed from: com.sec.chaton.specialbuddy.b */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1505b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyInfo f5423a;

    DialogInterfaceOnClickListenerC1505b(SpecialBuddyInfo specialBuddyInfo) {
        this.f5423a = specialBuddyInfo;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
