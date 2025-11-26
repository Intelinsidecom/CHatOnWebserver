package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1358b;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.ViewPackageEntry;
import com.sec.chaton.p035io.entry.inner.Package;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: ViewPackageTask.java */
/* renamed from: com.sec.chaton.d.a.ek */
/* loaded from: classes.dex */
public class C1264ek extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4857b = C1198bz.class.getSimpleName();

    public C1264ek(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    public C1264ek(Handler handler, C1580h c1580h, EnumC1172b enumC1172b) {
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
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000011", "0003", c0267d);
        }
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            ViewPackageEntry viewPackageEntry = (ViewPackageEntry) c0267d.m1354e();
            if (viewPackageEntry == null) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Http result object is null.", f4857b);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (C3250y.f11734b) {
                C3250y.m11450b("Save emoticon package to database.", f4857b);
            }
            Package r0 = viewPackageEntry._package;
            if (r0 != null) {
                if (C3250y.f11734b) {
                    C3250y.m11450b(r0.toString(), f4857b);
                }
                arrayList.add(C1358b.m6003a(r0));
            }
            C3170al.m11043a(CommonApplication.m11493l(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
        }
    }
}
