package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.util.Xml;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2178ad;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.GetPostONList;
import com.sec.chaton.p065io.entry.inner.PostONEntry;
import com.sec.chaton.p065io.entry.inner.PostONList;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: DeletePostONTask.java */
/* renamed from: com.sec.chaton.d.a.al */
/* loaded from: classes.dex */
public class C1912al extends AbstractC1900a {

    /* renamed from: b */
    private ContentResolver f7133b;

    /* renamed from: c */
    private boolean f7134c;

    /* renamed from: d */
    private String f7135d;

    public C1912al(C2454e c2454e, String str, boolean z) {
        super(c2454e);
        this.f7133b = CommonApplication.m18732r().getContentResolver();
        this.f7135d = str;
        this.f7134c = z;
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
            xmlSerializerNewSerializer.startTag("", "postonidlist");
            xmlSerializerNewSerializer.startTag("", "postonid");
            xmlSerializerNewSerializer.text(this.f7135d);
            xmlSerializerNewSerializer.endTag("", "postonid");
            xmlSerializerNewSerializer.endTag("", "postonidlist");
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            C4904y.m18639b(stringWriter.toString(), "DeletePostONTask");
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        ArrayList<PostONList> arrayList;
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR && (arrayList = ((GetPostONList) c0778b.m3110e()).postonlist) != null && arrayList.size() > 0) {
                PostONList postONList = arrayList.get(0);
                if (postONList == null) {
                    C4904y.m18646e("list is null", "DeletePostONTask");
                    return;
                }
                C4904y.m18646e("PostONList:hasmore: " + postONList.hasmore + " isblind: " + postONList.isblind, "DeletePostONTask");
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                if (postONList.isblind != null && "true".equals(postONList.isblind)) {
                    C4904y.m18646e("blind is true", "DeletePostONTask");
                    if (this.f7134c) {
                        arrayList2.add(C2178ad.m9708a());
                        arrayList2.add(C2178ad.m9719c());
                    } else {
                        arrayList2.add(C2178ad.m9716b());
                        arrayList2.add(C2178ad.m9720d());
                    }
                    this.f7133b.applyBatch("com.sec.chaton.provider", arrayList2);
                    return;
                }
                if (postONList.poston == null) {
                    C4904y.m18646e("list.poston is null", "DeletePostONTask");
                    return;
                }
                if (this.f7134c) {
                    arrayList2.add(C2178ad.m9708a());
                    arrayList2.add(C2178ad.m9719c());
                } else {
                    arrayList2.add(C2178ad.m9716b());
                    arrayList2.add(C2178ad.m9720d());
                }
                C4904y.m18646e("insert to DB: " + postONList.poston.size(), "DeletePostONTask");
                Iterator<PostONEntry> it = postONList.poston.iterator();
                while (it.hasNext()) {
                    PostONEntry next = it.next();
                    if (this.f7134c) {
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
                this.f7133b.applyBatch("com.sec.chaton.provider", arrayList2);
                return;
            }
            return;
        }
        C2404a.m10430a("01000004", "1004", c0778b);
    }
}
