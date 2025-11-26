package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* compiled from: MyPageInteraction.java */
/* renamed from: com.sec.chaton.userprofile.ai */
/* loaded from: classes.dex */
class ViewOnClickListenerC1632ai implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageInteraction f6119a;

    ViewOnClickListenerC1632ai(MyPageInteraction myPageInteraction) {
        this.f6119a = myPageInteraction;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f6119a.getActivity(), (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", this.f6119a.f5919o);
        intent.putExtra("PROFILE_BUDDY_NAME", this.f6119a.f5920p);
        this.f6119a.startActivity(intent);
    }
}
