package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* renamed from: com.sec.chaton.userprofile.ag */
/* loaded from: classes.dex */
class ViewOnClickListenerC0553ag implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f3532a;

    ViewOnClickListenerC0553ag(UserProfileDetail userProfileDetail) {
        this.f3532a = userProfileDetail;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3532a.startActivity(new Intent(this.f3532a.f3412f, (Class<?>) BirthdayActivity.class));
    }
}
