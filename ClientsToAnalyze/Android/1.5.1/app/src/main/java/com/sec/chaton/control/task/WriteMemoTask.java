package com.sec.chaton.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.memo.MemoAdapter;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.inner.Memo;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatOnXmlParser;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class WriteMemoTask extends AbstractHttpTask2 {

    /* renamed from: a */
    private MemoAdapter.MemoItem f1682a;

    public WriteMemoTask(Handler handler, HttpEnvelope httpEnvelope, MemoAdapter.MemoItem memoItem) {
        super(handler, httpEnvelope);
        this.f1682a = memoItem;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        ChatONLogWriter.m3511e("afterRequest", "WriteMemoTask");
        if (!httpEntry.m1950a() || httpEntry.m1955d() == null || httpEntry.m1951b() != HttpResultCode.ERROR) {
        }
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        ArrayList arrayList = new ArrayList();
        Memo memo = new Memo();
        if (this.f1682a.m2399a() != null) {
            memo.buddyid = this.f1682a.m2399a();
        }
        if (this.f1682a.m2401c() != null) {
            memo.value = this.f1682a.m2401c();
        }
        arrayList.add(memo);
        if (arrayList.size() == 0) {
            interrupt();
        }
        String strM3552a = new ChatOnXmlParser().m3552a(arrayList);
        ChatONLogWriter.m3511e(strM3552a, "WriteMemoTask");
        return strM3552a;
    }
}
