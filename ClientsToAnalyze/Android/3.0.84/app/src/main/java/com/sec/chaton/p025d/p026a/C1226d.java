package com.sec.chaton.p025d.p026a;

import com.sec.chaton.p037j.C1544ac;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1596x;
import com.sec.chaton.p037j.InterfaceC1592t;
import com.sec.chaton.util.C3250y;

/* compiled from: AbstractNetTask.java */
/* renamed from: com.sec.chaton.d.a.d */
/* loaded from: classes.dex */
class C1226d implements InterfaceC1592t {

    /* renamed from: a */
    final /* synthetic */ AbstractC1199c f4746a;

    /* renamed from: b */
    private C1548ag f4747b;

    /* renamed from: c */
    private C1544ac f4748c;

    public C1226d(AbstractC1199c abstractC1199c, C1548ag c1548ag, C1544ac c1544ac) {
        this.f4746a = abstractC1199c;
        this.f4747b = c1548ag;
        this.f4748c = c1544ac;
    }

    /* renamed from: a */
    public void m5551a() {
        if (this.f4747b != null) {
            C1596x.m6751a(this.f4748c, this.f4747b);
        } else {
            mo5552a(-1, this.f4747b);
        }
    }

    @Override // com.sec.chaton.p037j.InterfaceC1592t
    /* renamed from: a */
    public void mo5553a(int i, Object obj, Object obj2) {
        C3250y.m11450b("onPostExecute - start", getClass().getSimpleName());
        this.f4746a.mo5502a(i, obj, obj2);
        C3250y.m11450b("onPostExecute - end", getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p037j.InterfaceC1592t
    /* renamed from: a */
    public void mo5552a(int i, Object obj) {
        C3250y.m11450b("onPostExecute - start(error)", getClass().getSimpleName());
        this.f4746a.mo5502a(i, obj, null);
        C3250y.m11450b("onPostExecute - end(error)", getClass().getSimpleName());
    }
}
