package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* renamed from: com.sec.chaton.userprofile.z */
/* loaded from: classes.dex */
class ViewOnClickListenerC0602z implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileFragment f3604a;

    ViewOnClickListenerC0602z(UserProfileFragment userProfileFragment) {
        this.f3604a = userProfileFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3604a.f3449P = true;
        this.f3604a.f3439F.setSelected(true);
        this.f3604a.startActivity(new Intent(this.f3604a.getActivity(), (Class<?>) UserProfileDetail.class));
    }
}
