package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.inner.Blind;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BlindPostONTask.java */
/* renamed from: com.sec.chaton.d.a.q */
/* loaded from: classes.dex */
public class C2058q extends AbstractC1900a {

    /* renamed from: b */
    private ArrayList<String> f7518b;

    /* renamed from: c */
    private ArrayList<String> f7519c;

    public C2058q(C2454e c2454e, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        super(c2454e);
        this.f7518b = new ArrayList<>();
        this.f7519c = new ArrayList<>();
        this.f7519c.clear();
        this.f7518b.clear();
        this.f7519c = arrayList;
        this.f7518b = arrayList2;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4904y.m18646e("beforeRequest", "BlindMemoTask");
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f7519c.iterator();
        while (it.hasNext()) {
            arrayList.add(new Blind("false", it.next()));
        }
        Iterator<String> it2 = this.f7518b.iterator();
        while (it2.hasNext()) {
            arrayList.add(new Blind("true", it2.next()));
        }
        String strM18172a = new C4815ag().m18172a(arrayList);
        C4904y.m18646e(strM18172a, "BlindMemoTask");
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        C4904y.m18646e("afterRequest", "BlindMemoTask");
        if (!c0778b.m18954n() || c0778b.m3110e() == null || c0778b.m3107b() == EnumC2464o.ERROR) {
            C2404a.m10430a("01000004", "1202", c0778b);
        }
    }
}
