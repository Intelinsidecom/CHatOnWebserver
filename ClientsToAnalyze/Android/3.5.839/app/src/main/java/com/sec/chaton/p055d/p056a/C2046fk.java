package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2178ad;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.GetPostONCommentList;
import com.sec.chaton.p065io.entry.inner.Comment;
import com.sec.chaton.p065io.entry.inner.PostONComment;
import com.sec.chaton.p065io.entry.inner.PostONCommentList;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.poston.C3021p;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: WritePostONCommentTask.java */
/* renamed from: com.sec.chaton.d.a.fk */
/* loaded from: classes.dex */
public class C2046fk extends AbstractC1900a {

    /* renamed from: b */
    private C3021p f7485b;

    /* renamed from: c */
    private String f7486c;

    /* renamed from: d */
    private String f7487d;

    /* renamed from: e */
    private ContentResolver f7488e;

    public C2046fk(C2454e c2454e, String str, C3021p c3021p, String str2) {
        super(c2454e);
        this.f7485b = c3021p;
        this.f7486c = str;
        this.f7487d = str2;
        this.f7488e = CommonApplication.m18732r().getContentResolver();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        ArrayList arrayList = new ArrayList();
        Comment comment = new Comment();
        if (this.f7486c != null) {
            comment.buddyid = this.f7486c;
        }
        if (this.f7487d != null) {
            comment.parentpostonid = this.f7487d;
        }
        if (this.f7485b.m12384c() != null) {
            comment.value = this.f7485b.m12384c();
        }
        arrayList.add(comment);
        if (arrayList.size() == 0) {
            m18922l();
        }
        String strM18172a = new C4815ag().m18172a(arrayList);
        C4904y.m18646e(strM18172a, "WritePostONCommentTask");
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        C4904y.m18646e("afterRequest", "WritePostONCommentTask");
        if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR) {
            if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR) {
                PostONCommentList postONCommentList = ((GetPostONCommentList) c0778b.m3110e()).commentlist;
                if (postONCommentList == null) {
                    C4904y.m18646e("list is null", "WritePostONCommentTask");
                    return;
                }
                C4904y.m18646e("PostONCommentList:hasmore: " + postONCommentList.hasmore + " isblind: " + postONCommentList.isblind, "WritePostONCommentTask");
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                if (postONCommentList.isblind != null && "true".equals(postONCommentList.isblind)) {
                    C4904y.m18646e("blind is true", "WritePostONCommentTask");
                    arrayList.add(C2178ad.m9721e());
                    return;
                } else {
                    if (postONCommentList.comment == null) {
                        C4904y.m18646e("list.comment is null", "WritePostONCommentTask");
                        return;
                    }
                    arrayList.add(C2178ad.m9721e());
                    C4904y.m18646e("insert to DB: " + postONCommentList.comment.size(), "WritePostONCommentTask");
                    Iterator<PostONComment> it = postONCommentList.comment.iterator();
                    while (it.hasNext()) {
                        arrayList.add(C2178ad.m9709a(it.next()));
                    }
                    this.f7488e.applyBatch("com.sec.chaton.provider", arrayList);
                    return;
                }
            }
            return;
        }
        C2404a.m10430a("01000004", "1102", c0778b);
    }
}
