package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ah */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2963ah implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2957ab f11055a;

    DialogInterfaceOnClickListenerC2963ah(HandlerC2957ab handlerC2957ab) {
        this.f11055a = handlerC2957ab;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f11055a.f11049a.getActivity().finish();
    }
}
