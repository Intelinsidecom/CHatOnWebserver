package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.dialog.BuddyDialog;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.m */
/* loaded from: classes.dex */
class ViewOnClickListenerC1407m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f5041a;

    ViewOnClickListenerC1407m(AddBuddyFragment addBuddyFragment) {
        this.f5041a = addBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f5041a.f3528V, (Class<?>) BuddyDialog.class);
        intent.putExtra("BUDDY_DIALOG_BUDDY_NO", this.f5041a.f3523Q);
        intent.putExtra("BUDDY_DIALOG_BUDDY_NAME", this.f5041a.f3524R);
        intent.putExtra("BUDDY_DIALOG_BUDDY_FROM_SUGGESTION", true);
        if (this.f5041a.f3554y.equals(this.f5041a.f3552w) || this.f5041a.f3554y.equals(this.f5041a.f3553x)) {
            intent.putExtra("BUDDY_DIALOG_BUDDY_FROM_SUGGESTION_SEARCH", true);
        }
        this.f5041a.startActivityForResult(intent, 2);
    }
}
