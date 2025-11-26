package com.sec.chaton.trunk.p043c.p044a;

import android.os.Handler;
import android.util.Xml;
import com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.util.C1341p;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: AddCommentTask.java */
/* renamed from: com.sec.chaton.trunk.c.a.a */
/* loaded from: classes.dex */
public class C1153a extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private String f3996a;

    /* renamed from: b */
    private String f3997b;

    /* renamed from: f */
    private String f3998f;

    public C1153a(Handler handler, C0503j c0503j, String str, String str2, String str3) {
        super(handler, c0503j);
        this.f3996a = str;
        this.f3997b = str2;
        this.f3998f = str3;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            xmlSerializerNewSerializer.startTag("", "sessionid");
            xmlSerializerNewSerializer.text(this.f3996a);
            xmlSerializerNewSerializer.endTag("", "sessionid");
            xmlSerializerNewSerializer.startTag("", "itemid");
            xmlSerializerNewSerializer.text(this.f3997b);
            xmlSerializerNewSerializer.endTag("", "itemid");
            xmlSerializerNewSerializer.startTag("", "comment");
            xmlSerializerNewSerializer.cdsect(this.f3998f);
            xmlSerializerNewSerializer.endTag("", "comment");
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            if (C1341p.f4578b) {
                C1341p.m4658b(stringWriter.toString(), C1153a.class.getSimpleName());
            }
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
    }
}
