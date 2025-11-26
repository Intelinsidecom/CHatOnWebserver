package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.br */
/* loaded from: classes.dex */
class HandlerC1514br extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5340a;

    HandlerC1514br(AMSPlayerActivity aMSPlayerActivity) {
        this.f5340a = aMSPlayerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        switch (message.what) {
            case 1000:
                this.f5340a.m5480a(this.f5340a.f5242n);
                break;
            case 1001:
                this.f5340a.m5488b(true);
                this.f5340a.f5246r.setProgress(this.f5340a.f4701a.m5630a());
                if ((this.f5340a.f4701a.m5642h() & 1) != 1) {
                    this.f5340a.m5493d(false);
                    if (!this.f5340a.f5251w) {
                        this.f5340a.m5499f(true);
                    }
                }
                this.f5340a.m5524p();
                break;
        }
    }
}
