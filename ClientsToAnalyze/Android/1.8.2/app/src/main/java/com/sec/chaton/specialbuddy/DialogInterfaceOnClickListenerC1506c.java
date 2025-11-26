package com.sec.chaton.specialbuddy;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: SpecialBuddyInfo.java */
/* renamed from: com.sec.chaton.specialbuddy.c */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1506c implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyInfo f5424a;

    DialogInterfaceOnClickListenerC1506c(SpecialBuddyInfo specialBuddyInfo) {
        this.f5424a = specialBuddyInfo;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = this.f5424a.getIntent();
        intent.putExtra("isClosing", true);
        intent.putExtra("inboxNO", this.f5424a.f5413m);
        this.f5424a.setResult(-1, intent);
        this.f5424a.finish();
    }
}
