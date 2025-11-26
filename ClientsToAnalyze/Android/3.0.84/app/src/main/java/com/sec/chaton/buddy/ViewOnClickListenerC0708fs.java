package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.fs */
/* loaded from: classes.dex */
class ViewOnClickListenerC0708fs implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f2949a;

    ViewOnClickListenerC0708fs(BuddyRecommendFragment buddyRecommendFragment) {
        this.f2949a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2949a.f2197j = view.getTag(R.id.TAG_FOR_BUDDYNO).toString();
        this.f2949a.f2199l = view.getTag(R.id.TAG_FOR_TYPE).toString();
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent(this.f2949a.f2178J, (Class<?>) SpecialBuddyActivity.class);
            intent.putExtra("specialuserid", this.f2949a.f2197j);
            intent.putExtra("speicalusername", this.f2949a.f2199l);
            intent.putExtra("specialBuddyAdded", false);
            this.f2949a.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f2949a.f2178J, (Class<?>) SpecialBuddyDialog.class);
        intent2.putExtra("specialuserid", this.f2949a.f2197j);
        intent2.putExtra("speicalusername", this.f2949a.f2199l);
        intent2.putExtra("specialBuddyAdded", false);
        this.f2949a.startActivity(intent2);
    }
}
