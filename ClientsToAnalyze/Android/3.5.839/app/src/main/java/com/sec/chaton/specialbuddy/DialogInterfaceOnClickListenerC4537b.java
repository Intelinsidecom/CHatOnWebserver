package com.sec.chaton.specialbuddy;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import com.sec.chaton.TabActivity;

/* compiled from: AbstractChatONLiveFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.b */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4537b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AbstractChatONLiveFragment f16397a;

    DialogInterfaceOnClickListenerC4537b(AbstractChatONLiveFragment abstractChatONLiveFragment) {
        this.f16397a = abstractChatONLiveFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        FragmentActivity activity = this.f16397a.getActivity();
        if (activity != null && !(activity instanceof TabActivity)) {
            activity.finish();
        }
    }
}
