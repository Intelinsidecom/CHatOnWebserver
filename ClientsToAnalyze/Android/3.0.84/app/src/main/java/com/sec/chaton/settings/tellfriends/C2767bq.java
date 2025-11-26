package com.sec.chaton.settings.tellfriends;

import java.util.TimerTask;

/* compiled from: WeiboDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bq */
/* loaded from: classes.dex */
class C2767bq extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ DialogC2762bl f10191a;

    private C2767bq(DialogC2762bl dialogC2762bl) {
        this.f10191a = dialogC2762bl;
    }

    /* synthetic */ C2767bq(DialogC2762bl dialogC2762bl, DialogInterfaceOnCancelListenerC2763bm dialogInterfaceOnCancelListenerC2763bm) {
        this(dialogC2762bl);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f10191a.f10174e != null) {
            this.f10191a.f10174e.sendEmptyMessage(-1003);
        }
    }
}
