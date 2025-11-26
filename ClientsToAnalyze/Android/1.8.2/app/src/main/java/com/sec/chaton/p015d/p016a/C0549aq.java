package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import android.util.Xml;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.util.C1786r;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: GetFilteredBuddiesListTask.java */
/* renamed from: com.sec.chaton.d.a.aq */
/* loaded from: classes.dex */
public class C0549aq extends AbstractRunnableC0532a {

    /* renamed from: d */
    private String f2225d;

    /* renamed from: e */
    private long[] f2226e;

    public C0549aq(Handler handler, C0798h c0798h, String str, long[] jArr) {
        super(handler, c0798h);
        this.f2225d = str;
        this.f2226e = jArr;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        if (this.f2226e.length <= 0) {
            m2710c();
        }
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            xmlSerializerNewSerializer.startTag("", "sns");
            xmlSerializerNewSerializer.attribute("", "sp", this.f2225d);
            for (int i = 0; i < this.f2226e.length; i++) {
                xmlSerializerNewSerializer.startTag("", "friend");
                xmlSerializerNewSerializer.text(String.valueOf(this.f2226e[i]));
                xmlSerializerNewSerializer.endTag("", "friend");
            }
            xmlSerializerNewSerializer.endTag("", "sns");
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            C1786r.m6061b(stringWriter.toString(), getClass().getSimpleName());
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
    }
}
