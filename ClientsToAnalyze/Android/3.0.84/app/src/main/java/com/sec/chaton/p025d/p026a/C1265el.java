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
import com.sec.chaton.p035io.entry.inner.Comment;
import com.sec.chaton.p035io.entry.inner.PostONComment;
import com.sec.chaton.p035io.entry.inner.PostONCommentList;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.poston.C2025p;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: WritePostONCommentTask.java */
/* renamed from: com.sec.chaton.d.a.el */
/* loaded from: classes.dex */
public class C1265el extends AbstractC1145a {

    /* renamed from: b */
    private C2025p f4858b;

    /* renamed from: c */
    private String f4859c;

    /* renamed from: e */
    private String f4860e;

    /* renamed from: f */
    private ContentResolver f4861f;

    public C1265el(Handler handler, C1580h c1580h, String str, C2025p c2025p, String str2) {
        super(handler, c1580h);
        this.f4858b = c2025p;
        this.f4859c = str;
        this.f4860e = str2;
        this.f4861f = CommonApplication.m11493l().getContentResolver();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        ArrayList arrayList = new ArrayList();
        Comment comment = new Comment();
        if (this.f4859c != null) {
            comment.buddyid = this.f4859c;
        }
        if (this.f4860e != null) {
            comment.parentpostonid = this.f4860e;
        }
        if (this.f4858b.m8064c() != null) {
            comment.value = this.f4858b.m8064c();
        }
        arrayList.add(comment);
        if (arrayList.size() == 0) {
            m11680p();
        }
        String strM11026a = new C3164af().m11026a(arrayList);
        C3250y.m11456e(strM11026a, "WritePostONCommentTask");
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        ArrayList<PostONCommentList> arrayList;
        C3250y.m11456e("afterRequest", "WritePostONCommentTask");
        if (c0267d.m11704n() && c0267d.m1354e() != null && c0267d.m1351b() != EnumC1587o.ERROR) {
            if (c0267d.m11704n() && c0267d.m1354e() != null && c0267d.m1351b() != EnumC1587o.ERROR && (arrayList = ((GetPostONCommentList) c0267d.m1354e()).commentlist) != null && arrayList.size() > 0) {
                PostONCommentList postONCommentList = arrayList.get(0);
                if (postONCommentList == null) {
                    C3250y.m11456e("list is null", "WritePostONCommentTask");
                    return;
                }
                C3250y.m11456e("PostONCommentList:hasmore: " + postONCommentList.hasmore + " isblind: " + postONCommentList.isblind, "WritePostONCommentTask");
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                if (postONCommentList.isblind != null && "true".equals(postONCommentList.isblind)) {
                    C3250y.m11456e("blind is true", "WritePostONCommentTask");
                    arrayList2.add(C1382z.m6242e());
                    return;
                } else {
                    if (postONCommentList.comment == null) {
                        C3250y.m11456e("list.comment is null", "WritePostONCommentTask");
                        return;
                    }
                    arrayList2.add(C1382z.m6242e());
                    C3250y.m11456e("insert to DB: " + postONCommentList.comment.size(), "WritePostONCommentTask");
                    Iterator<PostONComment> it = postONCommentList.comment.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(C1382z.m6229a(it.next()));
                    }
                    this.f4861f.applyBatch("com.sec.chaton.provider", arrayList2);
                    return;
                }
            }
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000004", "1102", c0267d);
        }
    }
}
