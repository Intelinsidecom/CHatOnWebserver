package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.t */
/* loaded from: classes.dex */
class ViewOnClickListenerC1710t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f6223a;

    ViewOnClickListenerC1710t(MyPageFragment myPageFragment) {
        this.f6223a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6223a.f5815C = true;
        this.f6223a.startActivity(new Intent(this.f6223a.getActivity(), (Class<?>) UserProfileDetail.class));
    }
}
