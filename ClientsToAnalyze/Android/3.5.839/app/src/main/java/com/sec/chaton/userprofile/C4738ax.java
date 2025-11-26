package com.sec.chaton.userprofile;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2225am;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.ax */
/* loaded from: classes.dex */
class C4738ax extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f17402a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4738ax(MyPageFragment myPageFragment, Handler handler) {
        super(handler);
        this.f17402a = myPageFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f17402a.f17216U.startQuery(1, null, C2225am.f7952b, null, null, null, "order_msec DESC");
    }
}
