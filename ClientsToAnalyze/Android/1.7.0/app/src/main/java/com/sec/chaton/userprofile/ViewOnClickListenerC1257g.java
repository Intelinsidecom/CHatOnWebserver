package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC1257g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4354a;

    ViewOnClickListenerC1257g(MyPageFragment myPageFragment) {
        this.f4354a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4354a.f4113K = true;
        this.f4354a.startActivity(new Intent(this.f4354a.getActivity(), (Class<?>) ProfileRegistStatusMessage.class));
    }
}
