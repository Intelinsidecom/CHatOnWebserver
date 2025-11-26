package com.sec.chaton.p062h;

import android.content.Intent;
import com.sec.chaton.chat.EnumC1761hg;
import com.sec.chaton.p057e.EnumC2214ab;

/* compiled from: InterlockedText.java */
/* renamed from: com.sec.chaton.h.j */
/* loaded from: classes.dex */
public class C2364j implements InterfaceC2355a {

    /* renamed from: a */
    private Intent f8394a;

    /* renamed from: a */
    public static C2364j m10320a(Intent intent) {
        return new C2364j(intent);
    }

    private C2364j(Intent intent) {
        this.f8394a = intent;
    }

    @Override // com.sec.chaton.p062h.InterfaceC2355a
    /* renamed from: a */
    public EnumC1761hg mo10310a() {
        this.f8394a.putExtra("callForward", true);
        if (this.f8394a.getExtras().containsKey("android.intent.extra.TEXT")) {
            String string = this.f8394a.getExtras().getString("android.intent.extra.TEXT");
            String string2 = this.f8394a.getExtras().getString("android.intent.extra.SUBJECT");
            Intent intent = this.f8394a;
            if (string2 != null) {
                string = string2 + " - " + string;
            }
            intent.putExtra("download_uri", string);
            this.f8394a.putExtra("content_type", EnumC2214ab.TEXT.m10076a());
            return EnumC1761hg.FORWARD;
        }
        return EnumC1761hg.HOME;
    }
}
