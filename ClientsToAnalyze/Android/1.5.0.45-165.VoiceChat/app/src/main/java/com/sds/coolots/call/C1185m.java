package com.sds.coolots.call;

import android.os.Message;
import com.sds.coolots.call.model.HighPriorityHandlerInterface;

/* renamed from: com.sds.coolots.call.m */
/* loaded from: classes.dex */
class C1185m implements HighPriorityHandlerInterface {

    /* renamed from: a */
    final /* synthetic */ C1181i f2509a;

    private C1185m(C1181i c1181i) {
        this.f2509a = c1181i;
    }

    /* synthetic */ C1185m(C1181i c1181i, C1185m c1185m) {
        this(c1181i);
    }

    @Override // com.sds.coolots.call.model.HighPriorityHandlerInterface
    public void removeMessages(int i) {
    }

    @Override // com.sds.coolots.call.model.HighPriorityHandlerInterface
    public void sendEmptyMessage(int i) {
    }

    @Override // com.sds.coolots.call.model.HighPriorityHandlerInterface
    public void sendEmptyMessageDelayed(int i, long j) {
    }

    @Override // com.sds.coolots.call.model.HighPriorityHandlerInterface
    public void sendMessage(Message message) {
    }

    @Override // com.sds.coolots.call.model.HighPriorityHandlerInterface
    public void sendMessageDelayed(Message message, long j) {
    }
}
