package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.hc */
/* loaded from: classes.dex */
class ViewOnClickListenerC0746hc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListFragment f3000a;

    ViewOnClickListenerC0746hc(BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f3000a = buddyRecommendListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0749hf c0749hf = new C0749hf(view);
        this.f3000a.f2224j = c0749hf.f3011c.getTag(R.id.TAG_FOR_BUDDYNO).toString();
        this.f3000a.f2226l = c0749hf.f3010b.getText().toString();
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent(this.f3000a.getActivity(), (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", this.f3000a.f2224j);
            intent.putExtra("PROFILE_BUDDY_NAME", this.f3000a.f2226l);
            intent.putExtra("PROFILE_BUDDY_SUGGESTION", true);
            this.f3000a.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f3000a.getActivity(), (Class<?>) BuddyDialog.class);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NO", this.f3000a.f2224j);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NAME", this.f3000a.f2226l);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_FROM_SUGGESTION", true);
        this.f3000a.startActivity(intent2);
    }
}
