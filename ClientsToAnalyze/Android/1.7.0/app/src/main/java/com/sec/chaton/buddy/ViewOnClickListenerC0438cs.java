package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.buddy.BuddyRecommendActivity;

/* compiled from: BuddyRecommendActivity.java */
/* renamed from: com.sec.chaton.buddy.cs */
/* loaded from: classes.dex */
class ViewOnClickListenerC0438cs implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendActivity.BuddyRecommendFragment f1430a;

    ViewOnClickListenerC0438cs(BuddyRecommendActivity.BuddyRecommendFragment buddyRecommendFragment) {
        this.f1430a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1430a.m2296a((String) view.getTag());
    }
}
