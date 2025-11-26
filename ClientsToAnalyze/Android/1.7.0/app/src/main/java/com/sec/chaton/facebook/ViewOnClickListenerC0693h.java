package com.sec.chaton.facebook;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1346u;

/* compiled from: FacebookMenuActivity.java */
/* renamed from: com.sec.chaton.facebook.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC0693h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookMenuActivity f2366a;

    ViewOnClickListenerC0693h(FacebookMenuActivity facebookMenuActivity) {
        this.f2366a = facebookMenuActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1346u.m4676a()) {
            switch (view.getId()) {
                case R.id.facebook_menu_logout /* 2131427885 */:
                    this.f2366a.m3060a();
                    break;
                case R.id.facebook_menu_invitation_card /* 2131427886 */:
                    this.f2366a.startActivity(new Intent(this.f2366a, (Class<?>) FacebookInvitationCardSelectActivity.class));
                    break;
            }
        }
    }
}
