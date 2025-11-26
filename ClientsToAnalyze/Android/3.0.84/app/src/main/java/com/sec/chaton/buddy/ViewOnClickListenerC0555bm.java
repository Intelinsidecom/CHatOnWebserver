package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bm */
/* loaded from: classes.dex */
class ViewOnClickListenerC0555bm implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2514a;

    ViewOnClickListenerC0555bm(BuddyFragment buddyFragment) {
        this.f2514a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2514a.f1779aQ.isShown()) {
            this.f2514a.f1778aP.setBackgroundResource(R.drawable.list_ic_arrow_down);
            this.f2514a.f1779aQ.setVisibility(8);
            this.f2514a.f1780aR.setVisibility(8);
        } else {
            this.f2514a.f1778aP.setBackgroundResource(R.drawable.list_ic_arrow_up);
            this.f2514a.f1779aQ.setVisibility(0);
            this.f2514a.f1780aR.setVisibility(0);
        }
    }
}
