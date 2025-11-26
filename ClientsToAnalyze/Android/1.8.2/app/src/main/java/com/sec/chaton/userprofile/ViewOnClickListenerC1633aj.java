package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* compiled from: MyPageInteraction.java */
/* renamed from: com.sec.chaton.userprofile.aj */
/* loaded from: classes.dex */
class ViewOnClickListenerC1633aj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageInteraction f6120a;

    ViewOnClickListenerC1633aj(MyPageInteraction myPageInteraction) {
        this.f6120a = myPageInteraction;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f6120a.getActivity(), (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", this.f6120a.f5921q);
        intent.putExtra("PROFILE_BUDDY_NAME", this.f6120a.f5922r);
        this.f6120a.startActivity(intent);
    }
}
