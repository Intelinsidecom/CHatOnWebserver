package com.sec.chaton.trunk.p043c.p044a;

import android.os.Handler;
import android.util.Xml;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.trunk.database.p046a.C1173b;
import com.sec.chaton.trunk.entry.GetTrunkListEntry;
import com.sec.chaton.trunk.entry.inner.Trunk;
import com.sec.chaton.util.C1341p;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: GetTrunkListTask.java */
/* renamed from: com.sec.chaton.trunk.c.a.g */
/* loaded from: classes.dex */
public class C1159g extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private static final String f4006a = C1159g.class.getSimpleName();

    /* renamed from: b */
    private List f4007b;

    public C1159g(Handler handler, C0503j c0503j, List list) {
        super(handler, c0503j);
        this.f4007b = list;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        if (this.f4007b == null) {
            this.f4007b = C0634n.m2903a(GlobalApplication.m3100a().getContentResolver());
        }
        if (this.f4007b.size() == 0) {
            m685c();
        }
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            for (String str : this.f4007b) {
                xmlSerializerNewSerializer.startTag("", "sessionid");
                xmlSerializerNewSerializer.text(str);
                xmlSerializerNewSerializer.endTag("", "sessionid");
            }
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            C1341p.m4658b(stringWriter.toString(), f4006a);
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        if (c0259g.m928b() == EnumC0518y.SUCCESS) {
            GetTrunkListEntry getTrunkListEntry = (GetTrunkListEntry) c0259g.m932d();
            if (getTrunkListEntry == null) {
                C1341p.m4651a("Http result object is null", f4006a);
                return;
            }
            ArrayList arrayList = new ArrayList();
            List<Trunk> list = getTrunkListEntry.trunks;
            C1341p.m4658b("Save trunk to database", f4006a);
            for (Trunk trunk : list) {
                C1341p.m4658b(trunk.toString(), f4006a);
                arrayList.add(C1173b.m4231a(trunk));
                C0634n.m2890a(GlobalApplication.m3100a().getContentResolver(), trunk.sessionid, trunk.unreaditemcnt);
            }
            C1173b.m4238a(GlobalApplication.m3100a(), arrayList);
        }
    }
}
