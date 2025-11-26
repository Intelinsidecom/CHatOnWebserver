package com.sec.chaton.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatOnXmlParser;
import java.util.List;

/* loaded from: classes.dex */
public class SetAnsNotiReadMessage extends AbstractHttpTask2 {

    /* renamed from: a */
    private List f1667a;

    public SetAnsNotiReadMessage(Handler handler, HttpEnvelope httpEnvelope, List list) {
        super(handler, httpEnvelope);
        this.f1667a = list;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        if (this.f1667a == null || this.f1667a.size() == 0) {
            interrupt();
            return "";
        }
        String strM3552a = new ChatOnXmlParser().m3552a(this.f1667a);
        ChatONLogWriter.m3511e(strM3552a, getClass().getSimpleName());
        return strM3552a;
    }
}
