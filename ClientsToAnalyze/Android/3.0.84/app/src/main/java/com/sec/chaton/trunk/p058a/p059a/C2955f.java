package com.sec.chaton.trunk.p058a.p059a;

import android.content.ContentProviderOperation;
import android.os.Handler;
import android.util.Xml;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.trunk.entry.GetTrunkListEntry;
import com.sec.chaton.trunk.entry.inner.Trunk;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: GetTrunkListTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.f */
/* loaded from: classes.dex */
public class C2955f extends AbstractC1145a {

    /* renamed from: b */
    private static final String f10730b = C2955f.class.getSimpleName();

    /* renamed from: c */
    private List<String> f10731c;

    public C2955f(Handler handler, C1580h c1580h, List<String> list) {
        super(handler, c1580h);
        this.f10731c = list;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        if (this.f10731c == null || this.f10731c.size() == 0) {
            m11680p();
        }
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            for (String str : this.f10731c) {
                xmlSerializerNewSerializer.startTag("", "sessionid");
                xmlSerializerNewSerializer.text(str);
                xmlSerializerNewSerializer.endTag("", "sessionid");
            }
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            C3250y.m11450b(stringWriter.toString(), f10730b);
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            GetTrunkListEntry getTrunkListEntry = (GetTrunkListEntry) c0267d.m1354e();
            if (getTrunkListEntry == null) {
                C3250y.m11442a("Http result object is null", f10730b);
                return;
            } else {
                C3250y.m11450b("Save trunk to database", f10730b);
                m10432a(getTrunkListEntry.trunks);
                return;
            }
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000016", "0001", c0267d);
        }
    }

    /* renamed from: a */
    public static final void m10432a(List<Trunk> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (C3250y.f11734b) {
            C3250y.m11450b("Save trunk to database", f10730b);
        }
        for (Trunk trunk : list) {
            C3250y.m11450b(trunk.toString(), f10730b);
            arrayList.add(C3044a.m10556a(trunk));
            arrayList2.add(C1370n.m6111a(CommonApplication.m11493l().getContentResolver(), trunk.sessionid, trunk.unreaditemcnt.intValue()));
        }
        C3044a.m10565a(CommonApplication.m11493l(), (ArrayList<ContentProviderOperation>) arrayList);
        C1370n.m6130a(CommonApplication.m11493l(), (ArrayList<ContentProviderOperation>) arrayList2);
    }
}
