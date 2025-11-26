package com.sec.chaton.widget;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* compiled from: ProfileImageView.java */
/* renamed from: com.sec.chaton.widget.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC4921n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageView f17979a;

    ViewOnClickListenerC4921n(ProfileImageView profileImageView) {
        this.f17979a = profileImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f17979a.f17923d)) {
            Intent intent = new Intent(this.f17979a.f17922c, (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", this.f17979a.f17923d);
            intent.putExtra("PROFILE_BUDDY_NAME", this.f17979a.f17924e);
            this.f17979a.f17922c.startActivity(intent);
        }
    }
}
