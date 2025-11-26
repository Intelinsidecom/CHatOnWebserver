package com.facebook;

import android.app.Activity;
import android.content.Intent;

/* compiled from: Session.java */
/* renamed from: com.facebook.bh */
/* loaded from: classes.dex */
class C0114bh implements InterfaceC0119bm {

    /* renamed from: a */
    final /* synthetic */ Activity f231a;

    /* renamed from: b */
    final /* synthetic */ C0113bg f232b;

    C0114bh(C0113bg c0113bg, Activity activity) {
        this.f232b = c0113bg;
        this.f231a = activity;
    }

    @Override // com.facebook.InterfaceC0119bm
    /* renamed from: a */
    public void mo344a(Intent intent, int i) {
        this.f231a.startActivityForResult(intent, i);
    }

    @Override // com.facebook.InterfaceC0119bm
    /* renamed from: a */
    public Activity mo343a() {
        return this.f231a;
    }
}
