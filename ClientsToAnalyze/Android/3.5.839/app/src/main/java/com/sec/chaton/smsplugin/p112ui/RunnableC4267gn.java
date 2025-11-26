package com.sec.chaton.smsplugin.p112ui;

import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: PluginConversationList.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gn */
/* loaded from: classes.dex */
class RunnableC4267gn implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f15637a;

    /* renamed from: b */
    final /* synthetic */ boolean f15638b;

    /* renamed from: c */
    final /* synthetic */ PluginConversationList f15639c;

    RunnableC4267gn(PluginConversationList pluginConversationList, long j, boolean z) {
        this.f15639c = pluginConversationList;
        this.f15637a = j;
        this.f15638b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            this.f15639c.m16141a("onDraftChanged: threadId=" + this.f15637a + ", hasDraft=" + this.f15638b, new Object[0]);
        }
        this.f15639c.f15059c.notifyDataSetChanged();
    }
}
