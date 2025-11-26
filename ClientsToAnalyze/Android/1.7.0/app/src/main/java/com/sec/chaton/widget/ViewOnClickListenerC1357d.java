package com.sec.chaton.widget;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* compiled from: ProfileImageView.java */
/* renamed from: com.sec.chaton.widget.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC1357d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageView f4616a;

    ViewOnClickListenerC1357d(ProfileImageView profileImageView) {
        this.f4616a = profileImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f4616a.f4610d)) {
            Intent intent = new Intent(this.f4616a.f4609c, (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", this.f4616a.f4610d);
            intent.putExtra("PROFILE_BUDDY_NAME", this.f4616a.f4611e);
            this.f4616a.f4609c.startActivity(intent);
        }
    }
}
