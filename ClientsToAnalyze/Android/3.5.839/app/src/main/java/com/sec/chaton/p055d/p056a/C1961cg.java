package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2178ad;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.GetPostONList;
import com.sec.chaton.p065io.entry.inner.PostONEntry;
import com.sec.chaton.p065io.entry.inner.PostONList;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetPostONListTask.java */
/* renamed from: com.sec.chaton.d.a.cg */
/* loaded from: classes.dex */
public class C1961cg extends AbstractC1900a {

    /* renamed from: b */
    private ContentResolver f7255b;

    /* renamed from: c */
    private boolean f7256c;

    /* renamed from: d */
    private String f7257d;

    /* renamed from: e */
    private boolean f7258e;

    public C1961cg(C2454e c2454e, boolean z, String str) {
        super(c2454e);
        this.f7255b = CommonApplication.m18732r().getContentResolver();
        this.f7256c = z;
        this.f7257d = str;
        if (this.f7257d == C4809aa.m18104a().m18121a("chaton_id", "")) {
            this.f7258e = true;
        } else {
            this.f7258e = false;
        }
        C4904y.m18646e("isMypage : " + this.f7258e, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4904y.m18646e("beforeRequest", "GetPostONListTask");
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        C4904y.m18646e("afterRequest", "GetPostONListTask");
        if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR) {
            ArrayList<PostONList> arrayList = ((GetPostONList) c0778b.m3110e()).postonlist;
            if (arrayList != null && arrayList.size() > 0) {
                PostONList postONList = arrayList.get(0);
                if (postONList == null) {
                    C4904y.m18646e("list is null", "GetPostONListTask");
                    return;
                }
                C4904y.m18646e("PostONList:hasmore: " + postONList.hasmore + " isblind: " + postONList.isblind, "GetPostONListTask");
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                if (postONList.isblind != null && "true".equals(postONList.isblind)) {
                    C4904y.m18646e("blind is true", "GetPostONListTask");
                    if (this.f7258e) {
                        arrayList2.add(C2178ad.m9708a());
                        arrayList2.add(C2178ad.m9719c());
                    } else {
                        arrayList2.add(C2178ad.m9716b());
                        arrayList2.add(C2178ad.m9720d());
                    }
                    this.f7255b.applyBatch("com.sec.chaton.provider", arrayList2);
                    return;
                }
                if (postONList.poston == null) {
                    C4904y.m18646e("list.poston is null", "GetPostONListTask");
                    return;
                }
                if (this.f7256c) {
                    if (this.f7258e) {
                        arrayList2.add(C2178ad.m9708a());
                        arrayList2.add(C2178ad.m9719c());
                    } else {
                        arrayList2.add(C2178ad.m9716b());
                        arrayList2.add(C2178ad.m9720d());
                    }
                }
                C4904y.m18646e("insert to DB: " + postONList.poston.size(), "GetPostONListTask");
                Iterator<PostONEntry> it = postONList.poston.iterator();
                while (it.hasNext()) {
                    PostONEntry next = it.next();
                    if (this.f7258e) {
                        Iterator<ContentProviderOperation> it2 = C2178ad.m9713a(next).iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(it2.next());
                        }
                    } else {
                        Iterator<ContentProviderOperation> it3 = C2178ad.m9718b(next).iterator();
                        while (it3.hasNext()) {
                            arrayList2.add(it3.next());
                        }
                    }
                }
                this.f7255b.applyBatch("com.sec.chaton.provider", arrayList2);
                return;
            }
            C4904y.m18634a("http response, entry is null", "GetPostONListTask");
            return;
        }
        C2404a.m10430a("01000004", "1002", c0778b);
    }
}
