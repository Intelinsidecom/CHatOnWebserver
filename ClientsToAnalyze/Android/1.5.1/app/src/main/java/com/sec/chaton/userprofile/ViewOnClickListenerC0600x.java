package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* renamed from: com.sec.chaton.userprofile.x */
/* loaded from: classes.dex */
class ViewOnClickListenerC0600x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileFragment f3601a;

    ViewOnClickListenerC0600x(UserProfileFragment userProfileFragment) {
        this.f3601a = userProfileFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3601a.f3449P = true;
        this.f3601a.f3439F.setSelected(true);
        this.f3601a.startActivity(new Intent(this.f3601a.getActivity(), (Class<?>) UserProfileDetail.class));
    }
}
