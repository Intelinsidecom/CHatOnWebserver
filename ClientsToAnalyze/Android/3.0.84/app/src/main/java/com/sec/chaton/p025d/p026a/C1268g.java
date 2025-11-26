package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.inner.Address;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: AddBuddyPreviewTask.java */
/* renamed from: com.sec.chaton.d.a.g */
/* loaded from: classes.dex */
public class C1268g extends AbstractC1145a {

    /* renamed from: b */
    private String f4866b;

    public C1268g(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4866b = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        ArrayList arrayList = new ArrayList();
        Address address = new Address();
        address.value = this.f4866b;
        arrayList.add(address);
        String strM11026a = new C3164af().m11026a(arrayList);
        C3250y.m11456e("\n" + strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
    }
}
