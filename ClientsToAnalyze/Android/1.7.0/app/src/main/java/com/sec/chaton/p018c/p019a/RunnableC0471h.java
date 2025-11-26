package com.sec.chaton.p018c.p019a;

import android.app.ProgressDialog;
import com.sec.chaton.chat.ViewOnClickListenerC0603t;

/* compiled from: FileDownloadTask2.java */
/* renamed from: com.sec.chaton.c.a.h */
/* loaded from: classes.dex */
class RunnableC0471h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC0466c f1505a;

    RunnableC0471h(AsyncTaskC0466c asyncTaskC0466c) {
        this.f1505a = asyncTaskC0466c;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewOnClickListenerC0603t.m2788a(this.f1505a.f1481s, this.f1505a.f1477o, this.f1505a.f1482t, (ProgressDialog) null);
    }
}
