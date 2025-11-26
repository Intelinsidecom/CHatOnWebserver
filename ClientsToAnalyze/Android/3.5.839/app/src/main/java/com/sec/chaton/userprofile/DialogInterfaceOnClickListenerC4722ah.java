package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.ah */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4722ah implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC4721ag f17386a;

    DialogInterfaceOnClickListenerC4722ah(HandlerC4721ag handlerC4721ag) {
        this.f17386a = handlerC4721ag;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
