package com.sec.chaton.p013a.p014a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.p026a.C0623c;
import com.sec.chaton.p025d.p026a.C0632l;
import com.sec.chaton.p033io.entry.GetMemoList;
import com.sec.chaton.p033io.entry.inner.MemoEntry;
import com.sec.chaton.p033io.entry.inner.MemoListEntry;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetMemoListTask.java */
/* renamed from: com.sec.chaton.a.a.r */
/* loaded from: classes.dex */
public class C0179r extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private ContentResolver f431a;

    /* renamed from: b */
    private String f432b;

    public C0179r(Handler handler, C0503j c0503j, String str) {
        super(handler, c0503j);
        this.f432b = "";
        this.f431a = GlobalApplication.m3100a().getContentResolver();
        this.f432b = str;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        C1341p.m4662e("beforeRequest", "GetMemoListTask");
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) throws RemoteException, OperationApplicationException {
        C1341p.m4662e("afterRequest", "GetMemoListTask");
        if (c0259g.m927a() && c0259g.m932d() != null && c0259g.m928b() != EnumC0518y.ERROR) {
            GetMemoList getMemoList = (GetMemoList) c0259g.m932d();
            ArrayList arrayList = getMemoList.memolist;
            if (arrayList != null && arrayList.size() > 0) {
                MemoListEntry memoListEntry = (MemoListEntry) arrayList.get(0);
                if (memoListEntry == null) {
                    C1341p.m4662e("entry is null", "GetMemoListTask");
                    return;
                }
                C1341p.m4662e("MemoList:hasmore: " + memoListEntry.hasmore + " endtime: " + memoListEntry.endtime + " isblind: " + memoListEntry.isblind, "GetMemoListTask");
                if (memoListEntry.isblind != null && memoListEntry.isblind.equals("true")) {
                    C1341p.m4662e("blind is true", "GetMemoListTask");
                } else {
                    ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                    C0623c.m2850a();
                    C1341p.m4662e("insert to DB: " + getMemoList.memo.size(), "GetMemoListTask");
                    Iterator it = getMemoList.memo.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(C0623c.m2852a((MemoEntry) it.next()));
                    }
                    this.f431a.applyBatch("com.sec.chaton.provider", arrayList2);
                }
                C0632l.m2877a(this.f432b, memoListEntry);
                return;
            }
            C1341p.m4651a("http response, entry is null", "GetMemoListTask");
        }
    }
}
