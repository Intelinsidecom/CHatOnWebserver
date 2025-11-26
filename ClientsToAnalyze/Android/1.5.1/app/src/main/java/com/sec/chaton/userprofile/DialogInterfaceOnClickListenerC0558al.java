package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.common.entry.UserProfileEntry;

/* renamed from: com.sec.chaton.userprofile.al */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0558al implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0592p f3537a;

    DialogInterfaceOnClickListenerC0558al(HandlerC0592p handlerC0592p) {
        this.f3537a = handlerC0592p;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        UserProfileEntry userProfileEntry = new UserProfileEntry();
        userProfileEntry.m1967b(this.f3537a.f3589a.f3356b.getText().toString());
        this.f3537a.f3589a.f3361g.m2065a(userProfileEntry, "");
        this.f3537a.f3589a.f3362h.show();
    }
}
