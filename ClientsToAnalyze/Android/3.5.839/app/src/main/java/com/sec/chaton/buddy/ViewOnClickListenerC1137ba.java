package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.util.C4847bl;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ba */
/* loaded from: classes.dex */
class ViewOnClickListenerC1137ba implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4355a;

    ViewOnClickListenerC1137ba(BuddyFragment buddyFragment) {
        this.f4355a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            BuddyFragment.f3586l = true;
            this.f4355a.m6309N();
        }
    }
}
