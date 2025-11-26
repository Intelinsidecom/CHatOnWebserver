package com.sec.chaton.smsplugin.p112ui;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: ThreadSelectionFragment.java */
/* renamed from: com.sec.chaton.smsplugin.ui.jd */
/* loaded from: classes.dex */
class C4338jd extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ThreadSelectionFragment f15768a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4338jd(ThreadSelectionFragment threadSelectionFragment, Handler handler) {
        super(handler);
        this.f15768a = threadSelectionFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f15768a.m16262f();
    }
}
