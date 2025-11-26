package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.C3250y;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC3079ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f11291a;

    ViewOnClickListenerC3079ae(MyInfoFragment myInfoFragment) {
        this.f11291a = myInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C3250y.m11456e("mypage_register_phone_number", getClass().getSimpleName());
        Intent intent = new Intent(this.f11291a.getActivity(), (Class<?>) ActivityRegist.class);
        intent.putExtra("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC", "ACTIVITY_PURPOSE_CALL_CONTACT_SYNC");
        this.f11291a.startActivity(intent);
    }
}
