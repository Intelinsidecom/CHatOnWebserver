package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC0799n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f3094a;

    ViewOnClickListenerC0799n(AddBuddyFragment addBuddyFragment) {
        this.f3094a = addBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent(this.f3094a.f1676X, (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", this.f3094a.f1671S);
            intent.putExtra("PROFILE_BUDDY_NAME", this.f3094a.f1672T);
            intent.putExtra("PROFILE_BUDDY_SUGGESTION", true);
            this.f3094a.startActivityForResult(intent, 2);
            return;
        }
        Intent intent2 = new Intent(this.f3094a.f1676X, (Class<?>) BuddyDialog.class);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NO", this.f3094a.f1671S);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NAME", this.f3094a.f1672T);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_FROM_SUGGESTION", true);
        this.f3094a.startActivityForResult(intent2, 2);
    }
}
