package com.sec.chaton.specialbuddy;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

/* compiled from: AbstractChatONLiveFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.c */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC2922c implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ AbstractChatONLiveFragment f10452a;

    DialogInterfaceOnKeyListenerC2922c(AbstractChatONLiveFragment abstractChatONLiveFragment) {
        this.f10452a = abstractChatONLiveFragment;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        dialogInterface.dismiss();
        FragmentActivity activity = this.f10452a.getActivity();
        if (activity != null) {
            activity.finish();
        }
        return true;
    }
}
