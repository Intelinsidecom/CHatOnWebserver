package com.sec.chaton.p055d.p056a;

import android.text.TextUtils;
import android.util.Xml;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p067j.C2454e;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: InviteBuddyTask.java */
/* renamed from: com.sec.chaton.d.a.de */
/* loaded from: classes.dex */
public class C1986de extends AbstractC1900a {

    /* renamed from: b */
    private List<String> f7289b;

    /* renamed from: c */
    private EnumC2300t f7290c;

    /* renamed from: d */
    private String f7291d;

    public C1986de(C2454e c2454e) {
        super(c2454e);
    }

    /* renamed from: a */
    public void m9138a(List<String> list) {
        this.f7289b = list;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        xmlSerializerNewSerializer.setOutput(stringWriter);
        xmlSerializerNewSerializer.startDocument("UTF-8", true);
        xmlSerializerNewSerializer.startTag("", "param");
        for (String str : this.f7289b) {
            xmlSerializerNewSerializer.startTag("", "address");
            if (this.f7290c != null) {
                xmlSerializerNewSerializer.attribute("", "chattype", String.valueOf(m9137e()));
            }
            if (!TextUtils.isEmpty(this.f7291d)) {
                xmlSerializerNewSerializer.attribute("", "sessionid", this.f7291d);
            }
            xmlSerializerNewSerializer.text(str);
            xmlSerializerNewSerializer.endTag("", "address");
        }
        xmlSerializerNewSerializer.endTag("", "param");
        xmlSerializerNewSerializer.endDocument();
        return stringWriter.toString();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) {
    }

    /* renamed from: e */
    private int m9137e() {
        switch (this.f7290c) {
            case ONETOONE:
                return 0;
            case GROUPCHAT:
                return 1;
            case BROADCAST:
                return 2;
            case BROADCAST2:
                return 3;
            default:
                throw new IllegalArgumentException("Unknown chat type: " + this.f7290c);
        }
    }
}
