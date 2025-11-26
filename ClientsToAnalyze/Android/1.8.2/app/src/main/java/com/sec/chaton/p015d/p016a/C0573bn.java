package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.inner.Buddyid;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1793y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: PutInteractionHideTask.java */
/* renamed from: com.sec.chaton.d.a.bn */
/* loaded from: classes.dex */
public class C0573bn extends AbstractRunnableC0532a {

    /* renamed from: d */
    private ArrayList f2294d;

    /* renamed from: e */
    private ArrayList f2295e;

    public C0573bn(Handler handler, C0798h c0798h, ArrayList arrayList, ArrayList arrayList2) {
        super(handler, c0798h);
        this.f2294d = new ArrayList();
        this.f2295e = new ArrayList();
        this.f2295e.clear();
        this.f2294d.clear();
        this.f2295e = arrayList;
        this.f2294d = arrayList2;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1786r.m6066e("beforeRequest", "InteractionHideTask");
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2295e.iterator();
        while (it.hasNext()) {
            arrayList.add(new Buddyid("false", (String) it.next()));
        }
        Iterator it2 = this.f2294d.iterator();
        while (it2.hasNext()) {
            arrayList.add(new Buddyid("true", (String) it2.next()));
        }
        String strM6112a = new C1793y().m6112a(arrayList);
        C1786r.m6066e(strM6112a, "InteractionHideTask");
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        C1786r.m6066e("afterRequest", "InteractionHideTask");
        if (!c0101b.m664a() || c0101b.m671d() == null || c0101b.m665b() != EnumC0803m.ERROR) {
        }
    }
}
