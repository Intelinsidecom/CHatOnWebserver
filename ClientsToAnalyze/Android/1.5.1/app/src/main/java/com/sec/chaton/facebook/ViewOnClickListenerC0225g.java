package com.sec.chaton.facebook;

import android.view.View;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.facebook.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC0225g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookMenuActivity f1856a;

    ViewOnClickListenerC0225g(FacebookMenuActivity facebookMenuActivity) {
        this.f1856a = facebookMenuActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.facebook_menu_invitation_card /* 2131427805 */:
                this.f1856a.m2359a(0, this.f1856a.f1843e[(int) (Math.random() * this.f1856a.f1843e.length)], this.f1856a.getString(C0062R.string.facebook_invitation_card));
                break;
            case C0062R.id.facebook_menu_logout /* 2131427807 */:
                this.f1856a.m2357a();
                break;
        }
    }
}
