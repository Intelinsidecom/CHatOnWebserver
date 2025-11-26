package com.sec.chaton.userprofile;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.a */
/* loaded from: classes.dex */
class C1202a extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4279a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1202a(MyPageFragment myPageFragment, Handler handler) {
        super(handler);
        this.f4279a = myPageFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        this.f4279a.m4306g();
    }
}
