package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.registration.ActivityRegist;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ck */
/* loaded from: classes.dex */
class ViewOnClickListenerC0580ck implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2542a;

    ViewOnClickListenerC0580ck(BuddyFragment buddyFragment) {
        this.f2542a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f2542a.getActivity(), (Class<?>) ActivityRegist.class);
        intent.putExtra("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC", "ACTIVITY_PURPOSE_CALL_CONTACT_SYNC");
        this.f2542a.startActivity(intent);
    }
}
