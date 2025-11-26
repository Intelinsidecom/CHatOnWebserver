package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.a */
/* loaded from: classes.dex */
class C0510a extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f2352a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0510a(AddBuddyFragment addBuddyFragment, Handler handler) {
        super(handler);
        this.f2352a = addBuddyFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f2352a.f1670R != null) {
            this.f2352a.f1670R.m4014a();
        }
    }
}
