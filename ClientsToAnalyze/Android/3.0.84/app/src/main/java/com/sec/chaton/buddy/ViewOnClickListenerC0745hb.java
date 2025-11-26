package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.hb */
/* loaded from: classes.dex */
class ViewOnClickListenerC0745hb implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListFragment f2999a;

    ViewOnClickListenerC0745hb(BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f2999a = buddyRecommendListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0749hf c0749hf = new C0749hf(view);
        this.f2999a.f2224j = c0749hf.f3011c.getTag(R.id.TAG_FOR_BUDDYNO).toString();
        Intent intent = new Intent(this.f2999a.getActivity(), (Class<?>) SpecialBuddyActivity.class);
        intent.putExtra("specialuserid", this.f2999a.f2224j);
        intent.putExtra("specialBuddyAdded", false);
        this.f2999a.startActivity(intent);
    }
}
