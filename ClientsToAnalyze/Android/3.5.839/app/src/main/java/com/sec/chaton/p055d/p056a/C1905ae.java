package com.sec.chaton.p055d.p056a;

import android.util.Xml;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.inner.CoverStoryAdd;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: CoverStorySampleAddTask.java */
/* renamed from: com.sec.chaton.d.a.ae */
/* loaded from: classes.dex */
public class C1905ae extends AbstractC1900a {

    /* renamed from: b */
    private String f7125b;

    public C1905ae(C2454e c2454e, String str) {
        super(c2454e);
        this.f7125b = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            xmlSerializerNewSerializer.startTag("", "contentid");
            xmlSerializerNewSerializer.text(this.f7125b);
            xmlSerializerNewSerializer.endTag("", "contentid");
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            C4904y.m18639b(stringWriter.toString(), this.f18194f);
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) {
        if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
            CoverStoryAdd coverStoryAdd = (CoverStoryAdd) c0778b.m3110e();
            if (C4904y.f17872b) {
                C4904y.m18639b("CoverStory Add : entry.coverimageregdttm : " + coverStoryAdd.coverimageregdttm + "\n entry.host : " + coverStoryAdd.host + " entry." + coverStoryAdd.metacontents + " entry.metaid" + coverStoryAdd.metaid, getClass().getSimpleName());
            }
        }
    }
}
