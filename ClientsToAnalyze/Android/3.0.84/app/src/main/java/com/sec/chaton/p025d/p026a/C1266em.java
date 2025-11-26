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
import com.sec.chaton.p035io.entry.inner.Multimedia;
import com.sec.chaton.p035io.entry.inner.PostON;
import com.sec.chaton.p035io.entry.inner.PostONEntry;
import com.sec.chaton.p035io.entry.inner.PostONList;
import com.sec.chaton.p035io.entry.inner.PostONMessage;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.poston.C2020k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: WritePostONTask.java */
/* renamed from: com.sec.chaton.d.a.em */
/* loaded from: classes.dex */
public class C1266em extends AbstractC1145a {

    /* renamed from: b */
    private C2020k f4862b;

    /* renamed from: c */
    private ContentResolver f4863c;

    /* renamed from: e */
    private boolean f4864e;

    public C1266em(Handler handler, C1580h c1580h, C2020k c2020k, String str) {
        super(handler, c1580h);
        this.f4862b = c2020k;
        this.f4863c = CommonApplication.m11493l().getContentResolver();
        if (str.equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
            this.f4864e = true;
        } else {
            this.f4864e = false;
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        PostON postON = new PostON();
        PostONMessage postONMessage = new PostONMessage();
        C3164af c3164af = new C3164af();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("<param>\n");
        if (this.f4862b.m8047b() != null) {
            postON.buddyid = this.f4862b.m8047b();
            String strM11029c = c3164af.m11029c(postON);
            C3250y.m11456e("yeseul / postonXml = " + strM11029c, getClass().getSimpleName());
            sb.append(strM11029c);
        }
        if (this.f4862b.m8050e() != null) {
            postONMessage.value = this.f4862b.m8050e();
            String strM11029c2 = c3164af.m11029c(postONMessage);
            C3250y.m11456e("yeseul / messageXml = " + strM11029c2, getClass().getSimpleName());
            sb.append(strM11029c2);
        }
        if (this.f4862b.m8054i() != null && this.f4862b.m8054i().size() > 0) {
            sb.append("<multimedialist>");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f4862b.m8054i().size()) {
                    break;
                }
                Multimedia multimedia = new Multimedia();
                multimedia.host = this.f4862b.m8054i().get(i2).f7728a;
                multimedia.metatype = this.f4862b.m8054i().get(i2).f7730c;
                multimedia.metacontents = this.f4862b.m8054i().get(i2).f7729b;
                arrayList.add(multimedia);
                i = i2 + 1;
            }
            String strM11030d = c3164af.m11030d(arrayList);
            C3250y.m11456e("yeseul / multimediaXml = " + strM11030d, getClass().getSimpleName());
            sb.append(strM11030d);
            sb.append("</multimedialist>");
        }
        sb.append("</param>");
        C3250y.m11456e("yeseul / StringBuilder sb = " + sb.toString(), getClass().getSimpleName());
        return sb.toString();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        ArrayList<PostONList> arrayList;
        C3250y.m11456e("afterRequest", "WritePostONTask");
        if (c0267d.m11704n() && c0267d.m1354e() != null && c0267d.m1351b() != EnumC1587o.ERROR) {
            if (c0267d.m11704n() && c0267d.m1354e() != null && c0267d.m1351b() != EnumC1587o.ERROR && (arrayList = ((GetPostONList) c0267d.m1354e()).postonlist) != null && arrayList.size() > 0) {
                PostONList postONList = arrayList.get(0);
                if (postONList == null) {
                    C3250y.m11456e("list is null", "WritePostONTask");
                    return;
                }
                C3250y.m11456e("PostONList:hasmore: " + postONList.hasmore + " isblind: " + postONList.isblind, "WritePostONTask");
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                if (postONList.isblind != null && "true".equals(postONList.isblind)) {
                    C3250y.m11456e("blind is true", "WritePostONTask");
                    if (this.f4864e) {
                        arrayList2.add(C1382z.m6228a());
                        arrayList2.add(C1382z.m6239c());
                    } else {
                        arrayList2.add(C1382z.m6235b());
                        arrayList2.add(C1382z.m6241d());
                    }
                    this.f4863c.applyBatch("com.sec.chaton.provider", arrayList2);
                    return;
                }
                if (postONList.poston == null) {
                    C3250y.m11456e("list.poston is null", "WritePostONTask");
                    return;
                }
                if (this.f4864e) {
                    arrayList2.add(C1382z.m6228a());
                    arrayList2.add(C1382z.m6239c());
                } else {
                    arrayList2.add(C1382z.m6235b());
                    arrayList2.add(C1382z.m6241d());
                }
                C3250y.m11456e("insert to DB: " + postONList.poston.size(), "WritePostONTask");
                Iterator<PostONEntry> it = postONList.poston.iterator();
                while (it.hasNext()) {
                    PostONEntry next = it.next();
                    if (this.f4864e) {
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
                this.f4863c.applyBatch("com.sec.chaton.provider", arrayList2);
                return;
            }
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000004", "1003", c0267d);
        }
    }
}
