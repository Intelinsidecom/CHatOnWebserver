package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.GetMemoBlindList;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;

/* compiled from: GetMemoBlindListTask.java */
/* renamed from: com.sec.chaton.a.a.ae */
/* loaded from: classes.dex */
public class C0129ae extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private ArrayList f309a;

    public C0129ae(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        C1341p.m4662e("beforeRequest", "GetMemoBlindListTask");
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        C1341p.m4662e("afterRequest", "GetMemoBlindListTask");
        if (c0259g.m927a() && c0259g.m932d() != null && c0259g.m928b() != EnumC0518y.ERROR) {
            m673a(((GetMemoBlindList) c0259g.m932d()).blind);
        }
    }

    /* renamed from: a */
    public void m673a(ArrayList arrayList) {
        this.f309a = arrayList;
    }
}
