package com.sec.chaton.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.p000io.entry.GetVersion3;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class GetVersionTask3 extends AbstractHttpTask2 {
    public GetVersionTask3(Handler handler, HttpEnvelope httpEnvelope) {
        super(handler, httpEnvelope);
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        ChatONLogWriter.m3511e("" + ((GetVersion3) httpEntry.m1955d()), getClass().getSimpleName());
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        return null;
    }
}
