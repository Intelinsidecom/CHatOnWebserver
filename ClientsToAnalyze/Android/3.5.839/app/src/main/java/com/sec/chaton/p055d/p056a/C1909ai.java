package com.sec.chaton.p055d.p056a;

import android.util.Xml;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: DeleteBuddyTask.java */
/* renamed from: com.sec.chaton.d.a.ai */
/* loaded from: classes.dex */
public class C1909ai extends AbstractC1900a {

    /* renamed from: b */
    String f7128b;

    /* renamed from: c */
    String[] f7129c;

    public C1909ai(C2454e c2454e, String str) {
        super(c2454e);
        this.f7128b = str;
        this.f7129c = null;
    }

    public C1909ai(C2454e c2454e, String[] strArr) {
        super(c2454e);
        this.f7128b = strArr[0];
        this.f7129c = strArr;
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
            xmlSerializerNewSerializer.startTag("", "address");
            xmlSerializerNewSerializer.text(this.f7128b);
            xmlSerializerNewSerializer.endTag("", "address");
            if (this.f7129c != null && this.f7129c.length > 1) {
                for (int i = 1; i < this.f7129c.length; i++) {
                    xmlSerializerNewSerializer.startTag("", "address");
                    xmlSerializerNewSerializer.text(this.f7129c[i]);
                    xmlSerializerNewSerializer.endTag("", "address");
                }
            }
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
            if (C4904y.f17872b) {
                C4904y.m18639b("DeleteBuddyTask SUCCESS and getAllBuddies()", this.f18194f);
            }
            new C2128i(null).m9495a();
        } else if (C4904y.f17872b) {
            C4904y.m18639b("DeleteBuddyTask FAIL httpEntry : " + c0778b.m3107b(), this.f18194f);
        }
    }
}
