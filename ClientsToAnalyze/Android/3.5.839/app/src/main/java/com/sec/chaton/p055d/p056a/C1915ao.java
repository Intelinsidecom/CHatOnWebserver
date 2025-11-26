package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.inner.Timestamp;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DeleteUpdateTask.java */
/* renamed from: com.sec.chaton.d.a.ao */
/* loaded from: classes.dex */
public class C1915ao extends AbstractC1900a {

    /* renamed from: b */
    private ArrayList<String> f7142b;

    public C1915ao(C2454e c2454e, ArrayList<String> arrayList) {
        super(c2454e);
        this.f7142b = new ArrayList<>();
        this.f7142b.clear();
        this.f7142b = arrayList;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() {
        C4904y.m18646e("beforeRequest", "DeleteUpdateTask");
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f7142b.iterator();
        while (it.hasNext()) {
            arrayList.add(new Timestamp(it.next()));
        }
        String strM18172a = new C4815ag().m18172a(arrayList);
        C4904y.m18646e(strM18172a, "DeleteUpdateTask");
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) {
        C4904y.m18646e("afterRequest", "DeleteUpdateTask");
        if (!c0778b.m18954n() || c0778b.m3110e() == null || c0778b.m3107b() != EnumC2464o.ERROR) {
        }
    }
}
