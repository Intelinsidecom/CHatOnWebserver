package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import android.util.Xml;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.inner.CoverStoryAdd;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: CoverStoryAddTask.java */
/* renamed from: com.sec.chaton.d.a.af */
/* loaded from: classes.dex */
public class C1151af extends AbstractC1145a {

    /* renamed from: b */
    private String f4587b;

    /* renamed from: c */
    private String f4588c;

    /* renamed from: e */
    private String f4589e;

    public C1151af(Handler handler, C1580h c1580h, String str, String str2, String str3) {
        super(handler, c1580h);
        this.f4587b = str;
        this.f4588c = str2;
        this.f4589e = str3;
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
            xmlSerializerNewSerializer.startTag("", "host");
            xmlSerializerNewSerializer.text(this.f4588c);
            xmlSerializerNewSerializer.endTag("", "host");
            xmlSerializerNewSerializer.startTag("", "metacontents");
            xmlSerializerNewSerializer.text(this.f4589e);
            xmlSerializerNewSerializer.endTag("", "metacontents");
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
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            CoverStoryAdd coverStoryAdd = (CoverStoryAdd) c0267d.m1354e();
            if (C3250y.f11734b) {
                C3250y.m11450b("CoverStory Add : entry.coverimageregdttm : " + coverStoryAdd.coverimageregdttm, getClass().getSimpleName());
                C3250y.m11450b("CoverStory Add : entry.host : " + coverStoryAdd.host, getClass().getSimpleName());
                C3250y.m11450b("CoverStory Add : entry.metacontents : " + coverStoryAdd.metacontents, getClass().getSimpleName());
                C3250y.m11450b("CoverStory Add : entry.contentid : " + coverStoryAdd.contentid, getClass().getSimpleName());
                C3250y.m11450b("CoverStory Add : entry.metaid : " + coverStoryAdd.metaid, getClass().getSimpleName());
                return;
            }
            return;
        }
        CoverStoryAdd coverStoryAdd2 = (CoverStoryAdd) c0267d.m1354e();
        if (C3250y.f11734b) {
            C3250y.m11450b("CoverStory Add : entry.coverimageregdttm : " + coverStoryAdd2.coverimageregdttm + "\n entry.host : " + coverStoryAdd2.host + " entry." + coverStoryAdd2.metacontents + " entry.metaid" + coverStoryAdd2.metaid, getClass().getSimpleName());
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000004", "0103", c0267d);
        }
    }
}
