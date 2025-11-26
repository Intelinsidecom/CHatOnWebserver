package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.ag */
/* loaded from: classes.dex */
class ViewOnClickListenerC1210ag implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f4287a;

    ViewOnClickListenerC1210ag(UserProfileDetail userProfileDetail) {
        this.f4287a = userProfileDetail;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4287a.startActivity(new Intent(this.f4287a.f4223E, (Class<?>) BirthdayActivity.class));
    }
}
