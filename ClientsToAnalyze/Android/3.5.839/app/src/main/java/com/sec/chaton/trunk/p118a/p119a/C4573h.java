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
import com.sec.chaton.trunk.entry.DeleteItemEntry;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: MultiDeleteItemsTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.h */
/* loaded from: classes.dex */
public class C4573h extends AbstractC1900a {

    /* renamed from: c */
    private static final String f16678c = C4573h.class.getSimpleName();

    /* renamed from: b */
    private List<String> f16679b;

    public C4573h(C2454e c2454e, List<String> list) {
        super(c2454e);
        this.f16679b = list;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        if (this.f16679b.size() == 0) {
            m18922l();
        }
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            for (String str : this.f16679b) {
                xmlSerializerNewSerializer.startTag("", "itemid");
                xmlSerializerNewSerializer.text(str);
                xmlSerializerNewSerializer.endTag("", "itemid");
            }
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            if (C4904y.f17872b) {
                C4904y.m18639b(stringWriter.toString(), C4573h.class.getSimpleName());
            }
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        String value;
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            if (C4904y.f17872b) {
                C4904y.m18639b(String.format("Delete trunk item list in database: %s", this.f16679b), f16678c);
            }
            List<NameValuePair> listM10633d = this.f7119a.m10633d();
            DeleteItemEntry deleteItemEntry = (DeleteItemEntry) c0778b.m3110e();
            Iterator<NameValuePair> it = listM10633d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    value = null;
                    break;
                }
                NameValuePair next = it.next();
                if (next.getName().equals("sessionid")) {
                    value = next.getValue();
                    break;
                }
            }
            if (value == null) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("sessionid is null", f16678c);
                    return;
                }
                return;
            } else {
                C4664a.m17659a(CommonApplication.m18732r(), C4664a.m17657a(this.f16679b));
                ArrayList arrayList = new ArrayList();
                arrayList.add(C2198l.m9915a(CommonApplication.m18732r().getContentResolver(), value, deleteItemEntry.summary.unreaditemcnt.intValue()));
                C2198l.m9933a(CommonApplication.m18732r(), (ArrayList<ContentProviderOperation>) arrayList);
                C0991aa.m6037a().m18961c(new C1015an(new String[0]));
                return;
            }
        }
        C2404a.m10430a("01000016", "0108", c0778b);
    }
}
