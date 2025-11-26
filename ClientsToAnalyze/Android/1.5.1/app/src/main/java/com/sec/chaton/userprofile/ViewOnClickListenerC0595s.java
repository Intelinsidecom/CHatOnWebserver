package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* renamed from: com.sec.chaton.userprofile.s */
/* loaded from: classes.dex */
class ViewOnClickListenerC0595s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f3594a;

    /* renamed from: b */
    final /* synthetic */ String f3595b;

    /* renamed from: c */
    final /* synthetic */ UserProfileFragment f3596c;

    ViewOnClickListenerC0595s(UserProfileFragment userProfileFragment, String str, String str2) {
        this.f3596c = userProfileFragment;
        this.f3594a = str;
        this.f3595b = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3596c.f3449P = true;
        Intent intent = new Intent(this.f3596c.getActivity(), (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", this.f3594a);
        intent.putExtra("PROFILE_BUDDY_NAME", this.f3595b);
        this.f3596c.startActivity(intent);
    }
}
