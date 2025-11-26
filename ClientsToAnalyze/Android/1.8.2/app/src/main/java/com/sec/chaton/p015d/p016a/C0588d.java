package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p028io.entry.inner.Address;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1793y;
import java.util.ArrayList;

/* compiled from: AddBuddyPreviewTask.java */
/* renamed from: com.sec.chaton.d.a.d */
/* loaded from: classes.dex */
public class C0588d extends AbstractRunnableC0532a {

    /* renamed from: d */
    private String f2334d;

    public C0588d(Handler handler, C0798h c0798h, String str) {
        super(handler, c0798h);
        this.f2334d = str;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        ArrayList arrayList = new ArrayList();
        Address address = new Address();
        address.value = this.f2334d;
        arrayList.add(address);
        String strM6112a = new C1793y().m6112a(arrayList);
        C1786r.m6066e("\n" + strM6112a, getClass().getSimpleName());
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
    }
}
