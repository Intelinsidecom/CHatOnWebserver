package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.hb */
/* loaded from: classes.dex */
class C1349hb implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f4928a;

    C1349hb(BuddyRecommendFragment buddyRecommendFragment) {
        this.f4928a = buddyRecommendFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C1359hl c1359hl = new C1359hl(view);
        this.f4928a.f4083k = c1359hl.f4947d.getTag(R.id.TAG_FOR_BUDDYNO).toString();
        this.f4928a.f4085m = c1359hl.f4946c.getText().toString();
        Intent intent = new Intent(this.f4928a.f4066A, (Class<?>) BuddyDialog.class);
        intent.putExtra("BUDDY_DIALOG_BUDDY_NO", this.f4928a.f4083k);
        intent.putExtra("BUDDY_DIALOG_BUDDY_NAME", this.f4928a.f4085m);
        intent.putExtra("BUDDY_DIALOG_BUDDY_FROM_SUGGESTION", true);
        this.f4928a.startActivity(intent);
    }
}
