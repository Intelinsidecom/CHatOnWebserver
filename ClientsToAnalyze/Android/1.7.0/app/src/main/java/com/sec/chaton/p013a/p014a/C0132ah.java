package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1349x;
import java.util.List;

/* compiled from: SetAnsNotiReadMessage.java */
/* renamed from: com.sec.chaton.a.a.ah */
/* loaded from: classes.dex */
public class C0132ah extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private List f316a;

    public C0132ah(Handler handler, C0503j c0503j, List list) {
        super(handler, c0503j);
        this.f316a = list;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        if (this.f316a == null || this.f316a.size() == 0) {
            m685c();
            return "";
        }
        String strM4714a = new C1349x().m4714a(this.f316a);
        C1341p.m4662e(strM4714a, getClass().getSimpleName());
        return strM4714a;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
    }
}
