package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* renamed from: com.sec.chaton.userprofile.ad */
/* loaded from: classes.dex */
class ViewOnClickListenerC0550ad implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f3529a;

    ViewOnClickListenerC0550ad(UserProfileDetail userProfileDetail) {
        this.f3529a = userProfileDetail;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3529a.startActivity(new Intent(this.f3529a.f3412f, (Class<?>) ProfileRegistPushName.class));
    }
}
