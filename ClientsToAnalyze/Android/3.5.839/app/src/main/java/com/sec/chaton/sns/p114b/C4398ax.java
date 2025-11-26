package com.sec.chaton.sns.p114b;

import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.sns.C4443c;
import com.sec.chaton.sns.p113a.AbstractC4370g;
import com.sec.chaton.sns.p113a.C4368e;
import p010b.C0320g;
import p010b.InterfaceC0323j;
import p010b.p012b.C0272a;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.sns.b.ax */
/* loaded from: classes.dex */
class C4398ax extends AbstractC4370g {

    /* renamed from: d */
    C0272a f15932d;

    /* renamed from: e */
    final /* synthetic */ C4394at f15933e;

    /* synthetic */ C4398ax(C4394at c4394at, C0272a c0272a, HandlerC4395au handlerC4395au) {
        this(c4394at, c0272a);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C4398ax(C4394at c4394at, C0272a c0272a) {
        super(c4394at, "GetMyInfoTask");
        this.f15933e = c4394at;
        this.f15932d = c0272a;
    }

    @Override // com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        this.f15933e.m16571a("GetMyInfoTask() : Get my name");
        String message = null;
        try {
            InterfaceC0323j interfaceC0323jA_ = C4394at.f15922e.m948a_(this.f15932d.m951a());
            if (interfaceC0323jA_ != null) {
                C4443c.m16824b(this.f15933e.f15830a, String.valueOf(this.f15932d.m951a()));
                C4443c.m16820a(this.f15933e.f15830a, interfaceC0323jA_.m1085b());
                C4443c.m16826c(this.f15933e.f15830a, interfaceC0323jA_.m1087d().toString());
            }
            new C2128i(this.f15933e.f15925h).m9500a(C4368e.f15816b, C4443c.m16825c(this.f15933e.f15830a));
            this.f15835a = -1;
        } catch (C0320g e) {
            e.printStackTrace();
            this.f15835a = -1001;
            message = e.getMessage();
        }
        this.f15836b = message;
        return this.f15835a;
    }
}
