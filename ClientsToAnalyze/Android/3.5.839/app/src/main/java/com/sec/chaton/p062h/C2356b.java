package com.sec.chaton.p062h;

import android.content.Intent;
import com.sec.chaton.chat.EnumC1761hg;
import com.sec.chaton.p057e.EnumC2214ab;

/* compiled from: InterlockedAppLink.java */
/* renamed from: com.sec.chaton.h.b */
/* loaded from: classes.dex */
public class C2356b implements InterfaceC2355a {

    /* renamed from: a */
    private Intent f8387a;

    /* renamed from: a */
    public static C2356b m10311a(Intent intent) {
        return new C2356b(intent);
    }

    private C2356b(Intent intent) {
        this.f8387a = intent;
    }

    @Override // com.sec.chaton.p062h.InterfaceC2355a
    /* renamed from: a */
    public EnumC1761hg mo10310a() {
        this.f8387a.putExtra("callForward", true);
        this.f8387a.putExtra("content_type", EnumC2214ab.APPLINK.m10076a());
        if (this.f8387a.getExtras().containsKey("android.intent.extra.TEXT")) {
            this.f8387a.putExtra("download_uri", this.f8387a.getExtras().getString("android.intent.extra.TEXT"));
        }
        return EnumC1761hg.FORWARD;
    }
}
