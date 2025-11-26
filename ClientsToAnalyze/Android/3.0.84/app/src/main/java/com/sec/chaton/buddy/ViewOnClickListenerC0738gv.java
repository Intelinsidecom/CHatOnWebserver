package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.view.View;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.gv */
/* loaded from: classes.dex */
class ViewOnClickListenerC0738gv implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListFragment f2992a;

    ViewOnClickListenerC0738gv(BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f2992a = buddyRecommendListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AbstractC3271a.m11494a(this.f2992a.getActivity()).mo11500a(this.f2992a.getResources().getString(R.string.buddy_suggestion_ignore)).mo11509b(this.f2992a.getResources().getString(R.string.suggestion_ignore_all_buddies_popup)).mo11510b(this.f2992a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0739gw(this)).mo11501a(this.f2992a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
    }
}
