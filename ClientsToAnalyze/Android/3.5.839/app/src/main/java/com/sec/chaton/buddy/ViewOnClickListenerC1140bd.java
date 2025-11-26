package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.registration.FragmentRegist;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bd */
/* loaded from: classes.dex */
class ViewOnClickListenerC1140bd implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4358a;

    ViewOnClickListenerC1140bd(BuddyFragment buddyFragment) {
        this.f4358a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4358a.getActivity(), (Class<?>) ActivityRegist.class);
        intent.putExtra(FragmentRegist.f11708d, true);
        intent.putExtra(FragmentRegist.f11710f, true);
        intent.putExtra("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC", "ACTIVITY_PURPOSE_CALL_CONTACT_SYNC");
        this.f4358a.startActivity(intent);
    }
}
