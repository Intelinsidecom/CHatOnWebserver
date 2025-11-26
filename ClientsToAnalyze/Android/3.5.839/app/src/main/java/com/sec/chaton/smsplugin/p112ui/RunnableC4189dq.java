package com.sec.chaton.smsplugin.p112ui;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dq */
/* loaded from: classes.dex */
class RunnableC4189dq implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC4188dp f15515a;

    RunnableC4189dq(DialogInterfaceOnClickListenerC4188dp dialogInterfaceOnClickListenerC4188dp) {
        this.f15515a = dialogInterfaceOnClickListenerC4188dp;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15515a.f15514b.f15511a.finish();
    }
}
