package com.sec.chaton.control.task;

import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.task.h */
/* loaded from: classes.dex */
class RunnableC0199h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ FileDownloadTask2 f1692a;

    RunnableC0199h(FileDownloadTask2 fileDownloadTask2) {
        this.f1692a = fileDownloadTask2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1692a.f1531j != null) {
            this.f1692a.f1531j.setVisibility(4);
        }
        if (this.f1692a.f1532k != null) {
            this.f1692a.f1532k.setVisibility(4);
        }
        if (this.f1692a.f1533l != null) {
            this.f1692a.f1533l.setVisibility(4);
        }
        MessageDatabaseHelper.m2299b(GlobalApplication.m2387e().getContentResolver(), Long.valueOf(this.f1692a.f1527f));
        if (MessageControl.m2012a(this.f1692a.f1526e) != null && MessageControl.m2012a(this.f1692a.f1526e).f1367d != null && ((FileDownloadTask2) MessageControl.m2012a(this.f1692a.f1526e).f1367d.remove(Long.valueOf(this.f1692a.f1527f))) != null) {
            ChatONLogWriter.m3506b("Successfully removed from hashmap", getClass().getName());
        }
        Toast.makeText(GlobalApplication.m2387e(), C0062R.string.media_download_fail, 0).show();
    }
}
