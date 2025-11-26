package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyGroupActivity.java */
/* renamed from: com.sec.chaton.buddy.bp */
/* loaded from: classes.dex */
class ViewOnClickListenerC0304bp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupActivity f1415a;

    ViewOnClickListenerC0304bp(BuddyGroupActivity buddyGroupActivity) {
        this.f1415a = buddyGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strReplace = this.f1415a.f1027c.getText().toString().trim().replace(",", "");
        this.f1415a.f1027c.setText(strReplace);
        if (strReplace.length() > 0) {
            this.f1415a.m2063a(strReplace);
        }
    }
}
