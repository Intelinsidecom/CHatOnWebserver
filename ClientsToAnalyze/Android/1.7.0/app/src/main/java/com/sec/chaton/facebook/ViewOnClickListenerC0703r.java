package com.sec.chaton.facebook;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C1341p;

/* compiled from: FacebookInvitationCardSelectActivity.java */
/* renamed from: com.sec.chaton.facebook.r */
/* loaded from: classes.dex */
class ViewOnClickListenerC0703r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookInvitationCardSelectActivity f2387a;

    ViewOnClickListenerC0703r(FacebookInvitationCardSelectActivity facebookInvitationCardSelectActivity) {
        this.f2387a = facebookInvitationCardSelectActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1341p.m4660c("Invitation Card " + this.f2387a.f2347c.getCheckedItemPosition(), getClass().getSimpleName());
        Intent intent = new Intent(this.f2387a, (Class<?>) FacebookInvitationCardWriteActivity.class);
        intent.putExtra("invitationCardResId", FacebookInvitationCardSelectActivity.f2345a[this.f2387a.f2347c.getCheckedItemPosition()]);
        this.f2387a.startActivity(intent);
        this.f2387a.finish();
    }
}
