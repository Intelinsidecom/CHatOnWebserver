package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC1259i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4356a;

    ViewOnClickListenerC1259i(MyPageFragment myPageFragment) {
        this.f4356a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4356a.f4113K = true;
        this.f4356a.startActivity(new Intent(this.f4356a.getActivity(), (Class<?>) UserProfileDetail.class));
    }
}
