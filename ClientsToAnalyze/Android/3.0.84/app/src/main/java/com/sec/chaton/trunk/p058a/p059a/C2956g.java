package com.sec.chaton.trunk.p058a.p059a;

import android.content.ContentProviderResult;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import org.apache.http.NameValuePair;

/* compiled from: MarkAsReadTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.g */
/* loaded from: classes.dex */
public class C2956g extends AbstractC1145a {

    /* renamed from: b */
    private static final String f10732b = C2956g.class.getSimpleName();

    public C2956g(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        String value;
        String value2;
        String str = "";
        String str2 = "";
        for (NameValuePair nameValuePair : this.f4569a.m6706f()) {
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
        if (C3250y.f11734b) {
            C3250y.m11450b(String.format("MarkAsRead ItemId: %s", str), f10732b);
        }
        try {
            ContentProviderResult contentProviderResult = C3044a.m10564a(CommonApplication.m11493l(), C3044a.m10568d(str))[0];
            if (contentProviderResult.count.intValue() > 0) {
                C1370n.m6131b(CommonApplication.m11493l().getContentResolver(), str2, contentProviderResult.count.intValue());
                return null;
            }
            return null;
        } catch (Exception e) {
            C3250y.m11443a(e, f10732b);
            return null;
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m1351b() != EnumC1587o.SUCCESS && CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000016", "0101", c0267d);
        }
    }
}
