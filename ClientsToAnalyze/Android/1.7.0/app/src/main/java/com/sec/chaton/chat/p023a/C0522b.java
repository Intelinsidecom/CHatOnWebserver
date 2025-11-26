package com.sec.chaton.chat.p023a;

import android.content.Context;
import android.text.ClipboardManager;

/* compiled from: ClipboardFroyo.java */
/* renamed from: com.sec.chaton.chat.a.b */
/* loaded from: classes.dex */
public class C0522b implements InterfaceC0524d {

    /* renamed from: a */
    String f1871a;

    /* renamed from: b */
    Context f1872b;

    public C0522b(Context context, String str) {
        this.f1871a = "";
        this.f1872b = context;
        this.f1871a = str;
        m2721a();
    }

    /* renamed from: a */
    public void m2721a() {
        ((ClipboardManager) this.f1872b.getSystemService("clipboard")).setText(this.f1871a);
    }
}
