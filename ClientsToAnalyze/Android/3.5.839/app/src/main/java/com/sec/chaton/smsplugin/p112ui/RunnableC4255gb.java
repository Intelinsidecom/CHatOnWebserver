package com.sec.chaton.smsplugin.p112ui;

import com.sec.chaton.smsplugin.p111h.C3887j;
import com.sec.chaton.smsplugin.provider.C3942a;
import java.util.Iterator;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gb */
/* loaded from: classes.dex */
class RunnableC4255gb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC4254ga f15618a;

    RunnableC4255gb(DialogInterfaceOnClickListenerC4254ga dialogInterfaceOnClickListenerC4254ga) {
        this.f15618a = dialogInterfaceOnClickListenerC4254ga;
    }

    @Override // java.lang.Runnable
    public void run() {
        C3942a c3942a = new C3942a(this.f15618a.f15616c.getContentResolver());
        if (this.f15618a.f15615b == null) {
            c3942a.m15235a(this.f15618a.f15614a, 1806, (Object) null, this.f15618a.f15617d);
            C3887j.m14982c().m14984a();
            return;
        }
        c3942a.m15236a(this.f15618a.f15614a, 1806, this.f15618a.f15615b, this.f15618a.f15617d, this.f15618a.f15615b);
        Iterator it = this.f15618a.f15615b.iterator();
        while (it.hasNext()) {
            C3887j.m14982c().m14985a(((Long) it.next()).longValue(), false);
        }
    }
}
