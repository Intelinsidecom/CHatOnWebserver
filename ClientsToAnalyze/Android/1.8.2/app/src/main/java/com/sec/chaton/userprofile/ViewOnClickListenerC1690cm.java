package com.sec.chaton.userprofile;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.userprofile.UserProfileImageView;
import com.sec.chaton.util.C1739av;

/* compiled from: UserProfileImageView.java */
/* renamed from: com.sec.chaton.userprofile.cm */
/* loaded from: classes.dex */
class ViewOnClickListenerC1690cm implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileImageView.UserProfileImageViewFragment f6187a;

    ViewOnClickListenerC1690cm(UserProfileImageView.UserProfileImageViewFragment userProfileImageViewFragment) {
        this.f6187a = userProfileImageViewFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1739av.m5927a()) {
            switch (view.getId()) {
                case R.id.profile_ok /* 2131493729 */:
                    this.f6187a.m5794a();
                    break;
                case R.id.profile_cancel /* 2131493730 */:
                    this.f6187a.getActivity().finish();
                    break;
            }
        }
    }
}
