package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyRecommendListActivity;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: BuddyRecommendListActivity.java */
/* renamed from: com.sec.chaton.buddy.dx */
/* loaded from: classes.dex */
class ViewOnClickListenerC0366dx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListActivity.BuddyRecommendListFragment f1517a;

    ViewOnClickListenerC0366dx(BuddyRecommendListActivity.BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f1517a = buddyRecommendListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialogBuilderC2120a(this.f1517a.getActivity()).setTitle(this.f1517a.getResources().getString(R.string.buddy_suggestion_add_all)).setMessage(this.f1517a.getResources().getString(R.string.suggestion_add_all_buddies_popup)).setPositiveButton(this.f1517a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0367dy(this)).setNegativeButton(this.f1517a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
    }
}
