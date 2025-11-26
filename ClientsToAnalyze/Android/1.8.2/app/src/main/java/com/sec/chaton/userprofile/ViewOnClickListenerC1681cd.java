package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.facebook.FacebookMenuActivity;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.cd */
/* loaded from: classes.dex */
class ViewOnClickListenerC1681cd implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f6178a;

    ViewOnClickListenerC1681cd(UserProfileDetail userProfileDetail) {
        this.f6178a = userProfileDetail;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f6178a.f6023F.m3224c()) {
            this.f6178a.startActivity(new Intent(this.f6178a, (Class<?>) FacebookMenuActivity.class));
        } else {
            this.f6178a.showDialog(0);
            this.f6178a.f6023F.m3217a(0);
        }
    }
}
