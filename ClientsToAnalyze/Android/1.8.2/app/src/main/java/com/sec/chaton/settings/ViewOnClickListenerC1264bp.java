package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.util.C1789u;

/* compiled from: FragmentChatView.java */
/* renamed from: com.sec.chaton.settings.bp */
/* loaded from: classes.dex */
class ViewOnClickListenerC1264bp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentChatView f4805a;

    ViewOnClickListenerC1264bp(FragmentChatView fragmentChatView) {
        this.f4805a = fragmentChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1789u.m6075a().edit().putString("Default Font Size", this.f4805a.f4598b).commit();
        this.f4805a.getActivity().finish();
    }
}
