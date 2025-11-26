package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.util.C4877co;

/* compiled from: DuringCallController.java */
/* renamed from: com.sec.chaton.chat.gq */
/* loaded from: classes.dex */
class HandlerC1744gq extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1743gp f6561a;

    HandlerC1744gq(C1743gp c1743gp) {
        this.f6561a = c1743gp;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.f6561a.f6559j = true;
                this.f6561a.f6556g.setVisibility(0);
                this.f6561a.f6556g.setTag(Integer.valueOf(message.arg1));
                this.f6561a.f6556g.setText(C4877co.m18515b(message.arg1));
                int i = message.arg1 + 1;
                message.arg1 = i;
                sendMessageDelayed(obtainMessage(0, i, 0), 1000L);
                break;
            case 1:
                this.f6561a.f6556g.setVisibility(this.f6561a.f6556g.getVisibility() == 0 ? 4 : 0);
                if (message.arg1 == 0) {
                    this.f6561a.f6552c.setVisibility(8);
                    this.f6561a.f6556g.setVisibility(4);
                    this.f6561a.f6559j = false;
                    break;
                } else {
                    int i2 = message.arg1 - 1;
                    message.arg1 = i2;
                    sendMessageDelayed(obtainMessage(1, i2, 0), 500L);
                    break;
                }
            case 3:
                removeMessages(0);
                break;
            case 4:
                if (this.f6561a.f6559j) {
                    removeMessages(1);
                }
                removeMessages(0);
                if (!hasMessages(1)) {
                    sendMessage(obtainMessage(0, message.arg1, 0));
                }
                this.f6561a.f6556g.setTag(0);
                break;
        }
    }
}
