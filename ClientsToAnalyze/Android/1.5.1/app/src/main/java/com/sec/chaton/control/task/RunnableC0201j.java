package com.sec.chaton.control.task;

import com.sec.chaton.control.MessageControl;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.task.j */
/* loaded from: classes.dex */
class RunnableC0201j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ FileDownloadTask2 f1694a;

    RunnableC0201j(FileDownloadTask2 fileDownloadTask2) {
        this.f1694a = fileDownloadTask2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (MessageControl.m2012a(this.f1694a.f1526e) == null || MessageControl.m2012a(this.f1694a.f1526e).f1367d == null || ((FileDownloadTask2) MessageControl.m2012a(this.f1694a.f1526e).f1367d.remove(Long.valueOf(this.f1694a.f1527f))) == null) {
            return;
        }
        ChatONLogWriter.m3506b("Successfully removed from hashmap after down-load", getClass().getName());
    }
}
