package com.sec.vip.amschaton.honeycomb;

import android.os.Handler;
import android.os.Message;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.an */
/* loaded from: classes.dex */
class HandlerC1906an extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f7036a;

    HandlerC1906an(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f7036a = aMSMyWorksActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                if (this.f7036a.f6966p == 2002) {
                    this.f7036a.m6670a(this.f7036a.f6966p, message.arg1 != 0);
                    break;
                }
                break;
            case 1001:
                if (message.arg1 > 0) {
                    if (this.f7036a.f6966p == 2001) {
                        this.f7036a.m6670a(this.f7036a.f6966p, true);
                        break;
                    }
                } else {
                    this.f7036a.m6670a(2000, true);
                    break;
                }
                break;
        }
    }
}
