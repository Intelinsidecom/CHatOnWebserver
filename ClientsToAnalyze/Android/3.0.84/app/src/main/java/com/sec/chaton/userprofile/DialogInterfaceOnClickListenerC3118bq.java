package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.bq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3118bq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3117bp f11351a;

    DialogInterfaceOnClickListenerC3118bq(HandlerC3117bp handlerC3117bp) {
        this.f11351a = handlerC3117bp;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.f11351a.f11350a.getActivity().finish();
    }
}
