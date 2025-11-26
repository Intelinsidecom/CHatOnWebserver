package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.settings.ActivitySettings;

/* renamed from: com.sec.chaton.buddy.az */
/* loaded from: classes.dex */
class ViewOnClickListenerC0102az implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f645a;

    ViewOnClickListenerC0102az(BuddyFragment buddyFragment) {
        this.f645a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ActivitySettings.m3131a(this.f645a.getActivity());
    }
}
