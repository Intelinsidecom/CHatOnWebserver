package com.sec.chaton.p055d.p056a;

import android.os.Handler;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2466q;
import com.sec.common.CommonApplication;

/* compiled from: AutoResendableNetTask.java */
/* renamed from: com.sec.chaton.d.a.n */
/* loaded from: classes.dex */
public class C2055n extends AbstractC1981d {

    /* renamed from: m */
    protected EnumC2706n f7515m;

    public C2055n(Handler handler, EnumC2706n enumC2706n) {
        super(handler);
        this.f7515m = enumC2706n;
    }

    public C2055n(Handler handler, int i, EnumC2706n enumC2706n) {
        super(handler, i);
        this.f7515m = enumC2706n;
    }

    /* renamed from: c */
    public EnumC2706n m9193c() {
        return this.f7515m;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        super.mo9093b();
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
        super.mo9092a(i, obj, obj2);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    public boolean mo9104a() {
        if (this.f7515m.m11326a() || !C2717y.m11398b()) {
            return super.mo9104a();
        }
        return false;
    }

    /* renamed from: a */
    protected void m9192a(int i, String str) {
        if (C2466q.m10671b(i)) {
            C2198l.m9953f(CommonApplication.m18732r().getContentResolver(), str);
            C0991aa.m6037a().m18961c(new C1015an(new String[]{str}));
        }
    }
}
