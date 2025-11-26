package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bg */
/* loaded from: classes.dex */
class ViewOnClickListenerC1237bg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4319a;

    ViewOnClickListenerC1237bg(MyPageFragment myPageFragment) {
        this.f4319a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4319a.getActivity(), (Class<?>) PhoneNumberPrivacyActivity.class);
        intent.putExtra("extra_phone_number", "+" + this.f4319a.f4110H);
        this.f4319a.startActivity(intent);
    }
}
