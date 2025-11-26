package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.view.DisposeInterface;

/* renamed from: com.sds.coolots.call.model.r */
/* loaded from: classes.dex */
class HandlerC1216r extends Handler implements DisposeInterface {

    /* renamed from: a */
    final /* synthetic */ C1214p f2759a;

    /* renamed from: b */
    private boolean f2760b;

    private HandlerC1216r(C1214p c1214p) {
        this.f2759a = c1214p;
        this.f2760b = false;
    }

    /* synthetic */ HandlerC1216r(C1214p c1214p, HandlerC1216r handlerC1216r) {
        this(c1214p);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        this.f2760b = true;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f2760b) {
            return;
        }
        this.f2759a.m2676f("<mInnerHandler> msg.what:" + message.what);
        switch (message.what) {
            case 13:
                this.f2759a.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_P2P_FAIL_TIMER, 0, 0, null);
                break;
            case 14:
                if (this.f2759a.f2753K || this.f2759a.f2545n) {
                    this.f2759a.m2663Q();
                    this.f2759a.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_P2P_FAILURE, 0, 0, null);
                    break;
                }
                break;
        }
        this.f2759a.f2756R.removeMessages(message.what);
    }
}
