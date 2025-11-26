package com.sec.chaton.chat.p013a;

import android.content.Context;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.util.C1786r;

/* compiled from: ClipboardManager.java */
/* renamed from: com.sec.chaton.chat.a.c */
/* loaded from: classes.dex */
public class C0457c {

    /* renamed from: a */
    String f1918a;

    /* renamed from: b */
    Context f1919b;

    public C0457c(Context context, String str) {
        this.f1918a = "";
        this.f1919b = context;
        this.f1918a = str;
    }

    /* renamed from: a */
    public InterfaceC0458d m2616a() {
        C1786r.m6064d("ChatONConst.SDK_VERSION:" + C0452a.f1722a);
        return C0452a.f1722a == 11 ? new C0456b(this.f1919b, this.f1918a) : new C0455a(this.f1919b, this.f1918a);
    }
}
