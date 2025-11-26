package com.sec.chaton.smsplugin.p112ui;

import com.sec.chaton.smsplugin.C3811d;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p111h.C3887j;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: PluginConversationList.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gs */
/* loaded from: classes.dex */
class RunnableC4272gs implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PluginConversationList f15645a;

    RunnableC4272gs(PluginConversationList pluginConversationList) {
        this.f15645a = pluginConversationList;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3811d.m14485a("mDeleteObsoleteThreadsRunnable getSavingDraft(): " + C3887j.m14982c().m14990b(), new Object[0]);
        }
        if (C3887j.m14982c().m14990b()) {
            this.f15645a.f15062f.postDelayed(this.f15645a.f15072p, 1000L);
        } else {
            C3790i.m14324a(this.f15645a.f15058b, 1803);
        }
    }
}
