package com.facebook;

import android.app.Activity;
import android.content.Intent;

/* compiled from: Session.java */
/* renamed from: com.facebook.bh */
/* loaded from: classes.dex */
class C0485bh implements InterfaceC0490bm {

    /* renamed from: a */
    final /* synthetic */ Activity f1200a;

    /* renamed from: b */
    final /* synthetic */ C0484bg f1201b;

    C0485bh(C0484bg c0484bg, Activity activity) {
        this.f1201b = c0484bg;
        this.f1200a = activity;
    }

    @Override // com.facebook.InterfaceC0490bm
    /* renamed from: a */
    public void mo1787a(Intent intent, int i) {
        this.f1200a.startActivityForResult(intent, i);
    }

    @Override // com.facebook.InterfaceC0490bm
    /* renamed from: a */
    public Activity mo1786a() {
        return this.f1200a;
    }
}
