package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.a */
/* loaded from: classes.dex */
class C0254a extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1306a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0254a(AddBuddyActivity.AddBuddyFragment addBuddyFragment, Handler handler) {
        super(handler);
        this.f1306a = addBuddyFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f1306a.f857N != null) {
            this.f1306a.f857N.m2440a();
        }
    }
}
