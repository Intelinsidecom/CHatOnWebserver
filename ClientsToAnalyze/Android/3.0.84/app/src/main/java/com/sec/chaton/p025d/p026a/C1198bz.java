package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1358b;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.GetPackageListEntry;
import com.sec.chaton.p035io.entry.inner.Package;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.NameValuePair;

/* compiled from: GetPackageListTask.java */
/* renamed from: com.sec.chaton.d.a.bz */
/* loaded from: classes.dex */
public class C1198bz extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4696b = C1198bz.class.getSimpleName();

    public C1198bz(Handler handler, C1580h c1580h, EnumC1172b enumC1172b) {
        super(handler, c1580h, enumC1172b);
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
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000011", "0001", c0267d);
        }
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            GetPackageListEntry getPackageListEntry = (GetPackageListEntry) c0267d.m1354e();
            if (getPackageListEntry == null) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Http result object is null.", f4696b);
                    return;
                }
                return;
            }
            Iterator<NameValuePair> it = c0267d.m1353d().m6706f().iterator();
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
            if (C3250y.f11734b) {
                C3250y.m11450b("Remove all anicon packages from database.", f4696b);
            }
            arrayList.add(ContentProviderOperation.newDelete(C1398ap.m6249a(EnumC1399aq.Anicon)).withSelection(C3364o.m11849a("install", " = ?"), new String[]{"0"}).build());
            if (C3250y.f11734b) {
                C3250y.m11450b("Save anicon package to database.", f4696b);
            }
            for (Package r0 : getPackageListEntry.packges) {
                r0.categoryid = value;
                if (C3250y.f11734b) {
                    C3250y.m11450b(r0.toString(), f4696b);
                }
                arrayList.add(C1358b.m6003a(r0));
            }
            C3170al.m11043a(CommonApplication.m11493l(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
            C3159aa.m10962a().m10984b("new_anicon_count", (Integer) 0);
            LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
        }
    }
}
