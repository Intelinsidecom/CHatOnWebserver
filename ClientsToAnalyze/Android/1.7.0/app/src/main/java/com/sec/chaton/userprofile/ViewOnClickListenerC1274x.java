package com.sec.chaton.userprofile;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.userprofile.UserProfileImageView;
import com.sec.chaton.util.C1346u;

/* compiled from: UserProfileImageView.java */
/* renamed from: com.sec.chaton.userprofile.x */
/* loaded from: classes.dex */
class ViewOnClickListenerC1274x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileImageView.UserProfileImageViewFragment f4375a;

    ViewOnClickListenerC1274x(UserProfileImageView.UserProfileImageViewFragment userProfileImageViewFragment) {
        this.f4375a = userProfileImageViewFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1346u.m4676a()) {
            switch (view.getId()) {
                case R.id.profile_ok /* 2131427964 */:
                    this.f4375a.m4414a();
                    break;
                case R.id.profile_cancel /* 2131427965 */:
                    this.f4375a.getActivity().finish();
                    break;
            }
        }
    }
}
