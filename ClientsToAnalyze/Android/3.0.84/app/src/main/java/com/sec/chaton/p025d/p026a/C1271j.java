package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.AmsItemDownloadEntry;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import java.util.Iterator;
import org.apache.http.NameValuePair;

/* compiled from: AmsItemDownloadTask.java */
/* renamed from: com.sec.chaton.d.a.j */
/* loaded from: classes.dex */
public class C1271j extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4876b = C1271j.class.getSimpleName();

    public C1271j(Handler handler, C1580h c1580h, EnumC1172b enumC1172b) {
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
        EnumC1327e enumC1327eM5701a;
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            Iterator<NameValuePair> it = c0267d.m1353d().m6706f().iterator();
            while (true) {
                if (!it.hasNext()) {
                    enumC1327eM5701a = null;
                    break;
                }
                NameValuePair next = it.next();
                if (next.getName().equals(PrefFragmentChats.TYPE)) {
                    enumC1327eM5701a = EnumC1327e.m5701a(next.getValue());
                    break;
                }
            }
            if (enumC1327eM5701a != null) {
                switch (C1272k.f4877a[enumC1327eM5701a.ordinal()]) {
                    case 1:
                        C1533b.m6522a("01000011", "2002", c0267d);
                        break;
                    case 2:
                        C1533b.m6522a("01000011", "2102", c0267d);
                        break;
                    case 3:
                        C1533b.m6522a("01000011", "2202", c0267d);
                        break;
                }
            }
        }
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            AmsItemDownloadEntry amsItemDownloadEntry = (AmsItemDownloadEntry) c0267d.m1354e();
            if (amsItemDownloadEntry == null) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("download_ams, Http result object is null.", f4876b);
                }
            } else if (C3250y.f11734b) {
                C3250y.m11450b(C3364o.m11849a("download_ams, Entry: ", amsItemDownloadEntry), f4876b);
            }
        }
    }
}
