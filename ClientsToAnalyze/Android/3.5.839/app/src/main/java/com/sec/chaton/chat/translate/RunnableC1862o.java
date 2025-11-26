package com.sec.chaton.chat.translate;

import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: TranslateAsyncTask.java */
/* renamed from: com.sec.chaton.chat.translate.o */
/* loaded from: classes.dex */
class RunnableC1862o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC1861n f7080a;

    RunnableC1862o(RunnableC1861n runnableC1861n) {
        this.f7080a = runnableC1861n;
    }

    @Override // java.lang.Runnable
    public void run() {
        C5179v.m19810a(CommonApplication.m18732r(), R.string.failed_to_translate, 0).show();
    }
}
