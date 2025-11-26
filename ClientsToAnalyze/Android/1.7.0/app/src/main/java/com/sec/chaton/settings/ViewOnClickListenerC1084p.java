package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.util.C1323bs;

/* compiled from: FragmentChatView.java */
/* renamed from: com.sec.chaton.settings.p */
/* loaded from: classes.dex */
class ViewOnClickListenerC1084p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentChatView f3728a;

    ViewOnClickListenerC1084p(FragmentChatView fragmentChatView) {
        this.f3728a = fragmentChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1323bs.m4575a().edit().putString("Default Font Size", this.f3728a.f3483b).commit();
        this.f3728a.getActivity().finish();
    }
}
