package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.common.entry.UserProfileEntry;

/* renamed from: com.sec.chaton.userprofile.i */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0585i implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0560an f3567a;

    DialogInterfaceOnClickListenerC0585i(HandlerC0560an handlerC0560an) {
        this.f3567a = handlerC0560an;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        UserProfileEntry userProfileEntry = new UserProfileEntry();
        userProfileEntry.m1965a(this.f3567a.f3539a.f3346b.getText().toString());
        this.f3567a.f3539a.f3351g.m2065a(userProfileEntry, "");
        this.f3567a.f3539a.f3352h.show();
    }
}
