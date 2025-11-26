package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;

/* compiled from: CoverStoryDownloadTask.java */
/* renamed from: com.sec.chaton.d.a.ac */
/* loaded from: classes.dex */
public class C1903ac extends AbstractC1900a {

    /* renamed from: b */
    private static final String f7123b = C1903ac.class.getSimpleName();

    public C1903ac(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR) {
            CoverStoryDownload coverStoryDownload = (CoverStoryDownload) c0778b.m3110e();
            if (coverStoryDownload == null) {
                C4904y.m18634a("Http result object is null.", f7123b);
                return;
            } else {
                C4904y.m18646e("sampleDownload url : " + coverStoryDownload.fileurl, getClass().getSimpleName());
                return;
            }
        }
        C4904y.m18634a("Http Fail after CoverStoryDownloadTask", f7123b);
    }
}
