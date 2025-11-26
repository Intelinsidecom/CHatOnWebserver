package com.sec.chaton.settings;

import android.view.View;

/* compiled from: FragmentChatView.java */
/* renamed from: com.sec.chaton.settings.q */
/* loaded from: classes.dex */
class ViewOnClickListenerC1085q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentChatView f3729a;

    ViewOnClickListenerC1085q(FragmentChatView fragmentChatView) {
        this.f3729a = fragmentChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3729a.getActivity().finish();
    }
}
