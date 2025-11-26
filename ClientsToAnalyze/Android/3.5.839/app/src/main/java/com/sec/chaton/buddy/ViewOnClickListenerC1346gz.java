package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.view.View;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.gz */
/* loaded from: classes.dex */
class ViewOnClickListenerC1346gz implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f4925a;

    ViewOnClickListenerC1346gz(BuddyRecommendFragment buddyRecommendFragment) {
        this.f4925a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AbstractC4932a.m18733a(this.f4925a.getActivity()).mo18740a(this.f4925a.getResources().getString(R.string.buddy_suggestion_add_all)).mo18749b(this.f4925a.getResources().getString(R.string.suggestion_add_all_contacts_popup)).mo18755c(this.f4925a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1348ha(this)).mo18741a(this.f4925a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
    }
}
