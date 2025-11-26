package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings2.PrefFragmentBirthday;
import com.sec.chaton.settings2.SettingActivity;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.ac */
/* loaded from: classes.dex */
class ViewOnClickListenerC3077ac implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f11289a;

    ViewOnClickListenerC3077ac(MyInfoFragment myInfoFragment) {
        this.f11289a = myInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent(this.f11289a.getActivity(), (Class<?>) SettingActivity.class);
            intent.putExtra("fragment_choose", PrefFragmentBirthday.class.getName());
            this.f11289a.startActivity(intent);
        } else {
            this.f11289a.startActivity(new Intent(this.f11289a.getActivity(), (Class<?>) BirthdayActivity.class));
        }
    }
}
