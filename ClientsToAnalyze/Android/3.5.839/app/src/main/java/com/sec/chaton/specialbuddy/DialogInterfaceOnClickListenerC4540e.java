package com.sec.chaton.specialbuddy;

import android.content.DialogInterface;

/* compiled from: AbstractChatONLiveFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4540e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AbstractChatONLiveFragment f16400a;

    DialogInterfaceOnClickListenerC4540e(AbstractChatONLiveFragment abstractChatONLiveFragment) {
        this.f16400a = abstractChatONLiveFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
