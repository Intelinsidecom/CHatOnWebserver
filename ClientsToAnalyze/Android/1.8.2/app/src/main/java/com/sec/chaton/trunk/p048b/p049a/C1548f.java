package com.sec.chaton.trunk.p048b.p049a;

import android.os.Handler;
import android.util.Xml;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.trunk.database.p052a.C1584a;
import com.sec.chaton.trunk.entry.GetTrunkListEntry;
import com.sec.chaton.trunk.entry.inner.Trunk;
import com.sec.chaton.util.C1786r;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: GetTrunkListTask.java */
/* renamed from: com.sec.chaton.trunk.b.a.f */
/* loaded from: classes.dex */
public class C1548f extends AbstractRunnableC0532a {

    /* renamed from: d */
    private static final String f5607d = C1548f.class.getSimpleName();

    public C1548f(Handler handler, C0798h c0798h, List list) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        ArrayList<String> arrayListM3016a = C0660d.m3016a(GlobalApplication.m3260b().getContentResolver());
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            for (String str : arrayListM3016a) {
                xmlSerializerNewSerializer.startTag("", "sessionid");
                xmlSerializerNewSerializer.text(str);
                xmlSerializerNewSerializer.endTag("", "sessionid");
            }
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            C1786r.m6061b(stringWriter.toString(), f5607d);
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m665b() == EnumC0803m.SUCCESS) {
            GetTrunkListEntry getTrunkListEntry = (GetTrunkListEntry) c0101b.m671d();
            if (getTrunkListEntry == null) {
                C1786r.m6054a("Http result object is null", f5607d);
            } else {
                C1786r.m6061b("Save trunk to database", f5607d);
                m5404a(getTrunkListEntry.trunks);
            }
        }
    }

    /* renamed from: a */
    public static final void m5404a(List list) {
        ArrayList arrayList = new ArrayList();
        if (C1786r.f6452b) {
            C1786r.m6061b("Save trunk to database", f5607d);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Trunk trunk = (Trunk) it.next();
            C1786r.m6061b(trunk.toString(), f5607d);
            arrayList.add(C1584a.m5465a(trunk));
            C0660d.m3004a(GlobalApplication.m3260b().getContentResolver(), trunk.sessionid, trunk.unreaditemcnt);
        }
        C1584a.m5472a(GlobalApplication.m3260b(), arrayList);
    }
}
