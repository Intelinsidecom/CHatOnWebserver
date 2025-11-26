package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.ab */
/* loaded from: classes.dex */
class ViewOnClickListenerC1205ab implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f4282a;

    ViewOnClickListenerC1205ab(UserProfileDetail userProfileDetail) {
        this.f4282a = userProfileDetail;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4282a.f4223E, (Class<?>) PhoneNumberPrivacyActivity.class);
        intent.putExtra("extra_phone_number", "+" + this.f4282a.f4219A);
        this.f4282a.startActivity(intent);
    }
}
