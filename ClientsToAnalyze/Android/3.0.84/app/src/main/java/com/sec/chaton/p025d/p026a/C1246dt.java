package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.inner.SnsId;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: SetSNSIdTask.java */
/* renamed from: com.sec.chaton.d.a.dt */
/* loaded from: classes.dex */
public class C1246dt extends AbstractC1145a {

    /* renamed from: b */
    private String f4810b;

    /* renamed from: c */
    private String f4811c;

    public C1246dt(Handler handler, C1580h c1580h, String str, String str2) {
        super(handler, c1580h);
        this.f4810b = str;
        this.f4811c = str2;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        ArrayList arrayList = new ArrayList();
        SnsId snsId = new SnsId();
        if (this.f4810b != null) {
            snsId.f5656sp = this.f4810b;
        }
        if (this.f4811c != null) {
            snsId.value = this.f4811c;
        }
        arrayList.add(snsId);
        String strM11026a = new C3164af().m11026a(arrayList);
        C3250y.m11450b(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        C3250y.m11450b("in SetSNSIdTask.afterRequest()", getClass().getSimpleName());
    }
}
