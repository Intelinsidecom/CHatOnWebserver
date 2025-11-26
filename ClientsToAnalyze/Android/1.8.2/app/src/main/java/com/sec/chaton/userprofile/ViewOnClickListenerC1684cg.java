package com.sec.chaton.userprofile;

import android.view.View;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.cg */
/* loaded from: classes.dex */
class ViewOnClickListenerC1684cg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f6181a;

    ViewOnClickListenerC1684cg(UserProfileDetail userProfileDetail) {
        this.f6181a = userProfileDetail;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws NumberFormatException {
        this.f6181a.f6021D.addTextChangedListener(this.f6181a.f6050ag);
        this.f6181a.m5746j();
    }
}
