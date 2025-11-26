package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyRecommendListActivity;

/* compiled from: BuddyRecommendListActivity.java */
/* renamed from: com.sec.chaton.buddy.eb */
/* loaded from: classes.dex */
class ViewOnClickListenerC0371eb implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListActivity.BuddyRecommendListFragment f1522a;

    ViewOnClickListenerC0371eb(BuddyRecommendListActivity.BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f1522a = buddyRecommendListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0378ei c0378ei = new C0378ei(view);
        this.f1522a.f1190h = c0378ei.f1535c.getTag(R.id.TAG_FOR_BUDDYNO).toString();
        this.f1522a.f1192j = c0378ei.f1534b.getText().toString();
        Intent intent = new Intent(this.f1522a.getActivity(), (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", this.f1522a.f1190h);
        intent.putExtra("PROFILE_BUDDY_NAME", this.f1522a.f1192j);
        intent.putExtra("PROFILE_BUDDY_SUGGESTION", true);
        this.f1522a.startActivity(intent);
    }
}
