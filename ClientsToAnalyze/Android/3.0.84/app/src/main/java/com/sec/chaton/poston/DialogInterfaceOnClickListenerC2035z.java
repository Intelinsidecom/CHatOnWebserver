package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.z */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2035z implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2034y f7824a;

    DialogInterfaceOnClickListenerC2035z(HandlerC2034y handlerC2034y) {
        this.f7824a = handlerC2034y;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f7824a.f7823a.getActivity().finish();
    }
}
