package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import android.util.Xml;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.inner.CoverStoryAdd;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: CoverStorySampleAddTask.java */
/* renamed from: com.sec.chaton.d.a.ai */
/* loaded from: classes.dex */
public class C1154ai extends AbstractC1145a {

    /* renamed from: b */
    private String f4592b;

    public C1154ai(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4592b = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    protected String mo5496f() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            xmlSerializerNewSerializer.startTag("", "contentid");
            xmlSerializerNewSerializer.text(this.f4592b);
            xmlSerializerNewSerializer.endTag("", "contentid");
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            C3250y.m11450b(stringWriter.toString(), this.f11982d);
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    protected void mo5488a(C0267d c0267d) {
        if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
            CoverStoryAdd coverStoryAdd = (CoverStoryAdd) c0267d.m1354e();
            if (C3250y.f11734b) {
                C3250y.m11450b("CoverStory Add : entry.coverimageregdttm : " + coverStoryAdd.coverimageregdttm + "\n entry.host : " + coverStoryAdd.host + " entry." + coverStoryAdd.metacontents + " entry.metaid" + coverStoryAdd.metaid, getClass().getSimpleName());
            }
        }
    }
}
