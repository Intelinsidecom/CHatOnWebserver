package com.sec.chaton.specialbuddy;

import android.content.DialogInterface;

/* compiled from: AbstractChatONLiveFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.a */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC4524a implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AbstractChatONLiveFragment f16382a;

    DialogInterfaceOnCancelListenerC4524a(AbstractChatONLiveFragment abstractChatONLiveFragment) {
        this.f16382a = abstractChatONLiveFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.f16382a.isValidActivity()) {
            this.f16382a.getAttachedActivity().finish();
        }
    }
}
