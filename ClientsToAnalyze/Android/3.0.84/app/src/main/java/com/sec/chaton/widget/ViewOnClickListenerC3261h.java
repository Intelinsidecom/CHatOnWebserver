package com.sec.chaton.widget;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* compiled from: ProfileImageView.java */
/* renamed from: com.sec.chaton.widget.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC3261h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageView f11782a;

    ViewOnClickListenerC3261h(ProfileImageView profileImageView) {
        this.f11782a = profileImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f11782a.f11760d)) {
            Intent intent = new Intent(this.f11782a.f11759c, (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", this.f11782a.f11760d);
            intent.putExtra("PROFILE_BUDDY_NAME", this.f11782a.f11761e);
            this.f11782a.f11759c.startActivity(intent);
        }
    }
}
