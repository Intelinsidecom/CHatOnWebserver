package com.sec.chaton.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.inner.Blind;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatOnXmlParser;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BlindMemoTask extends AbstractHttpTask2 {

    /* renamed from: a */
    private ArrayList f1475a;

    /* renamed from: b */
    private ArrayList f1476b;

    public BlindMemoTask(Handler handler, HttpEnvelope httpEnvelope, ArrayList arrayList, ArrayList arrayList2) {
        super(handler, httpEnvelope);
        this.f1475a = new ArrayList();
        this.f1476b = new ArrayList();
        this.f1476b.clear();
        this.f1475a.clear();
        this.f1476b = arrayList;
        this.f1475a = arrayList2;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        ChatONLogWriter.m3511e("afterRequest", "BlindMemoTask");
        if (!httpEntry.m1950a() || httpEntry.m1955d() == null || httpEntry.m1951b() == HttpResultCode.ERROR) {
            return;
        }
        ChatONLogWriter.m3511e("OK", "BlindMemoTask");
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        ChatONLogWriter.m3511e("beforeRequest", "BlindMemoTask");
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f1476b.iterator();
        while (it.hasNext()) {
            arrayList.add(new Blind("false", (String) it.next()));
        }
        Iterator it2 = this.f1475a.iterator();
        while (it2.hasNext()) {
            arrayList.add(new Blind("true", (String) it2.next()));
        }
        String strM3552a = new ChatOnXmlParser().m3552a(arrayList);
        ChatONLogWriter.m3511e(strM3552a, "BlindMemoTask");
        return strM3552a;
    }
}
