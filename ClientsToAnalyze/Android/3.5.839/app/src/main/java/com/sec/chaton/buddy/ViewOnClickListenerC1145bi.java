package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bi */
/* loaded from: classes.dex */
class ViewOnClickListenerC1145bi implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4364a;

    ViewOnClickListenerC1145bi(BuddyFragment buddyFragment) {
        this.f4364a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4364a.f3699bd.isShown()) {
            this.f4364a.f3698bc.setBackgroundResource(R.drawable.list_ic_arrow_down);
            this.f4364a.f3699bd.setVisibility(8);
            this.f4364a.f3700be.setVisibility(8);
        } else {
            this.f4364a.f3698bc.setBackgroundResource(R.drawable.list_ic_arrow_up);
            this.f4364a.f3699bd.setVisibility(0);
            this.f4364a.f3700be.setVisibility(0);
        }
    }
}
