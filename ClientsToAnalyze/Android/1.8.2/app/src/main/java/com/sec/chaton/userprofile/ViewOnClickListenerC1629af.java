package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* compiled from: MyPageInteraction.java */
/* renamed from: com.sec.chaton.userprofile.af */
/* loaded from: classes.dex */
class ViewOnClickListenerC1629af implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageInteraction f6116a;

    ViewOnClickListenerC1629af(MyPageInteraction myPageInteraction) {
        this.f6116a = myPageInteraction;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6116a.startActivity(new Intent(this.f6116a.getActivity(), (Class<?>) MyPageRelationshipRank2.class));
    }
}
