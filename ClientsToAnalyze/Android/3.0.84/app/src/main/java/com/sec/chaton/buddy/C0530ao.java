package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ao */
/* loaded from: classes.dex */
class C0530ao extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ C0522ag f2474a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0530ao(C0522ag c0522ag, Handler handler) {
        super(handler);
        this.f2474a = c0522ag;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f2474a.m4045e();
        this.f2474a.notifyDataSetChanged();
    }
}
