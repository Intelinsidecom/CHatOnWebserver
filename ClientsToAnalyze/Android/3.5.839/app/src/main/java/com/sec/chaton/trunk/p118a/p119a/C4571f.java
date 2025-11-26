package com.sec.chaton.trunk.p118a.p119a;

import android.content.ContentProviderOperation;
import android.util.Xml;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.AbstractC1900a;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.trunk.database.p122a.C4664a;
import com.sec.chaton.trunk.entry.GetTrunkListEntry;
import com.sec.chaton.trunk.entry.inner.Trunk;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: GetTrunkListTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.f */
/* loaded from: classes.dex */
public class C4571f extends AbstractC1900a {

    /* renamed from: b */
    private static final String f16675b = C4571f.class.getSimpleName();

    /* renamed from: c */
    private List<String> f16676c;

    public C4571f(C2454e c2454e, List<String> list) {
        super(c2454e);
        this.f16676c = list;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        if (this.f16676c == null || this.f16676c.size() == 0) {
            m18922l();
        } else {
            try {
                xmlSerializerNewSerializer.setOutput(stringWriter);
                xmlSerializerNewSerializer.startDocument("UTF-8", true);
                xmlSerializerNewSerializer.startTag("", "param");
                for (String str : this.f16676c) {
                    xmlSerializerNewSerializer.startTag("", "sessionid");
                    xmlSerializerNewSerializer.text(str);
                    xmlSerializerNewSerializer.endTag("", "sessionid");
                }
                xmlSerializerNewSerializer.endTag("", "param");
                xmlSerializerNewSerializer.endDocument();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        C4904y.m18639b(stringWriter.toString(), f16675b);
        return stringWriter.toString();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            GetTrunkListEntry getTrunkListEntry = (GetTrunkListEntry) c0778b.m3110e();
            if (getTrunkListEntry == null) {
                C4904y.m18634a("Http result object is null", f16675b);
                return;
            } else {
                C4904y.m18639b("Save trunk to database", f16675b);
                m17528a(getTrunkListEntry.trunks);
                return;
            }
        }
        C2404a.m10430a("01000016", "0001", c0778b);
    }

    /* renamed from: a */
    public static void m17528a(List<Trunk> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (C4904y.f17872b) {
            C4904y.m18639b("Save trunk to database", f16675b);
        }
        for (Trunk trunk : list) {
            C4904y.m18639b(trunk.toString(), f16675b);
            arrayList.add(C4664a.m17650a(trunk));
            arrayList2.add(C2198l.m9915a(CommonApplication.m18732r().getContentResolver(), trunk.sessionid, trunk.unreaditemcnt.intValue()));
        }
        C4664a.m17660a(CommonApplication.m18732r(), (ArrayList<ContentProviderOperation>) arrayList);
        C2198l.m9933a(CommonApplication.m18732r(), (ArrayList<ContentProviderOperation>) arrayList2);
        C0991aa.m6037a().m18961c(new C1015an(new String[0]));
    }
}
