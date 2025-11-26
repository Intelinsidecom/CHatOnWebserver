package com.sec.chaton.sns.p115ui;

import java.util.TimerTask;

/* compiled from: WeiboDialog.java */
/* renamed from: com.sec.chaton.sns.ui.bb */
/* loaded from: classes.dex */
class C4475bb extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ DialogC4469aw f16160a;

    private C4475bb(DialogC4469aw dialogC4469aw) {
        this.f16160a = dialogC4469aw;
    }

    /* synthetic */ C4475bb(DialogC4469aw dialogC4469aw, DialogInterfaceOnCancelListenerC4470ax dialogInterfaceOnCancelListenerC4470ax) {
        this(dialogC4469aw);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f16160a.f16142e != null) {
            this.f16160a.f16142e.sendEmptyMessage(-1003);
        }
    }
}
