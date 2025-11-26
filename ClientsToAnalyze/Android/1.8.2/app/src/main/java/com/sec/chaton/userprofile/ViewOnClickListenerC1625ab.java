package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* compiled from: MyPageFragmentTablet.java */
/* renamed from: com.sec.chaton.userprofile.ab */
/* loaded from: classes.dex */
class ViewOnClickListenerC1625ab implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragmentTablet f6111a;

    ViewOnClickListenerC1625ab(MyPageFragmentTablet myPageFragmentTablet) {
        this.f6111a = myPageFragmentTablet;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6111a.f5863B = true;
        this.f6111a.startActivity(new Intent(this.f6111a.getActivity(), (Class<?>) UserProfileDetail.class));
    }
}
