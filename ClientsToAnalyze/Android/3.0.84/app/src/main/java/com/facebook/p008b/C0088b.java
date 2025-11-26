package com.facebook.p008b;

import java.io.File;

/* compiled from: FileLruCache.java */
/* renamed from: com.facebook.b.b */
/* loaded from: classes.dex */
class C0088b implements InterfaceC0097k {

    /* renamed from: a */
    final /* synthetic */ String f167a;

    /* renamed from: b */
    final /* synthetic */ File f168b;

    /* renamed from: c */
    final /* synthetic */ C0087a f169c;

    C0088b(C0087a c0087a, String str, File file) {
        this.f169c = c0087a;
        this.f167a = str;
        this.f168b = file;
    }

    @Override // com.facebook.p008b.InterfaceC0097k
    /* renamed from: a */
    public void mo231a() {
        this.f169c.m223a(this.f167a, this.f168b);
    }
}
