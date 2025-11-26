package com.sec.chaton.settings;

import android.view.View;

/* compiled from: FragmentChatView.java */
/* renamed from: com.sec.chaton.settings.bq */
/* loaded from: classes.dex */
class ViewOnClickListenerC1265bq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentChatView f4806a;

    ViewOnClickListenerC1265bq(FragmentChatView fragmentChatView) {
        this.f4806a = fragmentChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4806a.getActivity().finish();
    }
}
