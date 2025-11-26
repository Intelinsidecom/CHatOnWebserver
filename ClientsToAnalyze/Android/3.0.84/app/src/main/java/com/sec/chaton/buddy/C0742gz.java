package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.gz */
/* loaded from: classes.dex */
class C0742gz implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListFragment f2996a;

    C0742gz(BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f2996a = buddyRecommendListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view instanceof CheckableRelativeLayout) {
            C0749hf c0749hf = new C0749hf(view);
            this.f2996a.f2224j = c0749hf.f3011c.getTag(R.id.TAG_FOR_BUDDYNO).toString();
            this.f2996a.f2226l = c0749hf.f3010b.getText().toString();
            if (GlobalApplication.m6456e()) {
                Intent intent = new Intent(this.f2996a.getActivity(), (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", this.f2996a.f2224j);
                intent.putExtra("PROFILE_BUDDY_NAME", this.f2996a.f2226l);
                intent.putExtra("PROFILE_BUDDY_SUGGESTION", true);
                this.f2996a.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(this.f2996a.getActivity(), (Class<?>) BuddyDialog.class);
            intent2.putExtra("BUDDY_DIALOG_BUDDY_NO", this.f2996a.f2224j);
            intent2.putExtra("BUDDY_DIALOG_BUDDY_NAME", this.f2996a.f2226l);
            intent2.putExtra("BUDDY_DIALOG_BUDDY_FROM_SUGGESTION", true);
            this.f2996a.startActivity(intent2);
        }
    }
}
