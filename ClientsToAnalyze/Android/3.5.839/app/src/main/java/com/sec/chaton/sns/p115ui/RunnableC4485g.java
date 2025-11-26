package com.sec.chaton.sns.p115ui;

import android.os.Bundle;
import com.sec.chaton.sns.C4363a;

/* compiled from: OdnokDialog.java */
/* renamed from: com.sec.chaton.sns.ui.g */
/* loaded from: classes.dex */
class RunnableC4485g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f16177a;

    /* renamed from: b */
    final /* synthetic */ String f16178b;

    /* renamed from: c */
    final /* synthetic */ C4481f f16179c;

    RunnableC4485g(C4481f c4481f, String str, String str2) {
        this.f16179c = c4481f;
        this.f16177a = str;
        this.f16178b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        C4363a.m16548a(this.f16179c.f16167b.f16072d, this.f16177a, this.f16178b);
        Bundle bundle = new Bundle();
        bundle.putString("access_token", this.f16177a);
        bundle.putString("refresh_token", this.f16178b);
        this.f16179c.f16167b.f16074g.mo2273a(bundle);
    }
}
