package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.gs */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0735gs implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0731go f2989a;

    DialogInterfaceOnClickListenerC0735gs(HandlerC0731go handlerC0731go) {
        this.f2989a = handlerC0731go;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2989a.f2985a.getActivity().finish();
    }
}
