package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.hh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1355hh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1353hf f4934a;

    DialogInterfaceOnClickListenerC1355hh(HandlerC1353hf handlerC1353hf) {
        this.f4934a = handlerC1353hf;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4934a.f4932a.getActivity().finish();
    }
}
