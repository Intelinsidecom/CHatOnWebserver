package com.sec.chaton.control.task;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.database.helper.MemoDatabaseHelper;
import com.sec.chaton.database.helper.MemoSessionsDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.GetMemoList;
import com.sec.chaton.p000io.entry.inner.MemoEntry;
import com.sec.chaton.p000io.entry.inner.MemoListEntry;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetMemoListMoreTask extends AbstractHttpTask2 {

    /* renamed from: a */
    private ContentResolver f1596a;

    /* renamed from: b */
    private String f1597b;

    public GetMemoListMoreTask(Handler handler, HttpEnvelope httpEnvelope, String str) {
        super(handler, httpEnvelope);
        this.f1597b = "";
        this.f1596a = GlobalApplication.m2387e().getContentResolver();
        this.f1597b = str;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) throws RemoteException, OperationApplicationException {
        ChatONLogWriter.m3511e("afterRequest", "GetMemoListMoreTask");
        if (!httpEntry.m1950a() || httpEntry.m1955d() == null || httpEntry.m1951b() == HttpResultCode.ERROR) {
            ChatONLogWriter.m3511e("http error", "GetMemoListMoreTask");
            return;
        }
        GetMemoList getMemoList = (GetMemoList) httpEntry.m1955d();
        ArrayList arrayList = getMemoList.memolist;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        MemoListEntry memoListEntry = (MemoListEntry) arrayList.get(0);
        if (memoListEntry == null) {
            ChatONLogWriter.m3511e("entary is null", "GetMemoListMoreTask");
            return;
        }
        ChatONLogWriter.m3511e("MemoList euno:" + memoListEntry.hasmore + " " + memoListEntry.endtime + " " + memoListEntry.isblind, "GetMemoListMoreTask");
        if (memoListEntry.isblind == null || !memoListEntry.isblind.equals("true")) {
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
            Iterator it = getMemoList.memo.iterator();
            while (it.hasNext()) {
                arrayList2.add(MemoDatabaseHelper.m2268a((MemoEntry) it.next()));
            }
            this.f1596a.applyBatch("com.sec.chaton.provider", arrayList2);
        } else {
            ChatONLogWriter.m3511e("blind is true", "GetMemoListMoreTask");
        }
        MemoSessionsDatabaseHelper.m2271a(this.f1597b, memoListEntry);
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        ChatONLogWriter.m3511e("beforeRequest", "GetMemoListMoreTask");
        return null;
    }
}
