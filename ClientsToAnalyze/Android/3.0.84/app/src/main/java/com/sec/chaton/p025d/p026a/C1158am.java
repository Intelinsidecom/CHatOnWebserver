package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Xml;
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
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: DeletePostONCommentTask.java */
/* renamed from: com.sec.chaton.d.a.am */
/* loaded from: classes.dex */
public class C1158am extends AbstractC1145a {

    /* renamed from: b */
    private ContentResolver f4596b;

    /* renamed from: c */
    private String f4597c;

    public C1158am(Handler handler, C1580h c1580h, String str, String str2) {
        super(handler, c1580h);
        this.f4596b = CommonApplication.m11493l().getContentResolver();
        this.f4597c = str2;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            xmlSerializerNewSerializer.startTag("", "commentidlist");
            xmlSerializerNewSerializer.startTag("", "commentid");
            xmlSerializerNewSerializer.text(this.f4597c);
            xmlSerializerNewSerializer.endTag("", "commentid");
            xmlSerializerNewSerializer.endTag("", "commentidlist");
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            C3250y.m11450b(stringWriter.toString(), "DeletePostONCommentTask");
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        ArrayList<PostONCommentList> arrayList;
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            if (c0267d.m11704n() && c0267d.m1354e() != null && c0267d.m1351b() != EnumC1587o.ERROR && (arrayList = ((GetPostONCommentList) c0267d.m1354e()).commentlist) != null && arrayList.size() > 0) {
                PostONCommentList postONCommentList = arrayList.get(0);
                if (postONCommentList == null) {
                    C3250y.m11456e("list is null", "DeletePostONCommentTask");
                    return;
                }
                C3250y.m11456e("PostONCommentList:hasmore: " + postONCommentList.hasmore + " isblind: " + postONCommentList.isblind, "DeletePostONCommentTask");
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                if (postONCommentList.isblind != null && "true".equals(postONCommentList.isblind)) {
                    C3250y.m11456e("blind is true", "DeletePostONCommentTask");
                    arrayList2.add(C1382z.m6242e());
                    this.f4596b.applyBatch("com.sec.chaton.provider", arrayList2);
                    return;
                } else {
                    if (postONCommentList.comment == null) {
                        C3250y.m11456e("list.comment is null", "DeletePostONCommentTask");
                        return;
                    }
                    arrayList2.add(C1382z.m6242e());
                    C3250y.m11456e("insert to DB: " + postONCommentList.comment.size(), "DeletePostONCommentTask");
                    Iterator<PostONComment> it = postONCommentList.comment.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(C1382z.m6229a(it.next()));
                    }
                    this.f4596b.applyBatch("com.sec.chaton.provider", arrayList2);
                    return;
                }
            }
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000004", "1103", c0267d);
        }
    }
}
