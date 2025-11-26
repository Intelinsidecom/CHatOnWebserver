package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;

/* compiled from: CoverStoryDownloadTask.java */
/* renamed from: com.sec.chaton.d.a.ag */
/* loaded from: classes.dex */
public class C1152ag extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4590b = C1152ag.class.getSimpleName();

    public C1152ag(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    protected String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    protected void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1354e() != null && c0267d.m1351b() != EnumC1587o.ERROR) {
            CoverStoryDownload coverStoryDownload = (CoverStoryDownload) c0267d.m1354e();
            if (coverStoryDownload == null) {
                C3250y.m11442a("Http result object is null.", f4590b);
                return;
            } else {
                C3250y.m11456e(" Kmission sampleDownload url : " + coverStoryDownload.fileurl, getClass().getSimpleName());
                return;
            }
        }
        C3250y.m11442a(" Kmission Http Fail", f4590b);
    }
}
