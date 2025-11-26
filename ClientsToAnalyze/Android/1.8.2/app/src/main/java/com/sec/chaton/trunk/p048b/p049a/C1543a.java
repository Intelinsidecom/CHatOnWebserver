package com.sec.chaton.trunk.p048b.p049a;

import android.os.Handler;
import android.util.Xml;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.util.C1786r;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: AddCommentTask.java */
/* renamed from: com.sec.chaton.trunk.b.a.a */
/* loaded from: classes.dex */
public class C1543a extends AbstractRunnableC0532a {

    /* renamed from: d */
    private String f5599d;

    /* renamed from: e */
    private String f5600e;

    /* renamed from: f */
    private String f5601f;

    public C1543a(Handler handler, C0798h c0798h, String str, String str2, String str3) {
        super(handler, c0798h);
        this.f5599d = str;
        this.f5600e = str2;
        this.f5601f = str3;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            xmlSerializerNewSerializer.startTag("", "sessionid");
            xmlSerializerNewSerializer.text(this.f5599d);
            xmlSerializerNewSerializer.endTag("", "sessionid");
            xmlSerializerNewSerializer.startTag("", "itemid");
            xmlSerializerNewSerializer.text(this.f5600e);
            xmlSerializerNewSerializer.endTag("", "itemid");
            xmlSerializerNewSerializer.startTag("", "comment");
            xmlSerializerNewSerializer.cdsect(this.f5601f);
            xmlSerializerNewSerializer.endTag("", "comment");
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            if (C1786r.f6452b) {
                C1786r.m6061b(stringWriter.toString(), C1543a.class.getSimpleName());
            }
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
    }
}
