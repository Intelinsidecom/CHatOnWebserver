package com.sec.chaton.facebook;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1739av;

/* compiled from: FacebookMenuActivity.java */
/* renamed from: com.sec.chaton.facebook.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC0740u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookMenuActivity f2737a;

    ViewOnClickListenerC0740u(FacebookMenuActivity facebookMenuActivity) {
        this.f2737a = facebookMenuActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1739av.m5927a()) {
            switch (view.getId()) {
                case R.id.facebook_menu_invitation_card /* 2131493587 */:
                    this.f2737a.startActivity(new Intent(this.f2737a, (Class<?>) FacebookInvitationCardSelectActivity.class));
                    break;
                case R.id.facebook_menu_logout /* 2131493589 */:
                    this.f2737a.m3198a();
                    break;
            }
        }
    }
}
