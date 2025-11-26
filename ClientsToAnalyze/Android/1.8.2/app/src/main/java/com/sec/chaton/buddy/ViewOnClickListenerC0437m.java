package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.AddBuddyActivity;
import com.sec.chaton.settings.tellfriends.FacebookSubMenuActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.m */
/* loaded from: classes.dex */
class ViewOnClickListenerC0437m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1653a;

    ViewOnClickListenerC0437m(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1653a = addBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1653a.startActivity(new Intent(this.f1653a.getActivity(), (Class<?>) FacebookSubMenuActivity.class));
    }
}
