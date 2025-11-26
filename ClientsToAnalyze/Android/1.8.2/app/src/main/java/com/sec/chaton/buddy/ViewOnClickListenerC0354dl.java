package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyRecommendActivity;

/* compiled from: BuddyRecommendActivity.java */
/* renamed from: com.sec.chaton.buddy.dl */
/* loaded from: classes.dex */
class ViewOnClickListenerC0354dl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendActivity.BuddyRecommendFragment f1498a;

    ViewOnClickListenerC0354dl(BuddyRecommendActivity.BuddyRecommendFragment buddyRecommendFragment) {
        this.f1498a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0363du c0363du = new C0363du(view);
        this.f1498a.f1172h = c0363du.f1513c.getTag(R.id.TAG_FOR_BUDDYNO).toString();
        Intent intent = new Intent(this.f1498a.getActivity(), (Class<?>) SpecialBuddyActivity.class);
        intent.putExtra("specialuserid", this.f1498a.f1172h);
        intent.putExtra("specialBuddyAdded", false);
        this.f1498a.startActivity(intent);
    }
}
