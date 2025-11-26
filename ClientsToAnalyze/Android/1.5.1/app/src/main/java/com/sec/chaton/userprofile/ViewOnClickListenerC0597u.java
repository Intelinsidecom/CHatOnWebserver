package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* renamed from: com.sec.chaton.userprofile.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC0597u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileFragment f3598a;

    ViewOnClickListenerC0597u(UserProfileFragment userProfileFragment) {
        this.f3598a = userProfileFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3598a.f3449P = true;
        this.f3598a.startActivity(new Intent(this.f3598a.getActivity(), (Class<?>) ProfileRegistStatusMessage.class));
    }
}
