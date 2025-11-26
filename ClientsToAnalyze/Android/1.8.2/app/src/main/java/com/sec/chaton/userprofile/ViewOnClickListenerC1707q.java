package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.q */
/* loaded from: classes.dex */
class ViewOnClickListenerC1707q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f6220a;

    ViewOnClickListenerC1707q(MyPageFragment myPageFragment) {
        this.f6220a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6220a.f5815C = true;
        this.f6220a.startActivity(new Intent(this.f6220a.getActivity(), (Class<?>) ProfileRegistStatusMessage.class));
    }
}
