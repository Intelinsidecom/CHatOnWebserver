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

/* compiled from: GetMemoListMoreTask.java */
/* renamed from: com.sec.chaton.a.a.g */
/* loaded from: classes.dex */
public class C0168g extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private ContentResolver f397a;

    /* renamed from: b */
    private String f398b;

    public C0168g(Handler handler, C0503j c0503j, String str) {
        super(handler, c0503j);
        this.f398b = "";
        this.f397a = GlobalApplication.m3100a().getContentResolver();
        this.f398b = str;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        C1341p.m4662e("beforeRequest", "GetMemoListMoreTask");
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) throws RemoteException, OperationApplicationException {
        C1341p.m4662e("afterRequest", "GetMemoListMoreTask");
        if (c0259g.m927a() && c0259g.m932d() != null && c0259g.m928b() != EnumC0518y.ERROR) {
            GetMemoList getMemoList = (GetMemoList) c0259g.m932d();
            ArrayList arrayList = getMemoList.memolist;
            if (arrayList != null && arrayList.size() > 0) {
                MemoListEntry memoListEntry = (MemoListEntry) arrayList.get(0);
                if (memoListEntry == null) {
                    C1341p.m4662e("entry is null", "GetMemoListMoreTask");
                    return;
                }
                C1341p.m4662e("MemoList :hasmore: " + memoListEntry.hasmore + " endtime: " + memoListEntry.endtime + " isblind: " + memoListEntry.isblind, "GetMemoListMoreTask");
                if (memoListEntry.isblind != null && memoListEntry.isblind.equals("true")) {
                    C1341p.m4662e("blind is true", "GetMemoListMoreTask");
                } else {
                    ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                    C1341p.m4662e("insert to DB" + getMemoList.memo.size(), "GetMemoListMoreTask");
                    Iterator it = getMemoList.memo.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(C0623c.m2852a((MemoEntry) it.next()));
                    }
                    this.f397a.applyBatch("com.sec.chaton.provider", arrayList2);
                }
                C0632l.m2877a(this.f398b, memoListEntry);
                return;
            }
            C1341p.m4651a("http response, entry is null", "GetMemoListMoreTask");
        }
    }
}
