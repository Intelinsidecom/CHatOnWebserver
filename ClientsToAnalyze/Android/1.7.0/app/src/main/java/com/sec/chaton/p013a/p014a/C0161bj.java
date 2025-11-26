package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p033io.entry.inner.Address;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1349x;
import java.util.ArrayList;

/* compiled from: AddBuddyPreviewTask.java */
/* renamed from: com.sec.chaton.a.a.bj */
/* loaded from: classes.dex */
public class C0161bj extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private String f379a;

    public C0161bj(Handler handler, C0503j c0503j, String str) {
        super(handler, c0503j);
        this.f379a = str;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        ArrayList arrayList = new ArrayList();
        Address address = new Address();
        address.value = this.f379a;
        arrayList.add(address);
        String strM4714a = new C1349x().m4714a(arrayList);
        C1341p.m4662e("\n" + strM4714a, getClass().getSimpleName());
        return strM4714a;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
    }
}
