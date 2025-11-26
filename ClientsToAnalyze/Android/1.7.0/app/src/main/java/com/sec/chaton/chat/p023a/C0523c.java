package com.sec.chaton.chat.p023a;

import android.content.Context;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.util.C1341p;

/* compiled from: ClipboardManager.java */
/* renamed from: com.sec.chaton.chat.a.c */
/* loaded from: classes.dex */
public class C0523c {

    /* renamed from: a */
    String f1873a;

    /* renamed from: b */
    Context f1874b;

    public C0523c(Context context, String str) {
        this.f1873a = "";
        this.f1874b = context;
        this.f1873a = str;
    }

    /* renamed from: a */
    public InterfaceC0524d m2722a() {
        C1341p.m4659c("ChatONConst.SDK_VERSION:" + C0684a.f2330a);
        return C0684a.f2330a == 11 ? new C0521a(this.f1874b, this.f1873a) : new C0522b(this.f1874b, this.f1873a);
    }
}
