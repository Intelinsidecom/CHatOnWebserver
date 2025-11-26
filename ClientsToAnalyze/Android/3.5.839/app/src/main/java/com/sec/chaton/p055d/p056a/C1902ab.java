package com.sec.chaton.p055d.p056a;

import android.util.Xml;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.inner.CoverStoryAdd;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: CoverStoryAddTask.java */
/* renamed from: com.sec.chaton.d.a.ab */
/* loaded from: classes.dex */
public class C1902ab extends AbstractC1900a {

    /* renamed from: b */
    private String f7120b;

    /* renamed from: c */
    private String f7121c;

    /* renamed from: d */
    private String f7122d;

    public C1902ab(C2454e c2454e, String str, String str2, String str3) {
        super(c2454e);
        this.f7120b = str;
        this.f7121c = str2;
        this.f7122d = str3;
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
            xmlSerializerNewSerializer.startTag("", "host");
            xmlSerializerNewSerializer.text(this.f7121c);
            xmlSerializerNewSerializer.endTag("", "host");
            xmlSerializerNewSerializer.startTag("", "metacontents");
            xmlSerializerNewSerializer.text(this.f7122d);
            xmlSerializerNewSerializer.endTag("", "metacontents");
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
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            CoverStoryAdd coverStoryAdd = (CoverStoryAdd) c0778b.m3110e();
            if (C4904y.f17872b) {
                C4904y.m18639b("CoverStory Add : entry.coverimageregdttm : " + coverStoryAdd.coverimageregdttm, getClass().getSimpleName());
                C4904y.m18639b("CoverStory Add : entry.host : " + coverStoryAdd.host, getClass().getSimpleName());
                C4904y.m18639b("CoverStory Add : entry.metacontents : " + coverStoryAdd.metacontents, getClass().getSimpleName());
                C4904y.m18639b("CoverStory Add : entry.contentid : " + coverStoryAdd.contentid, getClass().getSimpleName());
                C4904y.m18639b("CoverStory Add : entry.metaid : " + coverStoryAdd.metaid, getClass().getSimpleName());
                return;
            }
            return;
        }
        CoverStoryAdd coverStoryAdd2 = (CoverStoryAdd) c0778b.m3110e();
        if (C4904y.f17872b) {
            C4904y.m18639b("CoverStory Add : entry.coverimageregdttm : " + coverStoryAdd2.coverimageregdttm + "\n entry.host : " + coverStoryAdd2.host + " entry." + coverStoryAdd2.metacontents + " entry.metaid" + coverStoryAdd2.metaid, getClass().getSimpleName());
        }
        C2404a.m10430a("01000004", "0103", c0778b);
    }
}
