package com.sec.chaton.control.task;

import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.task.m */
/* loaded from: classes.dex */
class RunnableC0204m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ FileUploadTask2 f1697a;

    RunnableC0204m(FileUploadTask2 fileUploadTask2) {
        this.f1697a = fileUploadTask2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1697a.f1568k == ChatONContract.MessageTable.MsgContentType.CONTACT || this.f1697a.f1568k == ChatONContract.MessageTable.MsgContentType.CALENDAR) {
            MessageDatabaseHelper.m2281a(GlobalApplication.m2387e().getContentResolver(), Long.valueOf(this.f1697a.f1571n), this.f1697a.f1558a);
        } else {
            MessageDatabaseHelper.m2278a(GlobalApplication.m2387e().getContentResolver(), Long.valueOf(this.f1697a.f1571n));
        }
        if (MessageControl.m2012a(this.f1697a.f1559b) != null && MessageControl.m2012a(this.f1697a.f1559b).f1366c != null && ((FileUploadTask2) MessageControl.m2012a(this.f1697a.f1559b).f1366c.remove(Long.valueOf(this.f1697a.f1571n))) != null) {
            ChatONLogWriter.m3506b("Successfully removed from hashmap", getClass().getName());
        }
        Toast.makeText(GlobalApplication.m2387e(), C0062R.string.toast_file_upload_fail, 0).show();
    }
}
