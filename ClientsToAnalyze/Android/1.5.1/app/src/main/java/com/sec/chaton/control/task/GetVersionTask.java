package com.sec.chaton.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpEnvelope;

/* loaded from: classes.dex */
public class GetVersionTask extends AbstractHttpTask2 {
    public GetVersionTask(Handler handler, HttpEnvelope httpEnvelope) {
        super(handler, httpEnvelope);
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        return null;
    }
}
