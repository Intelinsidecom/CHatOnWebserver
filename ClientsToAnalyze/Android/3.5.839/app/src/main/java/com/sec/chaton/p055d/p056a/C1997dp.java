package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.MappingAccountEntry;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: MappingAccountTask.java */
/* renamed from: com.sec.chaton.d.a.dp */
/* loaded from: classes.dex */
public class C1997dp extends AbstractC1900a {
    public C1997dp(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("email", C4809aa.m18104a().m18121a("samsung_account_email", ""));
        linkedHashMap.put("authcode", C4809aa.m18104a().m18121a("samsung_account_token", ""));
        if (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("samsung_account_api_server", ""))) {
            linkedHashMap.put("api_server", C4809aa.m18104a().m18121a("samsung_account_api_server", ""));
        }
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            MappingAccountEntry mappingAccountEntry = (MappingAccountEntry) c0778b.m3110e();
            String strM18121a = C4809aa.m18104a().m18121a("chaton_id", "");
            if (!TextUtils.isEmpty(strM18121a)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(C2176ab.m9699h(CommonApplication.m18732r().getContentResolver(), C4809aa.m18104a().m18121a("chaton_id", ""), mappingAccountEntry.chatonid));
                C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider", (ArrayList<ContentProviderOperation>) arrayList);
                arrayList.clear();
            }
            C4809aa.m18104a().m18128b("chaton_id", mappingAccountEntry.chatonid);
            C4809aa.m18104a().m18128b("old_chaton_id", strM18121a);
            C4904y.m18641c("Success, ChatON ID : " + mappingAccountEntry.chatonid, getClass().getSimpleName());
            C4809aa.m18104a().m18123a("samsung_account_token");
            C4809aa.m18107a("last_sync_time_get_mypage_information", (Long) 0L);
            return;
        }
        C2404a.m10430a("01000002", "0201", c0778b);
    }
}
