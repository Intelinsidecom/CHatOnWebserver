package com.sec.chaton.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.GetMemoBlindList;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GetMemoBlindListTask extends AbstractHttpTask2 {

    /* renamed from: a */
    private ArrayList f1595a;

    public GetMemoBlindListTask(Handler handler, HttpEnvelope httpEnvelope) {
        super(handler, httpEnvelope);
    }

    /* renamed from: a */
    public void m2151a(ArrayList arrayList) {
        this.f1595a = arrayList;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        ChatONLogWriter.m3511e("afterRequest", "GetMemoBlindListTask");
        if (!httpEntry.m1950a() || httpEntry.m1955d() == null || httpEntry.m1951b() == HttpResultCode.ERROR) {
            return;
        }
        m2151a(((GetMemoBlindList) httpEntry.m1955d()).blind);
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        ChatONLogWriter.m3511e("beforeRequest", "GetMemoBlindListTask");
        return null;
    }
}
