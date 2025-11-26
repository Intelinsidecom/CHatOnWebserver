package com.sec.chaton.control.task;

import android.os.Handler;
import com.sec.chaton.account.ContactManager;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;

/* loaded from: classes.dex */
public class UnBlockTask extends AbstractHttpTask2 {
    public UnBlockTask(Handler handler, HttpEnvelope httpEnvelope, String str) {
        super(handler, httpEnvelope);
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        if (httpEntry.m1950a() && httpEntry.m1951b() == HttpResultCode.SUCCESS) {
            ContactManager.m405a(true);
        }
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        return null;
    }
}
