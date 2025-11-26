package com.sec.chaton.control;

import android.app.ProgressDialog;
import com.sec.chaton.control.task.FileDownloadTask;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.control.p */
/* loaded from: classes.dex */
class AsyncTaskC0187p extends FileDownloadTask {

    /* renamed from: a */
    final /* synthetic */ ChatONContract.MessageTable.MsgContentType f1436a;

    /* renamed from: b */
    final /* synthetic */ ProgressDialog f1437b;

    /* renamed from: c */
    final /* synthetic */ MessageControl f1438c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncTaskC0187p(MessageControl messageControl, String str, String str2, String str3, boolean z, String str4, long j, ChatONContract.InBoxTable.ChatType chatType, String str5, ChatONContract.MessageTable.MsgContentType msgContentType, ProgressDialog progressDialog) {
        super(str, str2, str3, z, str4, j, chatType, str5);
        this.f1438c = messageControl;
        this.f1436a = msgContentType;
        this.f1437b = progressDialog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        this.f1438c.f1369g.post(new RunnableC0209x(this, str));
    }
}
