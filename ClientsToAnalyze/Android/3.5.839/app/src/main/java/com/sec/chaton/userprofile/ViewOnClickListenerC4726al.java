package com.sec.chaton.userprofile;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C4847bl;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.al */
/* loaded from: classes.dex */
class ViewOnClickListenerC4726al implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f17390a;

    ViewOnClickListenerC4726al(MyPageFragment myPageFragment) {
        this.f17390a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            if (!this.f17390a.f17243al.exists()) {
                this.f17390a.f17243al.mkdirs();
            }
            AbstractC4932a.m18733a(this.f17390a.getActivity()).mo18734a(R.string.mypage_profile_add_photo).mo18749b(CommonApplication.m18732r().getResources().getString(R.string.mypage_add_photo_warning)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4727am(this)).mo18752b();
        }
    }
}
