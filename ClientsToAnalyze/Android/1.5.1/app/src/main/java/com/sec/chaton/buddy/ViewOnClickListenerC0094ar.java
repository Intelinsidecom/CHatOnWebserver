package com.sec.chaton.buddy;

import android.view.View;

/* renamed from: com.sec.chaton.buddy.ar */
/* loaded from: classes.dex */
class ViewOnClickListenerC0094ar implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupActivity f635a;

    ViewOnClickListenerC0094ar(BuddyGroupActivity buddyGroupActivity) {
        this.f635a = buddyGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strReplace = this.f635a.f482c.getText().toString().trim().replace(",", "");
        this.f635a.f482c.setText(strReplace);
        if (strReplace.length() > 0) {
            this.f635a.m539a(strReplace);
        }
    }
}
