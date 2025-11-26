package com.sec.chaton.trunk.p118a.p119a;

import android.content.ContentProviderOperation;
import android.util.Xml;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.AbstractC1900a;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.trunk.database.p122a.C4664a;
import com.sec.chaton.trunk.entry.GetItemEntry;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: GetItemTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.e */
/* loaded from: classes.dex */
public class C4570e extends AbstractC1900a {

    /* renamed from: b */
    private static final String f16667b = C4570e.class.getSimpleName();

    /* renamed from: c */
    private boolean f16668c;

    /* renamed from: d */
    private String f16669d;

    /* renamed from: e */
    private String f16670e;

    /* renamed from: g */
    private String f16671g;

    /* renamed from: h */
    private int f16672h;

    /* renamed from: i */
    private int f16673i;

    /* renamed from: j */
    private String f16674j;

    public C4570e(C2454e c2454e) {
        super(c2454e);
    }

    public C4570e(C2454e c2454e, boolean z, String str, String str2, String str3, int i, int i2) {
        super(c2454e);
        this.f16668c = z;
        this.f16669d = str;
        this.f16670e = str2;
        this.f16671g = str3;
        this.f16672h = i;
        this.f16673i = i2;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() throws IllegalStateException, IOException, IllegalArgumentException {
        if (this.f16668c) {
            XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
            StringWriter stringWriter = new StringWriter();
            try {
                xmlSerializerNewSerializer.setOutput(stringWriter);
                xmlSerializerNewSerializer.startDocument("UTF-8", true);
                xmlSerializerNewSerializer.startTag("", "param");
                xmlSerializerNewSerializer.startTag("", "sessionid");
                xmlSerializerNewSerializer.text(this.f16669d);
                xmlSerializerNewSerializer.endTag("", "sessionid");
                xmlSerializerNewSerializer.startTag("", "owneruid");
                xmlSerializerNewSerializer.text(this.f16670e);
                xmlSerializerNewSerializer.endTag("", "owneruid");
                xmlSerializerNewSerializer.startTag("", "filename");
                xmlSerializerNewSerializer.text(this.f16671g);
                xmlSerializerNewSerializer.endTag("", "filename");
                xmlSerializerNewSerializer.startTag("", "cmtlist");
                xmlSerializerNewSerializer.text(String.valueOf(this.f16672h));
                xmlSerializerNewSerializer.endTag("", "cmtlist");
                xmlSerializerNewSerializer.startTag("", "thumbnailsize");
                xmlSerializerNewSerializer.text(String.valueOf(this.f16673i));
                xmlSerializerNewSerializer.endTag("", "thumbnailsize");
                xmlSerializerNewSerializer.startTag("", "startcommentid");
                xmlSerializerNewSerializer.text(String.valueOf(1));
                xmlSerializerNewSerializer.endTag("", "startcommentid");
                xmlSerializerNewSerializer.startTag("", "order");
                xmlSerializerNewSerializer.text("asc");
                xmlSerializerNewSerializer.endTag("", "order");
                xmlSerializerNewSerializer.endTag("", "param");
                xmlSerializerNewSerializer.endDocument();
                if (C4904y.f17872b) {
                    C4904y.m18639b(stringWriter.toString(), f16667b);
                }
                return stringWriter.toString();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            ArrayList arrayList = new ArrayList();
            GetItemEntry getItemEntry = (GetItemEntry) c0778b.m3110e();
            if (!this.f16668c) {
                for (NameValuePair nameValuePair : c0778b.m3109d().m10633d()) {
                    if (nameValuePair.getName().equals("itemid")) {
                        this.f16674j = nameValuePair.getValue();
                    }
                    if (nameValuePair.getName().equals("sessionid")) {
                        this.f16669d = nameValuePair.getValue();
                    }
                }
            } else {
                this.f16674j = getItemEntry.item.itemid;
            }
            if (getItemEntry == null) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Http result object is null", f16667b);
                    return;
                }
                return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("Save trunk item to database", f16667b);
            }
            getItemEntry.item.sessionid = this.f16669d;
            arrayList.add(C4664a.m17651a(getItemEntry.item));
            if (C4904y.f17872b) {
                C4904y.m18639b("Save trunk comment to database", f16667b);
            }
            for (Comment comment : getItemEntry.item.commentlist.comment) {
                comment.itemid = this.f16674j;
                arrayList.add(C4664a.m17649a(comment));
                if (C4904y.f17872b) {
                    C4904y.m18639b("===========================", f16667b);
                    C4904y.m18639b(comment.toString(), f16667b);
                }
            }
            this.f16672h = getItemEntry.item.totcmtcnt.intValue();
            C4664a.m17660a(CommonApplication.m18732r(), (ArrayList<ContentProviderOperation>) arrayList);
            return;
        }
        C2404a.m10430a("01000016", "0104", c0778b);
    }
}
