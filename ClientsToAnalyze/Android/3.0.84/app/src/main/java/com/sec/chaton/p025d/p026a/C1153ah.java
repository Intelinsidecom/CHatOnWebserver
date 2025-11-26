package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.inner.CoverStory;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: CoverStoryGetTask.java */
/* renamed from: com.sec.chaton.d.a.ah */
/* loaded from: classes.dex */
public class C1153ah extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4591b = C1153ah.class.getSimpleName();

    public C1153ah(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    public C1153ah(Handler handler, C1580h c1580h, String str) {
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
            if (c0267d != null) {
                CoverStory coverStory = (CoverStory) c0267d.m1354e();
                if (coverStory == null) {
                    C3250y.m11442a("Http result object is null.", f4591b);
                    return;
                }
                C3250y.m11456e("coverStoryInfo.contentid : " + coverStory.contentid + ", coverStoryInfo.coverimageregdttm : " + coverStory.coverimageregdttm, getClass().getSimpleName());
                C3250y.m11456e("coverStoryInfo.host : " + coverStory.host, getClass().getSimpleName());
                C3250y.m11456e("coverStoryInfo.metacontents : " + coverStory.metacontents, getClass().getSimpleName());
                C3250y.m11456e("coverStoryInfo.metaid : " + coverStory.metaid, getClass().getSimpleName());
                return;
            }
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
        }
    }
}
