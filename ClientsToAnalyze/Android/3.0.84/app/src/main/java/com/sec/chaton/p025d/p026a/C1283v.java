package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.inner.Blind;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BlindPostONTask.java */
/* renamed from: com.sec.chaton.d.a.v */
/* loaded from: classes.dex */
public class C1283v extends AbstractC1145a {

    /* renamed from: b */
    private ArrayList<String> f4896b;

    /* renamed from: c */
    private ArrayList<String> f4897c;

    public C1283v(Handler handler, C1580h c1580h, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        super(handler, c1580h);
        this.f4896b = new ArrayList<>();
        this.f4897c = new ArrayList<>();
        this.f4897c.clear();
        this.f4896b.clear();
        this.f4897c = arrayList;
        this.f4896b = arrayList2;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3250y.m11456e("beforeRequest", "BlindMemoTask");
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f4897c.iterator();
        while (it.hasNext()) {
            arrayList.add(new Blind("false", it.next()));
        }
        Iterator<String> it2 = this.f4896b.iterator();
        while (it2.hasNext()) {
            arrayList.add(new Blind("true", it2.next()));
        }
        String strM11026a = new C3164af().m11026a(arrayList);
        C3250y.m11456e(strM11026a, "BlindMemoTask");
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        C3250y.m11456e("afterRequest", "BlindMemoTask");
        if ((!c0267d.m11704n() || c0267d.m1354e() == null || c0267d.m1351b() == EnumC1587o.ERROR) && CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000004", "1202", c0267d);
        }
    }
}
