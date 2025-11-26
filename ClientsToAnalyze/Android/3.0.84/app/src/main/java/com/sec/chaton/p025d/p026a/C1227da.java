package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.MappingAccountEntry;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: MappingAccountTask.java */
/* renamed from: com.sec.chaton.d.a.da */
/* loaded from: classes.dex */
public class C1227da extends AbstractC1145a {
    public C1227da(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("email", C3159aa.m10962a().m10979a("samsung_account_email", ""));
        linkedHashMap.put("authcode", C3159aa.m10962a().m10979a("samsung_account_token", ""));
        if (!TextUtils.isEmpty(C3159aa.m10962a().m10979a("samsung_account_api_server", ""))) {
            linkedHashMap.put("api_server", C3159aa.m10962a().m10979a("samsung_account_api_server", ""));
        }
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            MappingAccountEntry mappingAccountEntry = (MappingAccountEntry) c0267d.m1354e();
            String strM10979a = C3159aa.m10962a().m10979a("chaton_id", "");
            if (!TextUtils.isEmpty(strM10979a)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(C1381y.m6226h(CommonApplication.m11493l().getContentResolver(), C3159aa.m10962a().m10979a("chaton_id", ""), mappingAccountEntry.chatonid));
                C3170al.m11043a(CommonApplication.m11493l(), "com.sec.chaton.provider", (ArrayList<ContentProviderOperation>) arrayList);
                arrayList.clear();
            }
            C3159aa.m10962a().m10986b("chaton_id", mappingAccountEntry.chatonid);
            C3159aa.m10962a().m10986b("old_chaton_id", strM10979a);
            C3250y.m11453c("Success, ChatON ID : " + mappingAccountEntry.chatonid, getClass().getSimpleName());
            C3159aa.m10962a().m10981a("samsung_account_token");
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000002", "0201", c0267d);
        }
    }
}
