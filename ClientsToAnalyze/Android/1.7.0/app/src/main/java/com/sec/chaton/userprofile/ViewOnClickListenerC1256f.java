package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC1256f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4353a;

    ViewOnClickListenerC1256f(MyPageFragment myPageFragment) {
        this.f4353a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4353a.f4113K = true;
        this.f4353a.startActivity(new Intent(this.f4353a.getActivity(), (Class<?>) RelationshipRank2.class));
    }
}
