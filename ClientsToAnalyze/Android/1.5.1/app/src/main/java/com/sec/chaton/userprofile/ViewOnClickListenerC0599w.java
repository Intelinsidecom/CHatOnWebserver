package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* renamed from: com.sec.chaton.userprofile.w */
/* loaded from: classes.dex */
class ViewOnClickListenerC0599w implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileFragment f3600a;

    ViewOnClickListenerC0599w(UserProfileFragment userProfileFragment) {
        this.f3600a = userProfileFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3600a.f3449P = true;
        this.f3600a.f3440G.setSelected(true);
        this.f3600a.startActivity(new Intent(this.f3600a.getActivity(), (Class<?>) RelationshipRank2.class));
    }
}
