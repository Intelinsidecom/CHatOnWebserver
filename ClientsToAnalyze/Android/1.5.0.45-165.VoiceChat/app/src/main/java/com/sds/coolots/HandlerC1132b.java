package com.sds.coolots;

import android.os.Handler;
import android.os.Message;
import java.io.IOException;

/* renamed from: com.sds.coolots.b */
/* loaded from: classes.dex */
class HandlerC1132b extends Handler {

    /* renamed from: a */
    final /* synthetic */ EngineInterface f2321a;

    HandlerC1132b(EngineInterface engineInterface) {
        this.f2321a = engineInterface;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws IOException {
        if (message.what == 10) {
            this.f2321a.handleResponseEvent((C1262d) message.obj);
        } else if (message.what == 11) {
            this.f2321a.handleP2PConfResponseEvent((C1263e) message.obj);
        }
        super.handleMessage(message);
    }
}
