package com.sec.chaton.control;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.sec.chaton.control.f */
/* loaded from: classes.dex */
class HandlerC0177f extends Handler {

    /* renamed from: a */
    final /* synthetic */ TaskContainer f1414a;

    private HandlerC0177f(TaskContainer taskContainer) {
        this.f1414a = taskContainer;
    }

    /* synthetic */ HandlerC0177f(TaskContainer taskContainer, C0208w c0208w) {
        this(taskContainer);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0211z c0211z = (C0211z) this.f1414a.f1389a.get(this.f1414a.f1392d);
        if (this.f1414a.f1391c == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = message.what;
        messageObtain.obj = new TaskContainerResultEntry(this.f1414a.f1394f, c0211z.m2165a(), message.obj);
        this.f1414a.f1391c.sendMessage(messageObtain);
    }
}
