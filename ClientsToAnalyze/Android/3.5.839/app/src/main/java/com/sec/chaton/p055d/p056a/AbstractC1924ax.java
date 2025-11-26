package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0784h;
import com.sec.chaton.util.C4904y;
import com.sec.common.p126d.p127a.p129b.AbstractC4984a;
import com.sec.common.p126d.p127a.p129b.C4985b;

/* compiled from: ExceptionalHttpTextTask.java */
/* renamed from: com.sec.chaton.d.a.ax */
/* loaded from: classes.dex */
public abstract class AbstractC1924ax<ReqType extends C4985b, ResType extends C0784h> extends AbstractC4984a<ReqType, ResType> {
    public AbstractC1924ax(ReqType reqtype) {
        super(reqtype);
    }

    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ResType call() throws Exception {
        try {
            return (ResType) super.call();
        } catch (Error e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, this.f18194f);
            }
            m18919i().m3133a(e);
            throw e;
        } catch (Exception e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, this.f18194f);
            }
            m18919i().m3133a(e2);
            throw e2;
        }
    }
}
