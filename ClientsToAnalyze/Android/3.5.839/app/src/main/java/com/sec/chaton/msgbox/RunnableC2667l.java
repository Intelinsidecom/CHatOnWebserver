package com.sec.chaton.msgbox;

import com.sec.chaton.p057e.EnumC2300t;
import java.util.ArrayList;

/* compiled from: MsgboxClose.java */
/* renamed from: com.sec.chaton.msgbox.l */
/* loaded from: classes.dex */
class RunnableC2667l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArrayList f9573a;

    /* renamed from: b */
    final /* synthetic */ EnumC2300t f9574b;

    /* renamed from: c */
    final /* synthetic */ ArrayList f9575c;

    /* renamed from: d */
    final /* synthetic */ C2660e f9576d;

    RunnableC2667l(C2660e c2660e, ArrayList arrayList, EnumC2300t enumC2300t, ArrayList arrayList2) {
        this.f9576d = c2660e;
        this.f9573a = arrayList;
        this.f9574b = enumC2300t;
        this.f9575c = arrayList2;
    }

    @Override // java.lang.Runnable
    public void run() {
        new C2681z(this.f9576d, this.f9576d.f9543g).m19059d(this.f9573a, this.f9574b, this.f9575c, null, null, false);
    }
}
