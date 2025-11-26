package com.sec.chaton.specialbuddy;

import android.content.DialogInterface;

/* compiled from: AbstractChatONLiveFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.a */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2920a implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AbstractChatONLiveFragment f10450a;

    DialogInterfaceOnCancelListenerC2920a(AbstractChatONLiveFragment abstractChatONLiveFragment) {
        this.f10450a = abstractChatONLiveFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.f10450a.m6966k()) {
            this.f10450a.m6961f().finish();
        }
    }
}
