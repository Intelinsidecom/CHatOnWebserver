package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.util.Xml;
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
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: DeletePostONCommentTask.java */
/* renamed from: com.sec.chaton.d.a.ak */
/* loaded from: classes.dex */
public class C1911ak extends AbstractC1900a {

    /* renamed from: b */
    private ContentResolver f7131b;

    /* renamed from: c */
    private String f7132c;

    public C1911ak(C2454e c2454e, String str, String str2) {
        super(c2454e);
        this.f7131b = CommonApplication.m18732r().getContentResolver();
        this.f7132c = str2;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            xmlSerializerNewSerializer.startTag("", "commentidlist");
            xmlSerializerNewSerializer.startTag("", "commentid");
            xmlSerializerNewSerializer.text(this.f7132c);
            xmlSerializerNewSerializer.endTag("", "commentid");
            xmlSerializerNewSerializer.endTag("", "commentidlist");
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            C4904y.m18639b(stringWriter.toString(), "DeletePostONCommentTask");
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR) {
                PostONCommentList postONCommentList = ((GetPostONCommentList) c0778b.m3110e()).commentlist;
                if (postONCommentList == null) {
                    C4904y.m18646e("list is null", "DeletePostONCommentTask");
                    return;
                }
                C4904y.m18646e("PostONCommentList:hasmore: " + postONCommentList.hasmore + " isblind: " + postONCommentList.isblind, "DeletePostONCommentTask");
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                if (postONCommentList.isblind != null && "true".equals(postONCommentList.isblind)) {
                    C4904y.m18646e("blind is true", "DeletePostONCommentTask");
                    arrayList.add(C2178ad.m9721e());
                    this.f7131b.applyBatch("com.sec.chaton.provider", arrayList);
                    return;
                } else {
                    if (postONCommentList.comment == null) {
                        C4904y.m18646e("list.comment is null", "DeletePostONCommentTask");
                        return;
                    }
                    arrayList.add(C2178ad.m9721e());
                    C4904y.m18646e("insert to DB: " + postONCommentList.comment.size(), "DeletePostONCommentTask");
                    Iterator<PostONComment> it = postONCommentList.comment.iterator();
                    while (it.hasNext()) {
                        arrayList.add(C2178ad.m9709a(it.next()));
                    }
                    this.f7131b.applyBatch("com.sec.chaton.provider", arrayList);
                    return;
                }
            }
            return;
        }
        C2404a.m10430a("01000004", "1103", c0778b);
    }
}
