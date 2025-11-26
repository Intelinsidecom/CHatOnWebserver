package com.sec.chaton.sns.p114b;

import android.os.Handler;
import com.sec.chaton.sns.p113a.InterfaceC4367d;

/* compiled from: SnsHelperVKontakte.java */
/* renamed from: com.sec.chaton.sns.b.ao */
/* loaded from: classes.dex */
class C4389ao implements InterfaceC4367d {

    /* renamed from: a */
    final /* synthetic */ Handler f15903a;

    /* renamed from: b */
    final /* synthetic */ C4388an f15904b;

    C4389ao(C4388an c4388an, Handler handler) {
        this.f15904b = c4388an;
        this.f15903a = handler;
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4367d
    /* renamed from: a */
    public void mo16563a(int i, int i2, Object obj) {
        this.f15903a.post(new RunnableC4390ap(this, i, i2, obj));
    }
}
