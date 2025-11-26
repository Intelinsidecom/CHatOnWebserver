package com.sec.chaton.trunk.p058a.p059a;

import android.content.ContentProviderOperation;
import android.os.Handler;
import android.util.Xml;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.trunk.entry.GetItemEntry;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: GetItemTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.e */
/* loaded from: classes.dex */
public class C2954e extends AbstractC1145a {

    /* renamed from: b */
    private static final String f10722b = C2954e.class.getSimpleName();

    /* renamed from: c */
    private boolean f10723c;

    /* renamed from: e */
    private String f10724e;

    /* renamed from: f */
    private String f10725f;

    /* renamed from: g */
    private String f10726g;

    /* renamed from: h */
    private int f10727h;

    /* renamed from: i */
    private int f10728i;

    /* renamed from: j */
    private String f10729j;

    public C2954e(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    public C2954e(Handler handler, C1580h c1580h, boolean z, String str, String str2, String str3, int i, int i2) {
        super(handler, c1580h);
        this.f10723c = z;
        this.f10724e = str;
        this.f10725f = str2;
        this.f10726g = str3;
        this.f10727h = i;
        this.f10728i = i2;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() throws IllegalStateException, IOException, IllegalArgumentException {
        if (this.f10723c) {
            XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
            StringWriter stringWriter = new StringWriter();
            try {
                xmlSerializerNewSerializer.setOutput(stringWriter);
                xmlSerializerNewSerializer.startDocument("UTF-8", true);
                xmlSerializerNewSerializer.startTag("", "param");
                xmlSerializerNewSerializer.startTag("", "sessionid");
                xmlSerializerNewSerializer.text(this.f10724e);
                xmlSerializerNewSerializer.endTag("", "sessionid");
                xmlSerializerNewSerializer.startTag("", "owneruid");
                xmlSerializerNewSerializer.text(this.f10725f);
                xmlSerializerNewSerializer.endTag("", "owneruid");
                xmlSerializerNewSerializer.startTag("", "filename");
                xmlSerializerNewSerializer.text(this.f10726g);
                xmlSerializerNewSerializer.endTag("", "filename");
                xmlSerializerNewSerializer.startTag("", "cmtlist");
                xmlSerializerNewSerializer.text(String.valueOf(this.f10727h));
                xmlSerializerNewSerializer.endTag("", "cmtlist");
                xmlSerializerNewSerializer.startTag("", "thumbnailsize");
                xmlSerializerNewSerializer.text(String.valueOf(this.f10728i));
                xmlSerializerNewSerializer.endTag("", "thumbnailsize");
                xmlSerializerNewSerializer.startTag("", "startcommentid");
                xmlSerializerNewSerializer.text(String.valueOf(1));
                xmlSerializerNewSerializer.endTag("", "startcommentid");
                xmlSerializerNewSerializer.startTag("", "order");
                xmlSerializerNewSerializer.text("asc");
                xmlSerializerNewSerializer.endTag("", "order");
                xmlSerializerNewSerializer.endTag("", "param");
                xmlSerializerNewSerializer.endDocument();
                if (C3250y.f11734b) {
                    C3250y.m11450b(stringWriter.toString(), f10722b);
                }
                return stringWriter.toString();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            ArrayList arrayList = new ArrayList();
            GetItemEntry getItemEntry = (GetItemEntry) c0267d.m1354e();
            if (!this.f10723c) {
                for (NameValuePair nameValuePair : c0267d.m1353d().m6706f()) {
                    if (nameValuePair.getName().equals("itemid")) {
                        this.f10729j = nameValuePair.getValue();
                    }
                    if (nameValuePair.getName().equals("sessionid")) {
                        this.f10724e = nameValuePair.getValue();
                    }
                }
            } else {
                this.f10729j = getItemEntry.item.itemid;
            }
            if (getItemEntry == null) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Http result object is null", f10722b);
                    return;
                }
                return;
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("Save trunk item to database", f10722b);
            }
            getItemEntry.item.sessionid = this.f10724e;
            arrayList.add(C3044a.m10557a(getItemEntry.item));
            if (C3250y.f11734b) {
                C3250y.m11450b("Save trunk comment to database", f10722b);
            }
            for (Comment comment : getItemEntry.item.commentlist.comment) {
                comment.itemid = this.f10729j;
                arrayList.add(C3044a.m10555a(comment));
                if (C3250y.f11734b) {
                    C3250y.m11450b("===========================", f10722b);
                    C3250y.m11450b(comment.toString(), f10722b);
                }
            }
            C3044a.m10565a(CommonApplication.m11493l(), (ArrayList<ContentProviderOperation>) arrayList);
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000016", "0104", c0267d);
        }
    }

    /* renamed from: i */
    public String m10431i() {
        return this.f10729j;
    }
}
