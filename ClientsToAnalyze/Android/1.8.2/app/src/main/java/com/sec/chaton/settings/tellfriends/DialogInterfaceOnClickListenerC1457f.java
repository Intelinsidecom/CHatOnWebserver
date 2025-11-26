package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: FacebookSubMenuActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1457f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookSubMenuActivity f5364a;

    DialogInterfaceOnClickListenerC1457f(FacebookSubMenuActivity facebookSubMenuActivity) {
        this.f5364a = facebookSubMenuActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5364a.finish();
    }
}
