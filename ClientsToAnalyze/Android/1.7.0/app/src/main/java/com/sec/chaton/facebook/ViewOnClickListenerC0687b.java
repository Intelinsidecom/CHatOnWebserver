package com.sec.chaton.facebook;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1346u;

/* compiled from: FacebookInvitationCardWriteActivity.java */
/* renamed from: com.sec.chaton.facebook.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0687b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookInvitationCardWriteActivity f2361a;

    ViewOnClickListenerC0687b(FacebookInvitationCardWriteActivity facebookInvitationCardWriteActivity) {
        this.f2361a = facebookInvitationCardWriteActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1346u.m4676a()) {
            String str = this.f2361a.f2350b.getText().toString() + "\nwww.chaton.com\n\n" + this.f2361a.getString(R.string.logo_is_different_for_canada);
            C1341p.m4660c("Invitation Message " + str, getClass().getSimpleName());
            this.f2361a.f2351c.m3083a(0, this.f2361a.f2352d, str);
        }
    }
}
