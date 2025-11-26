package com.sec.chaton.p028e;

import android.content.Intent;
import com.sec.chaton.EnumC0250am;
import com.sec.chaton.p025d.EnumC0651d;

/* compiled from: InterlockedText.java */
/* renamed from: com.sec.chaton.e.c */
/* loaded from: classes.dex */
public class C0676c implements InterfaceC0679f {

    /* renamed from: a */
    private Intent f2324a;

    public C0676c(Intent intent) {
        this.f2324a = intent;
    }

    @Override // com.sec.chaton.p028e.InterfaceC0679f
    /* renamed from: a */
    public EnumC0250am mo3045a() {
        this.f2324a.putExtra("callForward", true);
        if (this.f2324a.getExtras().containsKey("android.intent.extra.TEXT")) {
            String string = this.f2324a.getExtras().getString("android.intent.extra.TEXT");
            String string2 = this.f2324a.getExtras().getString("android.intent.extra.SUBJECT");
            Intent intent = this.f2324a;
            if (string2 != null) {
                string = string2 + " - " + string;
            }
            intent.putExtra("download_uri", string);
            this.f2324a.putExtra("content_type", EnumC0651d.TEXT.m2978a());
            return EnumC0250am.FORWARD;
        }
        return EnumC0250am.HOME;
    }
}
