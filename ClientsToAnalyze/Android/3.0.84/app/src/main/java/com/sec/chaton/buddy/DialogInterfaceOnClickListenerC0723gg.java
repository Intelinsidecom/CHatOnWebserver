package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.gg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0723gg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f2966a;

    /* renamed from: b */
    final /* synthetic */ BuddyRecommendFragment f2967b;

    DialogInterfaceOnClickListenerC0723gg(BuddyRecommendFragment buddyRecommendFragment, boolean z) {
        this.f2967b = buddyRecommendFragment;
        this.f2966a = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f2966a) {
            this.f2967b.f2178J.finish();
        }
    }
}
