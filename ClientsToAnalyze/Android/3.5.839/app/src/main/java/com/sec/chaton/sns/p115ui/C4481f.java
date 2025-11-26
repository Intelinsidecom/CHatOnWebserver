package com.sec.chaton.sns.p115ui;

import com.sec.chaton.sns.p115ui.odnoklassniki.p116a.C4500f;
import com.sec.chaton.sns.p115ui.odnoklassniki.p116a.C4501g;

/* compiled from: OdnokDialog.java */
/* renamed from: com.sec.chaton.sns.ui.f */
/* loaded from: classes.dex */
class C4481f extends Thread {

    /* renamed from: a */
    final /* synthetic */ String f16166a;

    /* renamed from: b */
    final /* synthetic */ DialogC4446a f16167b;

    C4481f(DialogC4446a dialogC4446a, String str) {
        this.f16167b = dialogC4446a;
        this.f16166a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String strM17045a = C4501g.m17045a(this.f16166a);
        if (strM17045a == null) {
            this.f16167b.f16074g.mo2271a();
            return;
        }
        String[] strArrM17046a = C4501g.m17046a(strM17045a, false);
        if (strArrM17046a == null || strArrM17046a[0] == null) {
            this.f16167b.f16074g.mo2271a();
        } else {
            C4500f.m17042a(new RunnableC4485g(this, strArrM17046a[0], strArrM17046a[1]));
        }
    }
}
