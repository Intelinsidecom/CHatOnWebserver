package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2178ad;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.GetPostONCommentList;
import com.sec.chaton.p065io.entry.inner.PostONComment;
import com.sec.chaton.p065io.entry.inner.PostONCommentList;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetPostONCommentListTask.java */
/* renamed from: com.sec.chaton.d.a.ce */
/* loaded from: classes.dex */
public class C1959ce extends AbstractC1900a {

    /* renamed from: b */
    private ContentResolver f7249b;

    /* renamed from: c */
    private boolean f7250c;

    public C1959ce(C2454e c2454e, boolean z) {
        super(c2454e);
        this.f7249b = CommonApplication.m18732r().getContentResolver();
        this.f7250c = z;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4904y.m18646e("beforeRequest", "GetPostONCommentListTask");
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        C4904y.m18646e("afterRequest", "GetPostONCommentListTask");
        if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR) {
            PostONCommentList postONCommentList = ((GetPostONCommentList) c0778b.m3110e()).commentlist;
            if (postONCommentList == null) {
                C4904y.m18646e("list is null", "GetPostONCommentListTask");
                return;
            }
            C4904y.m18646e("PostONCommentList:hasmore: " + postONCommentList.hasmore + " isblind: " + postONCommentList.isblind, "GetPostONCommentListTask");
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (postONCommentList.isblind != null && "true".equals(postONCommentList.isblind)) {
                C4904y.m18646e("blind is true", "GetPostONCommentListTask");
                arrayList.add(C2178ad.m9721e());
                this.f7249b.applyBatch("com.sec.chaton.provider", arrayList);
                return;
            } else {
                if (postONCommentList.comment == null) {
                    C4904y.m18646e("list.comment is null", "GetPostONCommentListTask");
                    return;
                }
                if (this.f7250c) {
                    arrayList.add(C2178ad.m9721e());
                }
                C4904y.m18646e("insert to DB: " + postONCommentList.comment.size(), "GetPostONCommentListTask");
                Iterator<PostONComment> it = postONCommentList.comment.iterator();
                while (it.hasNext()) {
                    arrayList.add(C2178ad.m9709a(it.next()));
                }
                this.f7249b.applyBatch("com.sec.chaton.provider", arrayList);
                return;
            }
        }
        C2404a.m10430a("01000004", "1101", c0778b);
    }
}
