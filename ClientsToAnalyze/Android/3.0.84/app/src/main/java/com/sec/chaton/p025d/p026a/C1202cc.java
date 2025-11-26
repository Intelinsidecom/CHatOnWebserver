package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1382z;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.GetPostONList;
import com.sec.chaton.p035io.entry.inner.PostONEntry;
import com.sec.chaton.p035io.entry.inner.PostONList;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetPostONListTask.java */
/* renamed from: com.sec.chaton.d.a.cc */
/* loaded from: classes.dex */
public class C1202cc extends AbstractC1145a {

    /* renamed from: b */
    private ContentResolver f4708b;

    /* renamed from: c */
    private boolean f4709c;

    /* renamed from: e */
    private String f4710e;

    /* renamed from: f */
    private boolean f4711f;

    public C1202cc(Handler handler, C1580h c1580h, boolean z, String str) {
        super(handler, c1580h);
        this.f4708b = CommonApplication.m11493l().getContentResolver();
        this.f4709c = z;
        this.f4710e = str;
        if (this.f4710e == C3159aa.m10962a().m10979a("chaton_id", "")) {
            this.f4711f = true;
        } else {
            this.f4711f = false;
        }
        C3250y.m11456e("isMypage : " + this.f4711f, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3250y.m11456e("beforeRequest", "GetPostONListTask");
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        C3250y.m11456e("afterRequest", "GetPostONListTask");
        if (c0267d.m11704n() && c0267d.m1354e() != null && c0267d.m1351b() != EnumC1587o.ERROR) {
            ArrayList<PostONList> arrayList = ((GetPostONList) c0267d.m1354e()).postonlist;
            if (arrayList != null && arrayList.size() > 0) {
                PostONList postONList = arrayList.get(0);
                if (postONList == null) {
                    C3250y.m11456e("list is null", "GetPostONListTask");
                    return;
                }
                C3250y.m11456e("PostONList:hasmore: " + postONList.hasmore + " isblind: " + postONList.isblind, "GetPostONListTask");
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                if (postONList.isblind != null && "true".equals(postONList.isblind)) {
                    C3250y.m11456e("blind is true", "GetPostONListTask");
                    if (this.f4711f) {
                        arrayList2.add(C1382z.m6228a());
                        arrayList2.add(C1382z.m6239c());
                    } else {
                        arrayList2.add(C1382z.m6235b());
                        arrayList2.add(C1382z.m6241d());
                    }
                    this.f4708b.applyBatch("com.sec.chaton.provider", arrayList2);
                    return;
                }
                if (postONList.poston == null) {
                    C3250y.m11456e("list.poston is null", "GetPostONListTask");
                    return;
                }
                if (this.f4709c) {
                    if (this.f4711f) {
                        arrayList2.add(C1382z.m6228a());
                        arrayList2.add(C1382z.m6239c());
                    } else {
                        arrayList2.add(C1382z.m6235b());
                        arrayList2.add(C1382z.m6241d());
                    }
                }
                C3250y.m11456e("insert to DB: " + postONList.poston.size(), "GetPostONListTask");
                Iterator<PostONEntry> it = postONList.poston.iterator();
                while (it.hasNext()) {
                    PostONEntry next = it.next();
                    if (this.f4711f) {
                        Iterator<ContentProviderOperation> it2 = C1382z.m6232a(next).iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(it2.next());
                        }
                    } else {
                        Iterator<ContentProviderOperation> it3 = C1382z.m6238b(next).iterator();
                        while (it3.hasNext()) {
                            arrayList2.add(it3.next());
                        }
                    }
                }
                this.f4708b.applyBatch("com.sec.chaton.provider", arrayList2);
                return;
            }
            C3250y.m11442a("http response, entry is null", "GetPostONListTask");
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000004", "1002", c0267d);
        }
    }
}
