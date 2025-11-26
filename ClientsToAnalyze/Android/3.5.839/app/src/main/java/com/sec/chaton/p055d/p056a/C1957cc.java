package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.Intent;
import android.support.v4.content.C0096i;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.GetPackageListEntry;
import com.sec.chaton.p065io.entry.inner.Package;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5052r;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.NameValuePair;

/* compiled from: GetPackageListTask.java */
/* renamed from: com.sec.chaton.d.a.cc */
/* loaded from: classes.dex */
public class C1957cc extends AbstractC1900a {

    /* renamed from: b */
    private static final String f7248b = C1957cc.class.getSimpleName();

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        String value;
        C2404a.m10430a("01000011", "0001", c0778b);
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            GetPackageListEntry getPackageListEntry = (GetPackageListEntry) c0778b.m3110e();
            if (getPackageListEntry == null) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Http result object is null.", f7248b);
                    return;
                }
                return;
            }
            Iterator<NameValuePair> it = c0778b.m3109d().m10633d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    value = null;
                    break;
                }
                NameValuePair next = it.next();
                if (next.getName().equals("categoryid")) {
                    value = next.getValue();
                    break;
                }
            }
            ArrayList arrayList = new ArrayList();
            if (C4904y.f17872b) {
                C4904y.m18639b("Remove all anicon packages from database.", f7248b);
            }
            arrayList.add(ContentProviderOperation.newDelete(C2257bc.m10121a(EnumC2258bd.Anicon)).withSelection(C5052r.m19199a("install", " = ?"), new String[]{Spam.ACTIVITY_CANCEL}).build());
            if (C4904y.f17872b) {
                C4904y.m18639b("Save anicon package to database.", f7248b);
            }
            for (Package r0 : getPackageListEntry.packges) {
                r0.categoryid = value;
                if (C4904y.f17872b) {
                    C4904y.m18639b(r0.toString(), f7248b);
                }
            }
            C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
            C4809aa.m18104a().m18126b("new_anicon_count", (Integer) 0);
            C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("more_tab_badge_update"));
        }
    }
}
