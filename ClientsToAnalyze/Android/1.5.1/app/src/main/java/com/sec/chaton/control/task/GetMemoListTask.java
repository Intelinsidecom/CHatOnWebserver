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
public class GetMemoListTask extends AbstractHttpTask2 {

    /* renamed from: a */
    private ContentResolver f1598a;

    /* renamed from: b */
    private String f1599b;

    public GetMemoListTask(Handler handler, HttpEnvelope httpEnvelope, String str) {
        super(handler, httpEnvelope);
        this.f1599b = "";
        this.f1598a = GlobalApplication.m2387e().getContentResolver();
        this.f1599b = str;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) throws RemoteException, OperationApplicationException {
        ChatONLogWriter.m3511e("afterRequest", "GetMemoListTask");
        if (!httpEntry.m1950a() || httpEntry.m1955d() == null || httpEntry.m1951b() == HttpResultCode.ERROR) {
            ChatONLogWriter.m3511e("http error", "GetMemoListTask");
            return;
        }
        GetMemoList getMemoList = (GetMemoList) httpEntry.m1955d();
        ArrayList arrayList = getMemoList.memolist;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        MemoListEntry memoListEntry = (MemoListEntry) arrayList.get(0);
        if (memoListEntry == null) {
            ChatONLogWriter.m3511e("entry is null", "GetMemoListTask");
            return;
        }
        ChatONLogWriter.m3511e("MemoList euno:" + memoListEntry.hasmore + " " + memoListEntry.endtime + " " + memoListEntry.isblind, "GetMemoListTask");
        if (memoListEntry.isblind == null || !memoListEntry.isblind.equals("true")) {
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
            MemoDatabaseHelper.m2266a();
            Iterator it = getMemoList.memo.iterator();
            while (it.hasNext()) {
                arrayList2.add(MemoDatabaseHelper.m2268a((MemoEntry) it.next()));
            }
            this.f1598a.applyBatch("com.sec.chaton.provider", arrayList2);
        } else {
            ChatONLogWriter.m3511e("blind is true", "GetMemoListTask");
            MemoSessionsDatabaseHelper.m2271a(this.f1599b, memoListEntry);
        }
        MemoSessionsDatabaseHelper.m2271a(this.f1599b, memoListEntry);
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        ChatONLogWriter.m3511e("beforeRequest", "GetMemoListTask");
        return null;
    }
}
