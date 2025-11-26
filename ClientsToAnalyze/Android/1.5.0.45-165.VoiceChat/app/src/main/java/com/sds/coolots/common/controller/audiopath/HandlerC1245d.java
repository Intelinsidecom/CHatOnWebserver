package com.sds.coolots.common.controller.audiopath;

import android.os.Handler;
import android.os.Message;
import com.sds.coolots.common.view.DisposeInterface;

/* renamed from: com.sds.coolots.common.controller.audiopath.d */
/* loaded from: classes.dex */
class HandlerC1245d extends Handler implements DisposeInterface {

    /* renamed from: a */
    final /* synthetic */ C1242a f2973a;

    /* renamed from: b */
    private boolean f2974b = false;

    HandlerC1245d(C1242a c1242a) {
        this.f2973a = c1242a;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        this.f2974b = true;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f2974b && message.what == 1001) {
            this.f2973a.updateSpeakerMode();
        }
    }
}
