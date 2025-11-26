package com.sec.chaton.settings.tellfriends;

import android.content.Context;
import android.os.Bundle;
import com.renren.android.Renren;
import com.sec.chaton.p020c.C0817b;
import com.sec.chaton.settings.tellfriends.C2815i;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2786b;

/* compiled from: RenrenDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.i */
/* loaded from: classes.dex */
class C2815i<CONCRETE extends C2815i<?>> {

    /* renamed from: a */
    private Context f10336a;

    /* renamed from: b */
    private Bundle f10337b;

    /* renamed from: c */
    private Renren f10338c;

    /* renamed from: d */
    private String f10339d;

    /* renamed from: e */
    private InterfaceC2786b f10340e;

    protected C2815i(Context context, Renren renren, String str, Bundle bundle) {
        this.f10338c = renren;
        m10034a(context, str, bundle);
    }

    /* renamed from: a */
    private void m10034a(Context context, String str, Bundle bundle) {
        this.f10336a = context;
        this.f10339d = str;
        if (bundle != null) {
            this.f10337b = bundle;
        } else {
            this.f10337b = new Bundle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public CONCRETE m10036a(InterfaceC2786b interfaceC2786b) {
        this.f10340e = interfaceC2786b;
        return this;
    }

    /* renamed from: a */
    public DialogC2811e mo10035a() {
        if (this.f10338c != null) {
            this.f10337b.putString("app_id", this.f10338c.m528c());
            if (this.f10338c.m527b()) {
                this.f10337b.putString("access_token", this.f10338c.m529d());
            }
        }
        if (!this.f10337b.containsKey("redirect_uri")) {
            this.f10337b.putString("redirect_uri", C0817b.f3149u);
        }
        return new DialogC2811e(this.f10336a, this.f10339d, this.f10337b, this.f10340e);
    }
}
