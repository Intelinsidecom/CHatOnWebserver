package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyRecommendListActivity;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: BuddyRecommendListActivity.java */
/* renamed from: com.sec.chaton.buddy.dv */
/* loaded from: classes.dex */
class ViewOnClickListenerC0364dv implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListActivity.BuddyRecommendListFragment f1515a;

    ViewOnClickListenerC0364dv(BuddyRecommendListActivity.BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f1515a = buddyRecommendListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialogBuilderC2120a(this.f1515a.getActivity()).setTitle(this.f1515a.getResources().getString(R.string.buddy_suggestion_ignore)).setMessage(this.f1515a.getResources().getString(R.string.suggestion_ignore_all_buddies_popup)).setPositiveButton(this.f1515a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0365dw(this)).setNegativeButton(this.f1515a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
    }
}
