package com.sec.chaton.shop.p099a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.AbstractC1900a;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.util.C4904y;

/* compiled from: MultiDownloadTask.java */
/* renamed from: com.sec.chaton.shop.a.c */
/* loaded from: classes.dex */
public class C3705c extends AbstractC1900a {
    public C3705c(C2454e c2454e) {
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
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            if (((DownloadRequestEntry) c0778b.m3110e()) == null && C4904y.f17875e) {
                C4904y.m18634a("Http result object is null", this.f18194f);
                return;
            }
            return;
        }
        if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
            if (C4904y.f17875e) {
                C4904y.m18634a("Http result is NO Contents. There is no stamp items for updating.", this.f18194f);
            }
        } else if (C4904y.f17875e) {
            C4904y.m18634a("Http result is failed", this.f18194f);
        }
    }
}
