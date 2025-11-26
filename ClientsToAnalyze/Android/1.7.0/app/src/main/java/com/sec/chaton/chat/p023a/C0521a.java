package com.sec.chaton.chat.p023a;

import android.content.ClipboardManager;
import android.content.Context;

/* compiled from: ClipboardHoneycomb.java */
/* renamed from: com.sec.chaton.chat.a.a */
/* loaded from: classes.dex */
public class C0521a implements InterfaceC0524d {

    /* renamed from: a */
    String f1869a;

    /* renamed from: b */
    Context f1870b;

    public C0521a(Context context, String str) {
        this.f1869a = "";
        this.f1870b = context;
        this.f1869a = str;
        m2720a();
    }

    /* renamed from: a */
    public void m2720a() {
        ((ClipboardManager) this.f1870b.getSystemService("clipboard")).setText(this.f1869a);
    }
}
