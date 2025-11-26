package com.sec.vip.amschaton;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import java.io.IOException;

/* renamed from: com.sec.vip.amschaton.ak */
/* loaded from: classes.dex */
class HandlerC0637ak extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f4248a;

    HandlerC0637ak(AMSPlayerActivity aMSPlayerActivity) {
        this.f4248a = aMSPlayerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws IllegalStateException, Resources.NotFoundException, IOException {
        this.f4248a.m4016a(this.f4248a.f4026m);
        this.f4248a.m4028c(this.f4248a.f4034u);
        if (this.f4248a.f4031r == 1000) {
            this.f4248a.m4030d(false);
            this.f4248a.m4048p();
            this.f4248a.m4017a(this.f4248a.f4036w);
            if (this.f4248a.f4036w) {
                this.f4248a.m4049q();
            }
        }
    }
}
