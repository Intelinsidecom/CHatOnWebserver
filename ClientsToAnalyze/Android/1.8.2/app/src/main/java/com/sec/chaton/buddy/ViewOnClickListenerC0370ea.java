package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyRecommendListActivity;

/* compiled from: BuddyRecommendListActivity.java */
/* renamed from: com.sec.chaton.buddy.ea */
/* loaded from: classes.dex */
class ViewOnClickListenerC0370ea implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListActivity.BuddyRecommendListFragment f1521a;

    ViewOnClickListenerC0370ea(BuddyRecommendListActivity.BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f1521a = buddyRecommendListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0378ei c0378ei = new C0378ei(view);
        this.f1521a.f1190h = c0378ei.f1535c.getTag(R.id.TAG_FOR_BUDDYNO).toString();
        Intent intent = new Intent(this.f1521a.getActivity(), (Class<?>) SpecialBuddyActivity.class);
        intent.putExtra("specialuserid", this.f1521a.f1190h);
        intent.putExtra("specialBuddyAdded", false);
        this.f1521a.startActivity(intent);
    }
}
