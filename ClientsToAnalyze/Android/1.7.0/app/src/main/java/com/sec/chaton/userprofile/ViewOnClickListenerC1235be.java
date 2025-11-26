package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.be */
/* loaded from: classes.dex */
class ViewOnClickListenerC1235be implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4317a;

    ViewOnClickListenerC1235be(MyPageFragment myPageFragment) {
        this.f4317a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4317a.startActivity(new Intent(this.f4317a.getActivity(), (Class<?>) BirthdayActivity.class));
    }
}
