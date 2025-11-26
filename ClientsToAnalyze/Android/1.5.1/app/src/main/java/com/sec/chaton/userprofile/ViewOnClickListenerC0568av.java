package com.sec.chaton.userprofile;

import android.view.View;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.userprofile.av */
/* loaded from: classes.dex */
class ViewOnClickListenerC0568av implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileImageView f3548a;

    ViewOnClickListenerC0568av(UserProfileImageView userProfileImageView) {
        this.f3548a = userProfileImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.profile_ok /* 2131427905 */:
                this.f3548a.m3451a();
                break;
            case C0062R.id.profile_cancel /* 2131427906 */:
                this.f3548a.finish();
                break;
        }
    }
}
