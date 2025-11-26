package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p067j.C2417af;
import com.sec.chaton.p067j.C2422ak;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.InterfaceC2469t;
import com.sec.chaton.util.C4904y;

/* compiled from: AbstractNetTask.java */
/* renamed from: com.sec.chaton.d.a.c */
/* loaded from: classes.dex */
class C1954c implements InterfaceC2469t {

    /* renamed from: a */
    final /* synthetic */ AbstractC1927b f7245a;

    /* renamed from: b */
    private C2426ao f7246b;

    /* renamed from: c */
    private C2422ak f7247c;

    public C1954c(AbstractC1927b abstractC1927b, C2426ao c2426ao, C2422ak c2422ak) {
        this.f7245a = abstractC1927b;
        this.f7246b = c2426ao;
        this.f7247c = c2422ak;
    }

    /* renamed from: a */
    public void m9129a() {
        if (this.f7246b != null) {
            C2417af.m10449a(this.f7247c, this.f7246b);
        } else {
            mo9130a(-1, this.f7246b);
        }
    }

    @Override // com.sec.chaton.p067j.InterfaceC2469t
    /* renamed from: a */
    public void mo9131a(int i, Object obj, Object obj2) {
        C4904y.m18639b("onPostExecute - start", getClass().getSimpleName());
        this.f7245a.mo9092a(i, obj, obj2);
        C4904y.m18639b("onPostExecute - end", getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p067j.InterfaceC2469t
    /* renamed from: a */
    public void mo9130a(int i, Object obj) {
        C4904y.m18639b("onPostExecute - start(error)", getClass().getSimpleName());
        this.f7245a.mo9092a(i, obj, null);
        C4904y.m18639b("onPostExecute - end(error)", getClass().getSimpleName());
    }
}
