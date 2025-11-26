package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bh */
/* loaded from: classes.dex */
class HandlerC1439bh extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5074a;

    HandlerC1439bh(AMSPlayerActivity aMSPlayerActivity) {
        this.f5074a = aMSPlayerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        switch (message.what) {
            case 1000:
                this.f5074a.m5157a(this.f5074a.f4998n);
                break;
            case 1001:
                this.f5074a.m5171d(true);
                this.f5074a.f5002r.setProgress(this.f5074a.f4701a.m5630a());
                if ((this.f5074a.f4701a.m5642h() & 1) != 1) {
                    this.f5074a.m5175f(false);
                    if (!this.f5074a.f5007w) {
                        this.f5074a.m5182h(true);
                    }
                }
                this.f5074a.m5201p();
                break;
        }
    }
}
