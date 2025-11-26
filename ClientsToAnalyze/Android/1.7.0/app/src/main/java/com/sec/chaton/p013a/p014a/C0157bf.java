package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.inner.Buddyid;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1349x;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: PutInteractionHideTask.java */
/* renamed from: com.sec.chaton.a.a.bf */
/* loaded from: classes.dex */
public class C0157bf extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private ArrayList f375a;

    /* renamed from: b */
    private ArrayList f376b;

    public C0157bf(Handler handler, C0503j c0503j, ArrayList arrayList, ArrayList arrayList2) {
        super(handler, c0503j);
        this.f375a = new ArrayList();
        this.f376b = new ArrayList();
        this.f376b.clear();
        this.f375a.clear();
        this.f376b = arrayList;
        this.f375a = arrayList2;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        C1341p.m4662e("beforeRequest", "InteractionHideTask");
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f376b.iterator();
        while (it.hasNext()) {
            arrayList.add(new Buddyid("false", (String) it.next()));
        }
        Iterator it2 = this.f375a.iterator();
        while (it2.hasNext()) {
            arrayList.add(new Buddyid("true", (String) it2.next()));
        }
        String strM4714a = new C1349x().m4714a(arrayList);
        C1341p.m4662e(strM4714a, "InteractionHideTask");
        return strM4714a;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        C1341p.m4662e("afterRequest", "InteractionHideTask");
        if (!c0259g.m927a() || c0259g.m932d() == null || c0259g.m928b() != EnumC0518y.ERROR) {
        }
    }
}
