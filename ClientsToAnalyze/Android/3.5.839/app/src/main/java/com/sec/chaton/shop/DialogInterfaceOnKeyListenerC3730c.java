package com.sec.chaton.shop;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

/* compiled from: AbstractChatONShopFragment.java */
/* renamed from: com.sec.chaton.shop.c */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC3730c implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ AbstractChatONShopFragment f13409a;

    DialogInterfaceOnKeyListenerC3730c(AbstractChatONShopFragment abstractChatONShopFragment) {
        this.f13409a = abstractChatONShopFragment;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4) {
            dialogInterface.dismiss();
            FragmentActivity activity = this.f13409a.getActivity();
            if (activity != null) {
                activity.finish();
            }
            return true;
        }
        return false;
    }
}
