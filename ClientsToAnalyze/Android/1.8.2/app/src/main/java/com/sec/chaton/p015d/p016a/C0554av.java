package com.sec.chaton.p015d.p016a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.p018a.C0663g;
import com.sec.chaton.p017e.p018a.C0664h;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetMemoList;
import com.sec.chaton.p028io.entry.inner.MemoEntry;
import com.sec.chaton.p028io.entry.inner.MemoListEntry;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetMemoListTask.java */
/* renamed from: com.sec.chaton.d.a.av */
/* loaded from: classes.dex */
public class C0554av extends AbstractRunnableC0532a {

    /* renamed from: d */
    private ContentResolver f2231d;

    /* renamed from: e */
    private String f2232e;

    public C0554av(Handler handler, C0798h c0798h, String str) {
        super(handler, c0798h);
        this.f2232e = "";
        this.f2231d = GlobalApplication.m3260b().getContentResolver();
        this.f2232e = str;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1786r.m6066e("beforeRequest", "GetMemoListTask");
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) throws RemoteException, OperationApplicationException {
        C1786r.m6066e("afterRequest", "GetMemoListTask");
        if (c0101b.m664a() && c0101b.m671d() != null && c0101b.m665b() != EnumC0803m.ERROR) {
            GetMemoList getMemoList = (GetMemoList) c0101b.m671d();
            ArrayList arrayList = getMemoList.memolist;
            if (arrayList != null && arrayList.size() > 0) {
                MemoListEntry memoListEntry = (MemoListEntry) arrayList.get(0);
                if (memoListEntry == null) {
                    C1786r.m6066e("entry is null", "GetMemoListTask");
                    return;
                }
                C1786r.m6066e("MemoList euno:hasmore: " + memoListEntry.hasmore + " endtime: " + memoListEntry.endtime + " isblind: " + memoListEntry.isblind, "GetMemoListTask");
                if (memoListEntry.isblind != null && memoListEntry.isblind.equals("true")) {
                    C1786r.m6066e("blind is true", "GetMemoListTask");
                    C0664h.m3039a(this.f2232e, memoListEntry);
                } else {
                    ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                    C0663g.m3034a();
                    C1786r.m6066e("insert to DB: " + getMemoList.memo.size(), "GetMemoListTask");
                    Iterator it = getMemoList.memo.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(C0663g.m3036a((MemoEntry) it.next()));
                    }
                    this.f2231d.applyBatch("com.sec.chaton.provider", arrayList2);
                }
                C0664h.m3039a(this.f2232e, memoListEntry);
                return;
            }
            C1786r.m6054a("http response, entry is null", "GetMemoListTask");
        }
    }
}
