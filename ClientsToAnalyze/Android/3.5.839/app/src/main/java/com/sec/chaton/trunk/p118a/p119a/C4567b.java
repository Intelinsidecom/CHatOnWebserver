package com.sec.chaton.trunk.p118a.p119a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.AbstractC1900a;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.trunk.database.p122a.C4664a;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.Iterator;
import org.apache.http.NameValuePair;

/* compiled from: DeleteItemTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.b */
/* loaded from: classes.dex */
public class C4567b extends AbstractC1900a {

    /* renamed from: b */
    private static final String f16662b = C4567b.class.getSimpleName();

    public C4567b(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        String value;
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            Iterator<NameValuePair> it = this.f7119a.m10633d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    value = null;
                    break;
                }
                NameValuePair next = it.next();
                if (next.getName().equals("itemid")) {
                    value = next.getValue();
                    break;
                }
            }
            if (value != null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b(String.format("Delete trunk item in database: %s", value), f16662b);
                }
                C4664a.m17659a(CommonApplication.m18732r(), C4664a.m17661b(value));
                return;
            }
            return;
        }
        C2404a.m10430a("01000016", "0107", c0778b);
    }
}
