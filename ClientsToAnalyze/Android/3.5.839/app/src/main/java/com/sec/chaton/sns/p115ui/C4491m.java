package com.sec.chaton.sns.p115ui;

import android.content.Context;
import android.os.Bundle;
import com.renren.android.Renren;
import com.sec.chaton.p051c.C1428b;
import com.sec.chaton.sns.p113a.InterfaceC4366c;
import com.sec.chaton.sns.p115ui.C4491m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RenrenDialog.java */
/* renamed from: com.sec.chaton.sns.ui.m */
/* loaded from: classes.dex */
public class C4491m<CONCRETE extends C4491m<?>> {

    /* renamed from: a */
    private Context f16194a;

    /* renamed from: b */
    private Bundle f16195b;

    /* renamed from: c */
    private Renren f16196c;

    /* renamed from: d */
    private String f16197d;

    /* renamed from: e */
    private InterfaceC4366c f16198e;

    protected C4491m(Context context, Renren renren, String str, Bundle bundle) {
        this.f16196c = renren;
        m17004a(context, str, bundle);
    }

    /* renamed from: a */
    private void m17004a(Context context, String str, Bundle bundle) {
        this.f16194a = context;
        this.f16197d = str;
        if (bundle != null) {
            this.f16195b = bundle;
        } else {
            this.f16195b = new Bundle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public CONCRETE m17006a(InterfaceC4366c interfaceC4366c) {
        this.f16198e = interfaceC4366c;
        return this;
    }

    /* renamed from: a */
    public DialogC4487i mo17005a() {
        if (this.f16196c != null) {
            this.f16195b.putString("app_id", this.f16196c.m2260c());
            if (this.f16196c.m2259b()) {
                this.f16195b.putString("access_token", this.f16196c.m2261d());
            }
        }
        if (!this.f16195b.containsKey("redirect_uri")) {
            this.f16195b.putString("redirect_uri", C1428b.f5085A);
        }
        return new DialogC4487i(this.f16194a, this.f16197d, this.f16195b, this.f16198e);
    }
}
