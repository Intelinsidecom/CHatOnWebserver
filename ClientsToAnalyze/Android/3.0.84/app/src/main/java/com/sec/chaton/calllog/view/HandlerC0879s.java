package com.sec.chaton.calllog.view;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.calllog.manager.model.CallLogData;

/* compiled from: CallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.s */
/* loaded from: classes.dex */
class HandlerC0879s extends Handler {

    /* renamed from: a */
    final /* synthetic */ CallLogFragment f3473a;

    /* renamed from: b */
    private boolean f3474b;

    private HandlerC0879s(CallLogFragment callLogFragment) {
        this.f3473a = callLogFragment;
        this.f3474b = false;
    }

    /* synthetic */ HandlerC0879s(CallLogFragment callLogFragment, DialogInterfaceOnClickListenerC0873m dialogInterfaceOnClickListenerC0873m) {
        this(callLogFragment);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f3474b) {
            switch (message.what) {
                case 2001:
                    this.f3473a.m4576g();
                    break;
                case 2093:
                    this.f3473a.m4576g();
                    break;
                case 8000:
                    this.f3473a.m4570c("CallLog Updated!!");
                    this.f3473a.m4576g();
                    break;
                case 8002:
                    this.f3473a.m4558a((CallLogData) message.obj);
                    break;
                case 8003:
                    this.f3473a.m4570c("CallLog Added!!");
                    this.f3473a.m4576g();
                    break;
            }
        }
    }
}
