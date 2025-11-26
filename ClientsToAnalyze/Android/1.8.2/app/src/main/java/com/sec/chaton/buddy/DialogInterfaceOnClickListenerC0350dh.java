package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.buddy.BuddyRecommendActivity;

/* compiled from: BuddyRecommendActivity.java */
/* renamed from: com.sec.chaton.buddy.dh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0350dh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendActivity.BuddyRecommendFragment f1494a;

    DialogInterfaceOnClickListenerC0350dh(BuddyRecommendActivity.BuddyRecommendFragment buddyRecommendFragment) {
        this.f1494a = buddyRecommendFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1494a.f1169e.show();
        this.f1494a.f1171g.m2890a("true", this.f1494a.f1175k);
    }
}
