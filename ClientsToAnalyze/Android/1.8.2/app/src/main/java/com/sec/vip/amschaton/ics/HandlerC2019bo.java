package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bo */
/* loaded from: classes.dex */
class HandlerC2019bo extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7303a;

    HandlerC2019bo(AMSPlayerActivity aMSPlayerActivity) {
        this.f7303a = aMSPlayerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws IllegalStateException, Resources.NotFoundException {
        switch (message.what) {
            case 1000:
                this.f7303a.m7039a(this.f7303a.f7213p);
                break;
            case 1001:
                this.f7303a.m7047b(true);
                this.f7303a.f7217t.setProgress(this.f7303a.f6688l.m6502a());
                if ((this.f7303a.f6688l.m6514g() & 1) != 1) {
                    this.f7303a.m7053d(false);
                    if (!this.f7303a.f7222y) {
                        this.f7303a.m7057f(true);
                    }
                }
                this.f7303a.m7085q();
                break;
        }
    }
}
