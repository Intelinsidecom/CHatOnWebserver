package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyRecommendActivity;

/* compiled from: BuddyRecommendActivity.java */
/* renamed from: com.sec.chaton.buddy.dn */
/* loaded from: classes.dex */
class ViewOnClickListenerC0356dn implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendActivity.BuddyRecommendFragment f1500a;

    ViewOnClickListenerC0356dn(BuddyRecommendActivity.BuddyRecommendFragment buddyRecommendFragment) {
        this.f1500a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0363du c0363du = new C0363du(view);
        this.f1500a.f1172h = c0363du.f1513c.getTag(R.id.TAG_FOR_BUDDYNO).toString();
        this.f1500a.f1174j = c0363du.f1512b.getText().toString();
        Intent intent = new Intent(this.f1500a.getActivity(), (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", this.f1500a.f1172h);
        intent.putExtra("PROFILE_BUDDY_NAME", this.f1500a.f1174j);
        intent.putExtra("PROFILE_BUDDY_SUGGESTION", true);
        this.f1500a.startActivity(intent);
    }
}
