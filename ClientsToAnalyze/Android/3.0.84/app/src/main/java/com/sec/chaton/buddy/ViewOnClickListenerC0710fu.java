package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.fu */
/* loaded from: classes.dex */
class ViewOnClickListenerC0710fu implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f2951a;

    ViewOnClickListenerC0710fu(BuddyRecommendFragment buddyRecommendFragment) {
        this.f2951a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0729gm c0729gm = new C0729gm(view);
        this.f2951a.f2197j = c0729gm.f2980c.getTag(R.id.TAG_FOR_BUDDYNO).toString();
        this.f2951a.f2199l = c0729gm.f2979b.getText().toString();
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent(this.f2951a.f2178J, (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", this.f2951a.f2197j);
            intent.putExtra("PROFILE_BUDDY_NAME", this.f2951a.f2199l);
            intent.putExtra("PROFILE_BUDDY_SUGGESTION", true);
            this.f2951a.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f2951a.f2178J, (Class<?>) BuddyDialog.class);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NO", this.f2951a.f2197j);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NAME", this.f2951a.f2199l);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_FROM_SUGGESTION", true);
        this.f2951a.startActivity(intent2);
    }
}
