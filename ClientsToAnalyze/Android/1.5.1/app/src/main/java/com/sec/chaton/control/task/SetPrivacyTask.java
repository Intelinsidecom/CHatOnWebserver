package com.sec.chaton.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatOnXmlParser;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class SetPrivacyTask extends AbstractHttpTask2 {

    /* renamed from: a */
    private String f1668a;

    /* renamed from: b */
    private boolean f1669b;

    public SetPrivacyTask(Handler handler, HttpEnvelope httpEnvelope, String str, boolean z) {
        super(handler, httpEnvelope);
        this.f1668a = str;
        this.f1669b = z;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        ChatOnXmlParser chatOnXmlParser = new ChatOnXmlParser();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("privacy", this.f1668a);
        linkedHashMap.put("value", this.f1669b ? "true" : "false");
        String strM3552a = chatOnXmlParser.m3552a((Object) linkedHashMap);
        ChatONLogWriter.m3511e(strM3552a, getClass().getSimpleName());
        return strM3552a;
    }
}
