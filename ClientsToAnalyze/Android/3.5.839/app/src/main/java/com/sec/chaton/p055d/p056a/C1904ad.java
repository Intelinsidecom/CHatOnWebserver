package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.inner.CoverStory;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;

/* compiled from: CoverStoryGetTask.java */
/* renamed from: com.sec.chaton.d.a.ad */
/* loaded from: classes.dex */
public class C1904ad extends AbstractC1900a {

    /* renamed from: b */
    private static final String f7124b = C1904ad.class.getSimpleName();

    public C1904ad(C2454e c2454e, String str) {
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
        if (c0778b != null && c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR) {
            CoverStory coverStory = (CoverStory) c0778b.m3110e();
            if (coverStory == null) {
                C4904y.m18634a("Http result object is null.", f7124b);
                return;
            }
            C4904y.m18646e("coverStoryInfo.contentid : " + coverStory.contentid + ", coverStoryInfo.coverimageregdttm : " + coverStory.coverimageregdttm, getClass().getSimpleName());
            C4904y.m18646e("coverStoryInfo.host : " + coverStory.host, getClass().getSimpleName());
            C4904y.m18646e("coverStoryInfo.metacontents : " + coverStory.metacontents, getClass().getSimpleName());
            C4904y.m18646e("coverStoryInfo.metaid : " + coverStory.metaid, getClass().getSimpleName());
        }
    }
}
