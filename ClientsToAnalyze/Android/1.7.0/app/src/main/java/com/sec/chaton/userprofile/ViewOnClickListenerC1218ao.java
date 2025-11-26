package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.facebook.FacebookMenuActivity;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.ao */
/* loaded from: classes.dex */
class ViewOnClickListenerC1218ao implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f4295a;

    ViewOnClickListenerC1218ao(UserProfileDetail userProfileDetail) {
        this.f4295a = userProfileDetail;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4295a.f4257z.m3085b()) {
            this.f4295a.startActivity(new Intent(this.f4295a, (Class<?>) FacebookMenuActivity.class));
        } else {
            this.f4295a.showDialog(0);
            this.f4295a.f4257z.m3081a(0);
        }
    }
}
