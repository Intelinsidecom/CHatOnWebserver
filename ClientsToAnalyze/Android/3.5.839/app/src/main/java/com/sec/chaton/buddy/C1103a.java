package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.a */
/* loaded from: classes.dex */
class C1103a extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f4202a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1103a(AddBuddyFragment addBuddyFragment, Handler handler) {
        super(handler);
        this.f4202a = addBuddyFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f4202a.f3522P != null) {
            this.f4202a.f3522P.m7098a();
        }
    }
}
