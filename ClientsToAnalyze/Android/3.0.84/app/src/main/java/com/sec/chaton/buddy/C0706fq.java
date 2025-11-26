package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.fq */
/* loaded from: classes.dex */
class C0706fq implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f2947a;

    C0706fq(BuddyRecommendFragment buddyRecommendFragment) {
        this.f2947a = buddyRecommendFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C0729gm c0729gm = new C0729gm(view);
        this.f2947a.f2197j = c0729gm.f2980c.getTag(R.id.TAG_FOR_BUDDYNO).toString();
        this.f2947a.f2199l = c0729gm.f2979b.getText().toString();
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent(this.f2947a.f2178J, (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", this.f2947a.f2197j);
            intent.putExtra("PROFILE_BUDDY_NAME", this.f2947a.f2199l);
            intent.putExtra("PROFILE_BUDDY_SUGGESTION", true);
            this.f2947a.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f2947a.f2178J, (Class<?>) BuddyDialog.class);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NO", this.f2947a.f2197j);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NAME", this.f2947a.f2199l);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_FROM_SUGGESTION", true);
        this.f2947a.startActivity(intent2);
    }
}
