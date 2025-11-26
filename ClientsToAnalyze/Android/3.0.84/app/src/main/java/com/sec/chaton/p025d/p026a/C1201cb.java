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
import com.sec.chaton.p035io.entry.GetPostONCommentList;
import com.sec.chaton.p035io.entry.inner.PostONComment;
import com.sec.chaton.p035io.entry.inner.PostONCommentList;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetPostONCommentListTask.java */
/* renamed from: com.sec.chaton.d.a.cb */
/* loaded from: classes.dex */
public class C1201cb extends AbstractC1145a {

    /* renamed from: b */
    private ContentResolver f4706b;

    /* renamed from: c */
    private boolean f4707c;

    public C1201cb(Handler handler, C1580h c1580h, boolean z) {
        super(handler, c1580h);
        this.f4706b = CommonApplication.m11493l().getContentResolver();
        this.f4707c = z;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3250y.m11456e("beforeRequest", "GetPostONCommentListTask");
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        C3250y.m11456e("afterRequest", "GetPostONCommentListTask");
        if (c0267d.m11704n() && c0267d.m1354e() != null && c0267d.m1351b() != EnumC1587o.ERROR) {
            ArrayList<PostONCommentList> arrayList = ((GetPostONCommentList) c0267d.m1354e()).commentlist;
            if (arrayList != null && arrayList.size() > 0) {
                PostONCommentList postONCommentList = arrayList.get(0);
                if (postONCommentList == null) {
                    C3250y.m11456e("list is null", "GetPostONCommentListTask");
                    return;
                }
                C3250y.m11456e("PostONCommentList:hasmore: " + postONCommentList.hasmore + " isblind: " + postONCommentList.isblind, "GetPostONCommentListTask");
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                if (postONCommentList.isblind != null && "true".equals(postONCommentList.isblind)) {
                    C3250y.m11456e("blind is true", "GetPostONCommentListTask");
                    arrayList2.add(C1382z.m6242e());
                    this.f4706b.applyBatch("com.sec.chaton.provider", arrayList2);
                    return;
                } else {
                    if (postONCommentList.comment == null) {
                        C3250y.m11456e("list.comment is null", "GetPostONCommentListTask");
                        return;
                    }
                    if (this.f4707c) {
                        arrayList2.add(C1382z.m6242e());
                    }
                    C3250y.m11456e("insert to DB: " + postONCommentList.comment.size(), "GetPostONCommentListTask");
                    Iterator<PostONComment> it = postONCommentList.comment.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(C1382z.m6229a(it.next()));
                    }
                    this.f4706b.applyBatch("com.sec.chaton.provider", arrayList2);
                    return;
                }
            }
            C3250y.m11442a("http response, entry is null", "GetPostONCommentListTask");
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000004", "1101", c0267d);
        }
    }
}
