package com.sec.chaton.p055d.p056a;

import android.util.Xml;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: GetFilteredBuddiesListTask.java */
/* renamed from: com.sec.chaton.d.a.bt */
/* loaded from: classes.dex */
public class C1947bt extends AbstractC1900a {

    /* renamed from: b */
    private String f7242b;

    /* renamed from: c */
    private long[] f7243c;

    public C1947bt(C2454e c2454e, String str, long[] jArr) {
        super(c2454e);
        this.f7242b = str;
        this.f7243c = jArr;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        if (this.f7243c.length <= 0) {
            m18922l();
        }
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            xmlSerializerNewSerializer.startTag("", "sns");
            xmlSerializerNewSerializer.attribute("", "sp", this.f7242b);
            for (int i = 0; i < this.f7243c.length; i++) {
                xmlSerializerNewSerializer.startTag("", "friend");
                xmlSerializerNewSerializer.text(String.valueOf(this.f7243c[i]));
                xmlSerializerNewSerializer.endTag("", "friend");
            }
            xmlSerializerNewSerializer.endTag("", "sns");
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            C4904y.m18639b(stringWriter.toString(), getClass().getSimpleName());
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        C4904y.m18639b("afterRequest -start", "[GetFilteredBuddiesListTask]");
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            C4904y.m18639b("afterRequest -sucess -- writing pref time for sns " + this.f7242b, "[GetFilteredBuddiesListTask]");
            if (this.f7242b.equals(C4368e.f15815a)) {
                C4809aa.m18104a().m18124a("last_fb_buddy_sync_time", Long.valueOf(System.currentTimeMillis()));
            } else if (this.f7242b.equals(C4368e.f15818d)) {
                C4809aa.m18104a().m18124a("last_odnok_buddy_sync_time", Long.valueOf(System.currentTimeMillis()));
            } else if (this.f7242b.equals(C4368e.f15820f)) {
                C4809aa.m18104a().m18124a("last_vkontakte_buddy_sync_time", Long.valueOf(System.currentTimeMillis()));
            }
        }
    }
}
