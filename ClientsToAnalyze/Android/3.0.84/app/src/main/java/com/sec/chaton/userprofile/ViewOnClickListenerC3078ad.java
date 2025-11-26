package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPrivacy;
import com.sec.chaton.settings2.PrefFragmentPrivacy;
import com.sec.chaton.settings2.SettingActivity;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.ad */
/* loaded from: classes.dex */
class ViewOnClickListenerC3078ad implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f11290a;

    ViewOnClickListenerC3078ad(MyInfoFragment myInfoFragment) {
        this.f11290a = myInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent(this.f11290a.getActivity(), (Class<?>) SettingActivity.class);
            intent.putExtra("fragment_choose", PrefFragmentPrivacy.class.getName());
            this.f11290a.startActivity(intent);
        } else {
            this.f11290a.startActivity(new Intent(this.f11290a.getActivity(), (Class<?>) ActivityPrivacy.class));
        }
    }
}
