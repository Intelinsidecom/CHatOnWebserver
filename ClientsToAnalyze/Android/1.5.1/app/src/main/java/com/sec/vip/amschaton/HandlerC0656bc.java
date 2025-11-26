package com.sec.vip.amschaton;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.sec.vip.amschaton.bc */
/* loaded from: classes.dex */
class HandlerC0656bc extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSFileListActivity f4270a;

    HandlerC0656bc(AMSFileListActivity aMSFileListActivity) {
        this.f4270a = aMSFileListActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                if (message.arg1 != 0) {
                    if (message.arg1 == 1) {
                        this.f4270a.f3945n.setEnabled(true);
                        break;
                    }
                } else {
                    this.f4270a.f3945n.setEnabled(false);
                    break;
                }
                break;
        }
    }
}
