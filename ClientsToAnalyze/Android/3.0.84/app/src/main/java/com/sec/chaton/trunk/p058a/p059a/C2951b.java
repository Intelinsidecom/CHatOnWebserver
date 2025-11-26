package com.sec.chaton.trunk.p058a.p059a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.Iterator;
import org.apache.http.NameValuePair;

/* compiled from: DeleteItemTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.b */
/* loaded from: classes.dex */
public class C2951b extends AbstractC1145a {

    /* renamed from: b */
    private static final String f10717b = C2951b.class.getSimpleName();

    public C2951b(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        String value;
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            Iterator<NameValuePair> it = this.f4569a.m6706f().iterator();
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
                if (C3250y.f11734b) {
                    C3250y.m11450b(String.format("Delete trunk item in database: %s", value), f10717b);
                }
                C3044a.m10564a(CommonApplication.m11493l(), C3044a.m10566b(value));
                return;
            }
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000016", "0107", c0267d);
        }
    }
}
