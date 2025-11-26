package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* compiled from: MyPageInteraction.java */
/* renamed from: com.sec.chaton.userprofile.ah */
/* loaded from: classes.dex */
class ViewOnClickListenerC1631ah implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageInteraction f6118a;

    ViewOnClickListenerC1631ah(MyPageInteraction myPageInteraction) {
        this.f6118a = myPageInteraction;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f6118a.getActivity(), (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", this.f6118a.f5917m);
        intent.putExtra("PROFILE_BUDDY_NAME", this.f6118a.f5918n);
        this.f6118a.startActivity(intent);
    }
}
