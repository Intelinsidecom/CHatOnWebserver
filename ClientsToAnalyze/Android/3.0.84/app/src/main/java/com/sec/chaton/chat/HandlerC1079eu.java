package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.util.C3227co;

/* compiled from: DuringCallController.java */
/* renamed from: com.sec.chaton.chat.eu */
/* loaded from: classes.dex */
class HandlerC1079eu extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1078et f4330a;

    HandlerC1079eu(C1078et c1078et) {
        this.f4330a = c1078et;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.f4330a.f4328j = true;
                this.f4330a.f4325g.setVisibility(0);
                this.f4330a.f4325g.setTag(Integer.valueOf(message.arg1));
                this.f4330a.f4325g.setText(C3227co.m11342b(message.arg1));
                int i = message.arg1 + 1;
                message.arg1 = i;
                sendMessageDelayed(obtainMessage(0, i, 0), 1000L);
                break;
            case 1:
                this.f4330a.f4325g.setVisibility(this.f4330a.f4325g.getVisibility() == 0 ? 4 : 0);
                if (message.arg1 == 0) {
                    this.f4330a.f4321c.setVisibility(8);
                    this.f4330a.f4325g.setVisibility(4);
                    this.f4330a.f4328j = false;
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
                if (this.f4330a.f4328j) {
                    removeMessages(1);
                }
                removeMessages(0);
                if (!hasMessages(1)) {
                    sendMessage(obtainMessage(0, message.arg1, 0));
                }
                this.f4330a.f4325g.setTag(0);
                break;
        }
    }
}
