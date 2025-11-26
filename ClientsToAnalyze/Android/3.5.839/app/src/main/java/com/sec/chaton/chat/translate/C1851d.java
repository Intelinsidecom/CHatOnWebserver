package com.sec.chaton.chat.translate;

import java.util.List;

/* compiled from: LanguageTranslator.java */
/* renamed from: com.sec.chaton.chat.translate.d */
/* loaded from: classes.dex */
class C1851d implements InterfaceC1855h {

    /* renamed from: a */
    final /* synthetic */ List f7044a;

    /* renamed from: b */
    final /* synthetic */ C1850c f7045b;

    C1851d(C1850c c1850c, List list) {
        this.f7045b = c1850c;
        this.f7044a = list;
    }

    @Override // com.sec.chaton.chat.translate.InterfaceC1855h
    /* renamed from: a */
    public void mo9041a(String str) {
        this.f7044a.add(str);
        this.f7045b.f7036b++;
    }
}
