package com.sec.chaton.specialbuddy;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import com.sec.chaton.TabActivity;

/* compiled from: AbstractChatONLiveFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.c */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC4538c implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ AbstractChatONLiveFragment f16398a;

    DialogInterfaceOnKeyListenerC4538c(AbstractChatONLiveFragment abstractChatONLiveFragment) {
        this.f16398a = abstractChatONLiveFragment;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        dialogInterface.dismiss();
        FragmentActivity activity = this.f16398a.getActivity();
        if (activity != null && !(activity instanceof TabActivity)) {
            activity.finish();
        }
        return true;
    }
}
