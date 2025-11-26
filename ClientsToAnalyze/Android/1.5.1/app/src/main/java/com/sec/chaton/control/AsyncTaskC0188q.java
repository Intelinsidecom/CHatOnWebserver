package com.sec.chaton.control;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.control.TaskContainer;
import com.sec.chaton.control.task.FileUploadTask2;
import com.sec.chaton.control.task.MediaChatTask;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.code.FaultCodeConvertor;
import java.io.File;

/* renamed from: com.sec.chaton.control.q */
/* loaded from: classes.dex */
class AsyncTaskC0188q extends FileUploadTask2 {

    /* renamed from: j */
    final /* synthetic */ long f1439j;

    /* renamed from: k */
    final /* synthetic */ File f1440k;

    /* renamed from: l */
    final /* synthetic */ String f1441l;

    /* renamed from: m */
    final /* synthetic */ ChatONContract.MessageTable.MsgContentType f1442m;

    /* renamed from: n */
    final /* synthetic */ ChatONContract.InBoxTable.ChatType f1443n;

    /* renamed from: o */
    final /* synthetic */ String f1444o;

    /* renamed from: p */
    final /* synthetic */ String[] f1445p;

    /* renamed from: q */
    final /* synthetic */ boolean f1446q;

    /* renamed from: r */
    final /* synthetic */ String f1447r;

    /* renamed from: s */
    final /* synthetic */ MessageControl f1448s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncTaskC0188q(MessageControl messageControl, Handler handler, File file, ChatONContract.MessageTable.MsgContentType msgContentType, String str, String str2, String str3, long j, String str4, long j2, File file2, String str5, ChatONContract.MessageTable.MsgContentType msgContentType2, ChatONContract.InBoxTable.ChatType chatType, String str6, String[] strArr, boolean z, String str7) {
        super(handler, file, msgContentType, str, str2, str3, j, str4);
        this.f1448s = messageControl;
        this.f1439j = j2;
        this.f1440k = file2;
        this.f1441l = str5;
        this.f1442m = msgContentType2;
        this.f1443n = chatType;
        this.f1444o = str6;
        this.f1445p = strArr;
        this.f1446q = z;
        this.f1447r = str7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (str == null || !str.startsWith("http://")) {
            int iM2824a = str != null ? FaultCodeConvertor.m2824a(str.substring(str.lastIndexOf(":") + 1).trim()) : 0;
            if (this.f1442m == ChatONContract.MessageTable.MsgContentType.CONTACT || this.f1442m == ChatONContract.MessageTable.MsgContentType.CALENDAR) {
                MessageDatabaseHelper.m2281a(GlobalApplication.m2387e().getContentResolver(), Long.valueOf(this.f1439j), this.f1447r);
            } else {
                MessageDatabaseHelper.m2278a(GlobalApplication.m2387e().getContentResolver(), Long.valueOf(this.f1439j));
            }
            Message message = new Message();
            message.what = 1024;
            if (iM2824a != 0) {
                message.obj = new MessageResultEntry(false, iM2824a);
            } else {
                message.obj = new MessageResultEntry(false, ResultEntry.Result.NETWORKFAIL);
            }
            this.f1566i.sendMessage(message);
        } else {
            MessageDatabaseHelper.m2283a(GlobalApplication.m2387e().getContentResolver(), Long.valueOf(this.f1439j), true);
            TaskContainer taskContainer = new TaskContainer(this.f1448s.f1379r, this.f1448s.f1371i);
            taskContainer.m2085a(TaskContainer.TaskType.NetTask, new MediaChatTask(taskContainer.m2086b(), this.f1448s.f1370h, this.f1439j, this.f1440k, this.f1441l, this.f1442m, this.f1443n, this.f1444o, this.f1445p, str, this.f1446q, this.f1447r));
            this.f1448s.f1376n.put(Long.valueOf(taskContainer.m2083a()), taskContainer);
            taskContainer.m2088d();
        }
        if (this.f1448s.f1366c != null) {
            this.f1448s.f1366c.remove(Long.valueOf(this.f1439j));
        }
    }
}
