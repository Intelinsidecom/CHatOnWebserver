package com.sec.chaton.control.task;

import android.app.ProgressDialog;
import com.sec.chaton.chat.ChatListAdapter;

/* renamed from: com.sec.chaton.control.task.i */
/* loaded from: classes.dex */
class RunnableC0200i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ FileDownloadTask2 f1693a;

    RunnableC0200i(FileDownloadTask2 fileDownloadTask2) {
        this.f1693a = fileDownloadTask2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ChatListAdapter.m777a(this.f1693a.f1541t, this.f1693a.f1537p, this.f1693a.f1542u, (ProgressDialog) null);
    }
}
