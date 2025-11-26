package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2178ad;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.GetPostONList;
import com.sec.chaton.p065io.entry.inner.Multimedia;
import com.sec.chaton.p065io.entry.inner.PostON;
import com.sec.chaton.p065io.entry.inner.PostONEntry;
import com.sec.chaton.p065io.entry.inner.PostONList;
import com.sec.chaton.p065io.entry.inner.PostONMessage;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.poston.C3016k;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: WritePostONTask.java */
/* renamed from: com.sec.chaton.d.a.fl */
/* loaded from: classes.dex */
public class C2047fl extends AbstractC1900a {

    /* renamed from: b */
    private C3016k f7489b;

    /* renamed from: c */
    private ContentResolver f7490c;

    /* renamed from: d */
    private boolean f7491d;

    public C2047fl(C2454e c2454e, C3016k c3016k, String str) {
        super(c2454e);
        this.f7489b = c3016k;
        this.f7490c = CommonApplication.m18732r().getContentResolver();
        if (str.equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
            this.f7491d = true;
        } else {
            this.f7491d = false;
        }
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        PostON postON = new PostON();
        PostONMessage postONMessage = new PostONMessage();
        C4815ag c4815ag = new C4815ag();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("<param>\n");
        if (this.f7489b.m12367b() != null) {
            postON.buddyid = this.f7489b.m12367b();
            String strM18175c = c4815ag.m18175c(postON);
            C4904y.m18646e("yeseul / postonXml = " + strM18175c, getClass().getSimpleName());
            sb.append(strM18175c);
        }
        if (this.f7489b.m12370e() != null) {
            postONMessage.value = this.f7489b.m12370e();
            String strM18175c2 = c4815ag.m18175c(postONMessage);
            C4904y.m18646e("yeseul / messageXml = " + strM18175c2, getClass().getSimpleName());
            sb.append(strM18175c2);
        }
        if (this.f7489b.m12374i() != null && this.f7489b.m12374i().size() > 0) {
            sb.append("<multimedialist>");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f7489b.m12374i().size()) {
                    break;
                }
                Multimedia multimedia = new Multimedia();
                multimedia.host = this.f7489b.m12374i().get(i2).f11124a;
                multimedia.metatype = this.f7489b.m12374i().get(i2).f11126c;
                multimedia.metacontents = this.f7489b.m12374i().get(i2).f11125b;
                arrayList.add(multimedia);
                i = i2 + 1;
            }
            String strM18176d = c4815ag.m18176d(arrayList);
            C4904y.m18646e("yeseul / multimediaXml = " + strM18176d, getClass().getSimpleName());
            sb.append(strM18176d);
            sb.append("</multimedialist>");
        }
        sb.append("</param>");
        C4904y.m18646e("yeseul / StringBuilder sb = " + sb.toString(), getClass().getSimpleName());
        return sb.toString();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        ArrayList<PostONList> arrayList;
        C4904y.m18646e("afterRequest", "WritePostONTask");
        if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR) {
            if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR && (arrayList = ((GetPostONList) c0778b.m3110e()).postonlist) != null && arrayList.size() > 0) {
                PostONList postONList = arrayList.get(0);
                if (postONList == null) {
                    C4904y.m18646e("list is null", "WritePostONTask");
                    return;
                }
                C4904y.m18646e("PostONList:hasmore: " + postONList.hasmore + " isblind: " + postONList.isblind, "WritePostONTask");
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                if (postONList.isblind != null && "true".equals(postONList.isblind)) {
                    C4904y.m18646e("blind is true", "WritePostONTask");
                    if (this.f7491d) {
                        arrayList2.add(C2178ad.m9708a());
                        arrayList2.add(C2178ad.m9719c());
                    } else {
                        arrayList2.add(C2178ad.m9716b());
                        arrayList2.add(C2178ad.m9720d());
                    }
                    this.f7490c.applyBatch("com.sec.chaton.provider", arrayList2);
                    return;
                }
                if (postONList.poston == null) {
                    C4904y.m18646e("list.poston is null", "WritePostONTask");
                    return;
                }
                if (this.f7491d) {
                    arrayList2.add(C2178ad.m9708a());
                    arrayList2.add(C2178ad.m9719c());
                } else {
                    arrayList2.add(C2178ad.m9716b());
                    arrayList2.add(C2178ad.m9720d());
                }
                C4904y.m18646e("insert to DB: " + postONList.poston.size(), "WritePostONTask");
                Iterator<PostONEntry> it = postONList.poston.iterator();
                while (it.hasNext()) {
                    PostONEntry next = it.next();
                    if (this.f7491d) {
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
                this.f7490c.applyBatch("com.sec.chaton.provider", arrayList2);
                return;
            }
            return;
        }
        C2404a.m10430a("01000004", "1003", c0778b);
    }
}
