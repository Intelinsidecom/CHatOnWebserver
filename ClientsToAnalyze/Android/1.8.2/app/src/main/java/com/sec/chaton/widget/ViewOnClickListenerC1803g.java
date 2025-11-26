package com.sec.chaton.widget;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* compiled from: ProfileImageView.java */
/* renamed from: com.sec.chaton.widget.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC1803g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageView f6495a;

    ViewOnClickListenerC1803g(ProfileImageView profileImageView) {
        this.f6495a = profileImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f6495a.f6479d)) {
            Intent intent = new Intent(this.f6495a.f6478c, (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", this.f6495a.f6479d);
            intent.putExtra("PROFILE_BUDDY_NAME", this.f6495a.f6480e);
            this.f6495a.f6478c.startActivity(intent);
        }
    }
}
