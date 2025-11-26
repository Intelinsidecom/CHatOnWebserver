package com.sec.chaton.widget;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* renamed from: com.sec.chaton.widget.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0621b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageView f3804a;

    ViewOnClickListenerC0621b(ProfileImageView profileImageView) {
        this.f3804a = profileImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f3804a.f3797c, (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", this.f3804a.f3798d);
        intent.putExtra("PROFILE_BUDDY_NAME", this.f3804a.f3799e);
        this.f3804a.f3797c.startActivity(intent);
    }
}
