package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1793y;
import java.util.List;

/* compiled from: SetAnsNotiReadMessage.java */
/* renamed from: com.sec.chaton.d.a.bq */
/* loaded from: classes.dex */
public class C0576bq extends AbstractRunnableC0532a {

    /* renamed from: d */
    private List f2303d;

    public C0576bq(Handler handler, C0798h c0798h, List list) {
        super(handler, c0798h);
        this.f2303d = list;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        if (this.f2303d == null || this.f2303d.size() == 0) {
            m2709b();
            return "";
        }
        String strM6112a = new C1793y().m6112a(this.f2303d);
        C1786r.m6066e(strM6112a, getClass().getSimpleName());
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
    }
}
