package com.sec.chaton.specialbuddy;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;

/* compiled from: AbstractChatONLiveFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.b */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2921b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AbstractChatONLiveFragment f10451a;

    DialogInterfaceOnClickListenerC2921b(AbstractChatONLiveFragment abstractChatONLiveFragment) {
        this.f10451a = abstractChatONLiveFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        FragmentActivity activity = this.f10451a.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
