package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.view.View;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.gx */
/* loaded from: classes.dex */
class ViewOnClickListenerC0740gx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListFragment f2994a;

    ViewOnClickListenerC0740gx(BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f2994a = buddyRecommendListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AbstractC3271a.m11494a(this.f2994a.getActivity()).mo11500a(this.f2994a.getResources().getString(R.string.buddy_suggestion_add_all)).mo11509b(this.f2994a.getResources().getString(R.string.suggestion_add_all_buddies_popup)).mo11510b(this.f2994a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0741gy(this)).mo11501a(this.f2994a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
    }
}
