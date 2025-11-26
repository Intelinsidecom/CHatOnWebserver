package com.sec.chaton.settings;

import android.view.View;

/* compiled from: FragmentChatView2.java */
/* renamed from: com.sec.chaton.settings.br */
/* loaded from: classes.dex */
class ViewOnClickListenerC1266br implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentChatView2 f4807a;

    ViewOnClickListenerC1266br(FragmentChatView2 fragmentChatView2) {
        this.f4807a = fragmentChatView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4807a.getActivity().finish();
    }
}
