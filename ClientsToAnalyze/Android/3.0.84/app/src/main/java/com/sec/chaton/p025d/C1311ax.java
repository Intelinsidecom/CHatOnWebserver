package com.sec.chaton.p025d;

import com.sec.chaton.settings.tellfriends.InterfaceC2726ac;
import com.sec.chaton.util.C3250y;

/* compiled from: SnsAccountControl.java */
/* renamed from: com.sec.chaton.d.ax */
/* loaded from: classes.dex */
class C1311ax implements InterfaceC2726ac {

    /* renamed from: a */
    final /* synthetic */ C1308au f4958a;

    C1311ax(C1308au c1308au) {
        this.f4958a = c1308au;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2726ac
    /* renamed from: a */
    public void mo5658a(Object obj) {
        C3250y.m11450b("onComplete get friend IDs", getClass().getSimpleName());
        if (obj instanceof long[]) {
            this.f4958a.f4953l = (long[]) obj;
        }
        if (this.f4958a.f4953l.length <= 0) {
            this.f4958a.m5622a(1301);
        } else {
            this.f4958a.m5643j();
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2726ac
    /* renamed from: a */
    public void mo5656a() {
        C3250y.m11450b("onComplete get friend IDs", getClass().getSimpleName());
        this.f4958a.m5622a(1303);
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2726ac
    /* renamed from: a */
    public void mo5657a(int i) {
        C3250y.m11450b("onComplete get friend IDs", getClass().getSimpleName());
        this.f4958a.m5622a(1302);
    }
}
