package com.sec.chaton.trunk.p058a.p059a;

import android.os.Handler;
import android.util.Xml;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: MultiDeleteItemsTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.h */
/* loaded from: classes.dex */
public class C2957h extends AbstractC1145a {

    /* renamed from: c */
    private static final String f10733c = C2957h.class.getSimpleName();

    /* renamed from: b */
    private List<String> f10734b;

    public C2957h(Handler handler, C1580h c1580h, List<String> list) {
        super(handler, c1580h);
        this.f10734b = list;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        if (this.f10734b.size() == 0) {
            m11680p();
        }
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            for (String str : this.f10734b) {
                xmlSerializerNewSerializer.startTag("", "itemid");
                xmlSerializerNewSerializer.text(str);
                xmlSerializerNewSerializer.endTag("", "itemid");
            }
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            if (C3250y.f11734b) {
                C3250y.m11450b(stringWriter.toString(), C2957h.class.getSimpleName());
            }
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            if (C3250y.f11734b) {
                C3250y.m11450b(String.format("Delete trunk item list in database: %s", this.f10734b), f10733c);
            }
            C3044a.m10564a(CommonApplication.m11493l(), C3044a.m10562a(this.f10734b));
        } else if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000016", "0108", c0267d);
        }
    }
}
