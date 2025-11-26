package com.sec.chaton.shop;

import android.content.DialogInterface;

/* compiled from: AbstractChatONShopFragment.java */
/* renamed from: com.sec.chaton.shop.a */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3702a implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AbstractChatONShopFragment f13343a;

    DialogInterfaceOnCancelListenerC3702a(AbstractChatONShopFragment abstractChatONShopFragment) {
        this.f13343a = abstractChatONShopFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.f13343a.isValidActivity()) {
            this.f13343a.stopLoading();
        }
    }
}
