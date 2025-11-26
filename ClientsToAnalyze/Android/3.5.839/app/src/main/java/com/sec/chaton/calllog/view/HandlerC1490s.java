package com.sec.chaton.calllog.view;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.calllog.manager.model.CallLogData;

/* compiled from: CallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.s */
/* loaded from: classes.dex */
class HandlerC1490s extends Handler {

    /* renamed from: a */
    final /* synthetic */ CallLogFragment f5418a;

    /* renamed from: b */
    private boolean f5419b;

    private HandlerC1490s(CallLogFragment callLogFragment) {
        this.f5418a = callLogFragment;
        this.f5419b = false;
    }

    /* synthetic */ HandlerC1490s(CallLogFragment callLogFragment, DialogInterfaceOnClickListenerC1484m dialogInterfaceOnClickListenerC1484m) {
        this(callLogFragment);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f5419b) {
            switch (message.what) {
                case 2001:
                    this.f5418a.m7732h();
                    break;
                case 2093:
                    this.f5418a.m7732h();
                    break;
                case 8000:
                    this.f5418a.m7725c("CallLog Updated!!");
                    this.f5418a.m7732h();
                    break;
                case 8002:
                    this.f5418a.m7713a((CallLogData) message.obj);
                    break;
                case 8003:
                    this.f5418a.m7725c("CallLog Added!!");
                    this.f5418a.m7732h();
                    break;
            }
        }
    }
}
