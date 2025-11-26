package com.sec.chaton.msgbox;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p057e.EnumC2300t;
import java.util.ArrayList;

/* compiled from: MsgboxClose.java */
/* renamed from: com.sec.chaton.msgbox.i */
/* loaded from: classes.dex */
class HandlerC2664i extends Handler {

    /* renamed from: a */
    final /* synthetic */ boolean f9563a;

    /* renamed from: b */
    final /* synthetic */ boolean f9564b;

    /* renamed from: c */
    final /* synthetic */ ArrayList f9565c;

    /* renamed from: d */
    final /* synthetic */ EnumC2300t f9566d;

    /* renamed from: e */
    final /* synthetic */ ArrayList f9567e;

    /* renamed from: f */
    final /* synthetic */ ArrayList f9568f;

    /* renamed from: g */
    final /* synthetic */ int f9569g;

    /* renamed from: h */
    final /* synthetic */ C2660e f9570h;

    HandlerC2664i(C2660e c2660e, boolean z, boolean z2, ArrayList arrayList, EnumC2300t enumC2300t, ArrayList arrayList2, ArrayList arrayList3, int i) {
        this.f9570h = c2660e;
        this.f9563a = z;
        this.f9564b = z2;
        this.f9565c = arrayList;
        this.f9566d = enumC2300t;
        this.f9567e = arrayList2;
        this.f9568f = arrayList3;
        this.f9569g = i;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f9570h.m11218a(this.f9563a, this.f9564b, message.what == 1, new RunnableC2665j(this), new RunnableC2666k(this), this.f9569g);
    }
}
