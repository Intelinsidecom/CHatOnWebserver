package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* renamed from: com.sec.chaton.userprofile.af */
/* loaded from: classes.dex */
class ViewOnClickListenerC0552af implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f3531a;

    ViewOnClickListenerC0552af(UserProfileDetail userProfileDetail) {
        this.f3531a = userProfileDetail;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f3531a.f3412f, (Class<?>) PhoneNumberPrivacyActivity.class);
        intent.putExtra("extra_phone_number", "+" + this.f3531a.f3392J);
        this.f3531a.startActivity(intent);
    }
}
