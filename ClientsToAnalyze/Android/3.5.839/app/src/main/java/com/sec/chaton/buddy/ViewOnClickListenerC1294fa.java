package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.fa */
/* loaded from: classes.dex */
class ViewOnClickListenerC1294fa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f4830a;

    ViewOnClickListenerC1294fa(BuddyInfoFragment buddyInfoFragment) {
        this.f4830a = buddyInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4830a.f3845O, (Class<?>) BuddyEditNickNameActivity.class);
        intent.putExtra("PROFILE_ID", this.f4830a.f3866l);
        intent.putExtra("PROFILE_NAME", this.f4830a.f3877w.getText());
        intent.putExtra("PROFILE_BUDDY_MODE", true);
        this.f4830a.startActivityForResult(intent, 7);
    }
}
