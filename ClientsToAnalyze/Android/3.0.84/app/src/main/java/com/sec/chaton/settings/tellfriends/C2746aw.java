package com.sec.chaton.settings.tellfriends;

import java.util.TimerTask;

/* compiled from: TwDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.aw */
/* loaded from: classes.dex */
class C2746aw extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ DialogC2741ar f10143a;

    private C2746aw(DialogC2741ar dialogC2741ar) {
        this.f10143a = dialogC2741ar;
    }

    /* synthetic */ C2746aw(DialogC2741ar dialogC2741ar, DialogInterfaceOnCancelListenerC2742as dialogInterfaceOnCancelListenerC2742as) {
        this(dialogC2741ar);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f10143a.f10128f != null) {
            this.f10143a.f10128f.sendEmptyMessage(-1003);
        }
    }
}
