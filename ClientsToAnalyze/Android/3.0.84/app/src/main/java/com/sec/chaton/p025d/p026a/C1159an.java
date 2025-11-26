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
import com.sec.chaton.p035io.entry.GetPostONList;
import com.sec.chaton.p035io.entry.inner.PostONEntry;
import com.sec.chaton.p035io.entry.inner.PostONList;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: DeletePostONTask.java */
/* renamed from: com.sec.chaton.d.a.an */
/* loaded from: classes.dex */
public class C1159an extends AbstractC1145a {

    /* renamed from: b */
    private ContentResolver f4598b;

    /* renamed from: c */
    private boolean f4599c;

    /* renamed from: e */
    private String f4600e;

    public C1159an(Handler handler, C1580h c1580h, String str, boolean z) {
        super(handler, c1580h);
        this.f4598b = CommonApplication.m11493l().getContentResolver();
        this.f4600e = str;
        this.f4599c = z;
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
            xmlSerializerNewSerializer.startTag("", "postonidlist");
            xmlSerializerNewSerializer.startTag("", "postonid");
            xmlSerializerNewSerializer.text(this.f4600e);
            xmlSerializerNewSerializer.endTag("", "postonid");
            xmlSerializerNewSerializer.endTag("", "postonidlist");
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            C3250y.m11450b(stringWriter.toString(), "DeletePostONTask");
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        ArrayList<PostONList> arrayList;
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            if (c0267d.m11704n() && c0267d.m1354e() != null && c0267d.m1351b() != EnumC1587o.ERROR && (arrayList = ((GetPostONList) c0267d.m1354e()).postonlist) != null && arrayList.size() > 0) {
                PostONList postONList = arrayList.get(0);
                if (postONList == null) {
                    C3250y.m11456e("list is null", "DeletePostONTask");
                    return;
                }
                C3250y.m11456e("PostONList:hasmore: " + postONList.hasmore + " isblind: " + postONList.isblind, "DeletePostONTask");
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                if (postONList.isblind != null && "true".equals(postONList.isblind)) {
                    C3250y.m11456e("blind is true", "DeletePostONTask");
                    if (this.f4599c) {
                        arrayList2.add(C1382z.m6228a());
                        arrayList2.add(C1382z.m6239c());
                    } else {
                        arrayList2.add(C1382z.m6235b());
                        arrayList2.add(C1382z.m6241d());
                    }
                    this.f4598b.applyBatch("com.sec.chaton.provider", arrayList2);
                    return;
                }
                if (postONList.poston == null) {
                    C3250y.m11456e("list.poston is null", "DeletePostONTask");
                    return;
                }
                if (this.f4599c) {
                    arrayList2.add(C1382z.m6228a());
                    arrayList2.add(C1382z.m6239c());
                } else {
                    arrayList2.add(C1382z.m6235b());
                    arrayList2.add(C1382z.m6241d());
                }
                C3250y.m11456e("insert to DB: " + postONList.poston.size(), "DeletePostONTask");
                Iterator<PostONEntry> it = postONList.poston.iterator();
                while (it.hasNext()) {
                    PostONEntry next = it.next();
                    if (this.f4599c) {
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
                this.f4598b.applyBatch("com.sec.chaton.provider", arrayList2);
                return;
            }
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000004", "1004", c0267d);
        }
    }
}
