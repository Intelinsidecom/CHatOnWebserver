package com.sec.chaton.trunk.p118a.p119a;

import android.content.ContentProviderResult;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.AbstractC1900a;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.trunk.database.p122a.C4664a;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import org.apache.http.NameValuePair;

/* compiled from: MarkAsReadTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.g */
/* loaded from: classes.dex */
public class C4572g extends AbstractC1900a {

    /* renamed from: b */
    private static final String f16677b = C4572g.class.getSimpleName();

    public C4572g(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        String value;
        String value2;
        String str = "";
        String str2 = "";
        for (NameValuePair nameValuePair : this.f7119a.m10633d()) {
            if (nameValuePair.getName().equals("itemid")) {
                String str3 = str2;
                value2 = nameValuePair.getValue();
                value = str3;
            } else if (nameValuePair.getName().equals("sessionid")) {
                value = nameValuePair.getValue();
                value2 = str;
            } else {
                value = str2;
                value2 = str;
            }
            str = value2;
            str2 = value;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b(String.format("MarkAsRead ItemId: %s", str), f16677b);
        }
        try {
            ContentProviderResult contentProviderResult = C4664a.m17659a(CommonApplication.m18732r(), C4664a.m17663d(str))[0];
            if (contentProviderResult.count.intValue() > 0) {
                C2198l.m9934b(CommonApplication.m18732r().getContentResolver(), str2, contentProviderResult.count.intValue());
                C0991aa.m6037a().m18961c(new C1015an(new String[0]));
                return null;
            }
            return null;
        } catch (Exception e) {
            C4904y.m18635a(e, f16677b);
            return null;
        }
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m3107b() != EnumC2464o.SUCCESS) {
            C2404a.m10430a("01000016", "0101", c0778b);
        }
    }
}
