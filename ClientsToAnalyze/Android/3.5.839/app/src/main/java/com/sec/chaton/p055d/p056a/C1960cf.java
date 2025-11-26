package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2178ad;
import com.sec.chaton.p065io.entry.GetPostONDetailInfoList;
import com.sec.chaton.p065io.entry.inner.PostONComment;
import com.sec.chaton.p065io.entry.inner.PostONCommentList;
import com.sec.chaton.p065io.entry.inner.PostONDetailEntry;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetPostONDetailInfoListTask.java */
/* renamed from: com.sec.chaton.d.a.cf */
/* loaded from: classes.dex */
public class C1960cf extends AbstractC1900a {

    /* renamed from: b */
    private ContentResolver f7251b;

    /* renamed from: c */
    private String f7252c;

    /* renamed from: d */
    private String f7253d;

    /* renamed from: e */
    private boolean f7254e;

    public C1960cf(C2454e c2454e, String str, String str2) {
        super(c2454e);
        this.f7251b = CommonApplication.m18732r().getContentResolver();
        this.f7252c = str;
        this.f7253d = str2;
        if (this.f7252c.equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
            this.f7254e = true;
        } else {
            this.f7254e = false;
        }
        C4904y.m18646e("isMypage : " + this.f7254e, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        if (C4904y.f17871a) {
            C4904y.m18646e("beforeRequest", "GetPostONDetailInfoListTask");
            return null;
        }
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        GetPostONDetailInfoList getPostONDetailInfoList;
        PostONDetailEntry postONDetailEntry;
        if (C4904y.f17871a) {
            C4904y.m18646e("afterRequest", "GetPostONDetailInfoListTask");
        }
        if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR && (getPostONDetailInfoList = (GetPostONDetailInfoList) c0778b.m3110e()) != null && getPostONDetailInfoList.isblind.equals("false") && (postONDetailEntry = getPostONDetailInfoList.poston) != null) {
            PostONCommentList postONCommentList = postONDetailEntry.commentlist;
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (C4904y.f17871a) {
                C4904y.m18646e("PostONList:postonid: " + postONDetailEntry.postonid + "/ message: " + postONDetailEntry.postonmessage + "/ sender : " + postONDetailEntry.sender + "/ sendername : " + postONDetailEntry.sendername, "GetPostONDetailInfoListTask");
            }
            if (this.f7254e) {
                Iterator<ContentProviderOperation> it = C2178ad.m9712a(postONDetailEntry).iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
            if (postONCommentList.comment.isEmpty() && C4904y.f17871a) {
                C4904y.m18646e("list.comment is null", "GetPostONDetailInfoListTask");
            }
            arrayList.add(C2178ad.m9721e());
            if (C4904y.f17871a) {
                C4904y.m18646e("insert to DB: " + postONCommentList.comment.size(), "GetPostONDetailInfoListTask");
            }
            Iterator<PostONComment> it2 = postONCommentList.comment.iterator();
            while (it2.hasNext()) {
                arrayList.add(C2178ad.m9709a(it2.next()));
            }
            this.f7251b.applyBatch("com.sec.chaton.provider", arrayList);
        }
    }
}
