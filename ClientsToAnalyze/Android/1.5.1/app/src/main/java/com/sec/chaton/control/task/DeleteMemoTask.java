package com.sec.chaton.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.database.helper.MemoDatabaseHelper;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class DeleteMemoTask extends AbstractHttpTask2 {

    /* renamed from: a */
    private String f1494a;

    public DeleteMemoTask(Handler handler, HttpEnvelope httpEnvelope, String str) {
        super(handler, httpEnvelope);
        this.f1494a = "";
        this.f1494a = str;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        if (!httpEntry.m1950a() || httpEntry.m1951b() == HttpResultCode.ERROR) {
            return;
        }
        ChatONLogWriter.m3511e("delete from db" + this.f1494a, "DeleteMemoTask");
        if (MemoDatabaseHelper.m2267a(this.f1494a) == 1) {
            ChatONLogWriter.m3511e("deletedRowCount is 1", "DeleteMemoTask");
        }
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        return null;
    }
}
