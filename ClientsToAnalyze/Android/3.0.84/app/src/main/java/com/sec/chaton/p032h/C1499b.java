package com.sec.chaton.p032h;

import android.content.Intent;
import com.sec.chaton.EnumC2947t;
import com.sec.chaton.p027e.EnumC1455w;

/* compiled from: InterlockedAppLink.java */
/* renamed from: com.sec.chaton.h.b */
/* loaded from: classes.dex */
public class C1499b implements InterfaceC1498a {

    /* renamed from: a */
    private Intent f5534a;

    public C1499b(Intent intent) {
        this.f5534a = intent;
    }

    @Override // com.sec.chaton.p032h.InterfaceC1498a
    /* renamed from: a */
    public EnumC2947t mo6465a() {
        this.f5534a.putExtra("callForward", true);
        this.f5534a.putExtra("content_type", EnumC1455w.APPLINK.m6364a());
        if (this.f5534a.getExtras().containsKey("android.intent.extra.TEXT")) {
            this.f5534a.putExtra("download_uri", this.f5534a.getExtras().getString("android.intent.extra.TEXT"));
        }
        return EnumC2947t.FORWARD;
    }
}
