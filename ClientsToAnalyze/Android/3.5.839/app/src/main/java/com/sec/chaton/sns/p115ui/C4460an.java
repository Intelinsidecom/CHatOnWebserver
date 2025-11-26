package com.sec.chaton.sns.p115ui;

import java.util.TimerTask;

/* compiled from: TwDialog.java */
/* renamed from: com.sec.chaton.sns.ui.an */
/* loaded from: classes.dex */
class C4460an extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ DialogC4455ai f16118a;

    private C4460an(DialogC4455ai dialogC4455ai) {
        this.f16118a = dialogC4455ai;
    }

    /* synthetic */ C4460an(DialogC4455ai dialogC4455ai, DialogInterfaceOnCancelListenerC4456aj dialogInterfaceOnCancelListenerC4456aj) {
        this(dialogC4455ai);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f16118a.f16103f != null) {
            this.f16118a.f16103f.sendEmptyMessage(-1003);
        }
    }
}
