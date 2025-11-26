package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.facebook.FacebookMenuActivity;

/* renamed from: com.sec.chaton.userprofile.ai */
/* loaded from: classes.dex */
class ViewOnClickListenerC0555ai implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f3534a;

    ViewOnClickListenerC0555ai(UserProfileDetail userProfileDetail) {
        this.f3534a = userProfileDetail;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f3534a.f3391I.m2356b()) {
            this.f3534a.startActivity(new Intent(this.f3534a, (Class<?>) FacebookMenuActivity.class));
        } else {
            this.f3534a.showDialog(0);
            this.f3534a.f3391I.m2351a(0);
        }
    }
}
