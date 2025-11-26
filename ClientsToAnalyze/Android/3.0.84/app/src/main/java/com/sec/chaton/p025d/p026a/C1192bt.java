package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import android.util.Xml;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.util.C3250y;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: GetFilteredBuddiesListTask.java */
/* renamed from: com.sec.chaton.d.a.bt */
/* loaded from: classes.dex */
public class C1192bt extends AbstractC1145a {

    /* renamed from: b */
    private String f4691b;

    /* renamed from: c */
    private long[] f4692c;

    public C1192bt(Handler handler, C1580h c1580h, String str, long[] jArr) {
        super(handler, c1580h);
        this.f4691b = str;
        this.f4692c = jArr;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        if (this.f4692c.length <= 0) {
            m11680p();
        }
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            xmlSerializerNewSerializer.startTag("", "sns");
            xmlSerializerNewSerializer.attribute("", "sp", this.f4691b);
            for (int i = 0; i < this.f4692c.length; i++) {
                xmlSerializerNewSerializer.startTag("", "friend");
                xmlSerializerNewSerializer.text(String.valueOf(this.f4692c[i]));
                xmlSerializerNewSerializer.endTag("", "friend");
            }
            xmlSerializerNewSerializer.endTag("", "sns");
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            C3250y.m11450b(stringWriter.toString(), getClass().getSimpleName());
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
    }
}
