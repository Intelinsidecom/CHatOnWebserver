package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.DownloadSkinEntry;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;

/* compiled from: DownloadSkinTask.java */
/* renamed from: com.sec.chaton.d.a.av */
/* loaded from: classes.dex */
public class C1167av extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4628b = C1167av.class.getSimpleName();

    public C1167av(Handler handler, C1580h c1580h, EnumC1172b enumC1172b) {
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
            C1533b.m6522a("01000011", "1002", c0267d);
        }
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            DownloadSkinEntry downloadSkinEntry = (DownloadSkinEntry) c0267d.m1354e();
            if (downloadSkinEntry == null) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Http result object is null.", f4628b);
                }
            } else if (C3250y.f11734b) {
                C3250y.m11450b(C3364o.m11849a("Entry: ", downloadSkinEntry), f4628b);
            }
        }
    }
}
