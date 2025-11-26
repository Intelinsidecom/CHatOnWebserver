package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.view.View;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.gx */
/* loaded from: classes.dex */
class ViewOnClickListenerC1344gx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f4923a;

    ViewOnClickListenerC1344gx(BuddyRecommendFragment buddyRecommendFragment) {
        this.f4923a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AbstractC4932a.m18733a(this.f4923a.getActivity()).mo18740a(this.f4923a.getResources().getString(R.string.buddy_suggestion_ignore_all)).mo18749b(this.f4923a.getResources().getString(R.string.suggestion_ignore_all_buddies_popup)).mo18755c(this.f4923a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1345gy(this)).mo18741a(this.f4923a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
    }
}
