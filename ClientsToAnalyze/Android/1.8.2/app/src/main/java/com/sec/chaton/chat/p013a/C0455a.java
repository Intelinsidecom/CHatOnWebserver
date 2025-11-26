package com.sec.chaton.chat.p013a;

import android.content.Context;
import android.text.ClipboardManager;

/* compiled from: ClipboardFroyo.java */
/* renamed from: com.sec.chaton.chat.a.a */
/* loaded from: classes.dex */
public class C0455a implements InterfaceC0458d {

    /* renamed from: a */
    String f1914a;

    /* renamed from: b */
    Context f1915b;

    public C0455a(Context context, String str) {
        this.f1914a = "";
        this.f1915b = context;
        this.f1914a = str;
        m2614a();
    }

    /* renamed from: a */
    public void m2614a() {
        ((ClipboardManager) this.f1915b.getSystemService("clipboard")).setText(this.f1914a);
    }
}
