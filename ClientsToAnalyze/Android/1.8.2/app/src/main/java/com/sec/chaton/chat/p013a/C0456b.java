package com.sec.chaton.chat.p013a;

import android.content.ClipboardManager;
import android.content.Context;

/* compiled from: ClipboardHoneycomb.java */
/* renamed from: com.sec.chaton.chat.a.b */
/* loaded from: classes.dex */
public class C0456b implements InterfaceC0458d {

    /* renamed from: a */
    String f1916a;

    /* renamed from: b */
    Context f1917b;

    public C0456b(Context context, String str) {
        this.f1916a = "";
        this.f1917b = context;
        this.f1916a = str;
        m2615a();
    }

    /* renamed from: a */
    public void m2615a() {
        ((ClipboardManager) this.f1917b.getSystemService("clipboard")).setText(this.f1916a);
    }
}
