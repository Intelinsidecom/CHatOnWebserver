package com.sec.chaton.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class DeleteProfileImageTask2 extends AbstractHttpTask2 {
    public DeleteProfileImageTask2(Handler handler, HttpEnvelope httpEnvelope) {
        super(handler, httpEnvelope);
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        if (!httpEntry.m1950a() || httpEntry.m1951b() == HttpResultCode.ERROR) {
            return;
        }
        ChatONPref.m3523a("profile_image_status", "deleted");
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        return null;
    }
}
