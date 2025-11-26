package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.s */
/* loaded from: classes.dex */
class ViewOnClickListenerC1709s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f6222a;

    ViewOnClickListenerC1709s(MyPageFragment myPageFragment) {
        this.f6222a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6222a.f5815C = true;
        this.f6222a.startActivity(new Intent(this.f6222a.getActivity(), (Class<?>) RelationshipRank2.class));
    }
}
