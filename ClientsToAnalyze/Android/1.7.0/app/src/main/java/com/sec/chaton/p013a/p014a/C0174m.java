package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.inner.Blind;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1349x;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BlindMemoTask.java */
/* renamed from: com.sec.chaton.a.a.m */
/* loaded from: classes.dex */
public class C0174m extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private ArrayList f419a;

    /* renamed from: b */
    private ArrayList f420b;

    public C0174m(Handler handler, C0503j c0503j, ArrayList arrayList, ArrayList arrayList2) {
        super(handler, c0503j);
        this.f419a = new ArrayList();
        this.f420b = new ArrayList();
        this.f420b.clear();
        this.f419a.clear();
        this.f420b = arrayList;
        this.f419a = arrayList2;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        C1341p.m4662e("beforeRequest", "BlindMemoTask");
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f420b.iterator();
        while (it.hasNext()) {
            arrayList.add(new Blind("false", (String) it.next()));
        }
        Iterator it2 = this.f419a.iterator();
        while (it2.hasNext()) {
            arrayList.add(new Blind("true", (String) it2.next()));
        }
        String strM4714a = new C1349x().m4714a(arrayList);
        C1341p.m4662e(strM4714a, "BlindMemoTask");
        return strM4714a;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        C1341p.m4662e("afterRequest", "BlindMemoTask");
        if (!c0259g.m927a() || c0259g.m932d() == null || c0259g.m928b() != EnumC0518y.ERROR) {
        }
    }
}
