package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.eu */
/* loaded from: classes.dex */
class C0683eu extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f2905a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0683eu(BuddyProfileFragment buddyProfileFragment, Handler handler) {
        super(handler);
        this.f2905a = buddyProfileFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f2905a.m3648c(this.f2905a.m3726d(this.f2905a.f2117t));
    }
}
