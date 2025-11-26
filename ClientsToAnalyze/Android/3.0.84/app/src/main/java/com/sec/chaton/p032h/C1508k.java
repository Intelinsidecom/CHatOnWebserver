package com.sec.chaton.p032h;

import android.content.Intent;
import com.sec.chaton.EnumC2947t;
import com.sec.chaton.p027e.EnumC1455w;

/* compiled from: InterlockedText.java */
/* renamed from: com.sec.chaton.h.k */
/* loaded from: classes.dex */
public class C1508k implements InterfaceC1498a {

    /* renamed from: a */
    private Intent f5543a;

    public C1508k(Intent intent) {
        this.f5543a = intent;
    }

    @Override // com.sec.chaton.p032h.InterfaceC1498a
    /* renamed from: a */
    public EnumC2947t mo6465a() {
        this.f5543a.putExtra("callForward", true);
        if (this.f5543a.getExtras().containsKey("android.intent.extra.TEXT")) {
            String string = this.f5543a.getExtras().getString("android.intent.extra.TEXT");
            String string2 = this.f5543a.getExtras().getString("android.intent.extra.SUBJECT");
            Intent intent = this.f5543a;
            if (string2 != null) {
                string = string2 + " - " + string;
            }
            intent.putExtra("download_uri", string);
            this.f5543a.putExtra("content_type", EnumC1455w.TEXT.m6364a());
            return EnumC2947t.FORWARD;
        }
        return EnumC2947t.HOME;
    }
}
