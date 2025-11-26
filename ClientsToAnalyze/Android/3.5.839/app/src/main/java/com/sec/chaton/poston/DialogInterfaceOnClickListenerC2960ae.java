package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ae */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2960ae implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2957ab f11052a;

    DialogInterfaceOnClickListenerC2960ae(HandlerC2957ab handlerC2957ab) {
        this.f11052a = handlerC2957ab;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f11052a.f11049a.getActivity().finish();
    }
}
