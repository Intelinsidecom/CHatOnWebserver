package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;

/* compiled from: SpecialBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.ez */
/* loaded from: classes.dex */
class ViewOnClickListenerC0395ez implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyActivity f1554a;

    ViewOnClickListenerC0395ez(SpecialBuddyActivity specialBuddyActivity) {
        this.f1554a = specialBuddyActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f1554a.f1254l, (Class<?>) ViewProfileImage.class);
        intent.putExtra("PROFILE_BUDDY_NO", this.f1554a.f1251i.m2354a());
        intent.putExtra("PROFILE_BUDDY_BIGIMAGE_STATUS", 1);
        this.f1554a.startActivityForResult(intent, 0);
    }
}
