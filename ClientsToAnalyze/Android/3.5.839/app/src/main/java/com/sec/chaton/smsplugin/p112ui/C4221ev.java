package com.sec.chaton.smsplugin.p112ui;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ev */
/* loaded from: classes.dex */
class C4221ev implements InterfaceC4115ax {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15572a;

    C4221ev(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15572a = pluginComposeMessageActivity;
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4115ax
    /* renamed from: a */
    public void mo16339a(C4110as c4110as) {
        this.f15572a.f14995ao = true;
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4115ax
    /* renamed from: b */
    public void mo16340b(C4110as c4110as) {
        PluginComposeMessageActivity.m16048c("MessageListAdapter.OnDataSetChangedListener.onContentChanged");
        this.f15572a.m15913W();
    }
}
