package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.registration.ActivityRegist;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bf */
/* loaded from: classes.dex */
class ViewOnClickListenerC0548bf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2507a;

    ViewOnClickListenerC0548bf(BuddyFragment buddyFragment) {
        this.f2507a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f2507a.getActivity(), (Class<?>) ActivityRegist.class);
        intent.putExtra("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC", "ACTIVITY_PURPOSE_CALL_CONTACT_SYNC");
        this.f2507a.startActivity(intent);
    }
}
