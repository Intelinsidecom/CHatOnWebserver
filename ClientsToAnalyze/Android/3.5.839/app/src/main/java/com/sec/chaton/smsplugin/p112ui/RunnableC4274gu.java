package com.sec.chaton.smsplugin.p112ui;

import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p111h.C3887j;
import java.util.Iterator;

/* compiled from: PluginConversationList.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gu */
/* loaded from: classes.dex */
class RunnableC4274gu implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC4273gt f15650a;

    RunnableC4274gu(DialogInterfaceOnClickListenerC4273gt dialogInterfaceOnClickListenerC4273gt) {
        this.f15650a = dialogInterfaceOnClickListenerC4273gt;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f15650a.f15646a != null) {
            Iterator it = this.f15650a.f15646a.iterator();
            while (it.hasNext()) {
                long jLongValue = ((Long) it.next()).longValue();
                C3790i.m14327a(this.f15650a.f15647b, 1801, this.f15650a.f15649d, jLongValue);
                C3887j.m14982c().m14985a(jLongValue, false);
            }
            return;
        }
        C3790i.m14326a(this.f15650a.f15647b, 1801, this.f15650a.f15649d);
        C3887j.m14982c().m14984a();
    }
}
