package com.sec.chaton.shop;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;

/* compiled from: AbstractChatONShopFragment.java */
/* renamed from: com.sec.chaton.shop.b */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3729b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AbstractChatONShopFragment f13408a;

    DialogInterfaceOnClickListenerC3729b(AbstractChatONShopFragment abstractChatONShopFragment) {
        this.f13408a = abstractChatONShopFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        FragmentActivity activity = this.f13408a.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
