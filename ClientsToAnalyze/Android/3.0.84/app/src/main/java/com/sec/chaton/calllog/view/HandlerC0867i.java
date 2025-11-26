package com.sec.chaton.calllog.view;

import android.os.Handler;
import android.os.Message;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.i */
/* loaded from: classes.dex */
public class HandlerC0867i extends Handler {

    /* renamed from: a */
    final /* synthetic */ CallLogDetailFragment f3388a;

    /* renamed from: b */
    private boolean f3389b = false;

    public HandlerC0867i(CallLogDetailFragment callLogDetailFragment) {
        this.f3388a = callLogDetailFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f3389b) {
            CallLogDetailFragment.f3227k.setParent(this.f3388a, this.f3388a.f3254n);
            this.f3388a.m4543o();
            this.f3388a.m4538j();
            this.f3388a.m4536i();
            if (message.what != 8002) {
                if (message.what == 100) {
                    this.f3388a.m4520b("EVENT_UPDATE_GROUP_INFO");
                } else if (message.what == 8004) {
                    this.f3388a.m4520b("CallLogDetailActivity--handleMessage()?EVENT_CALLLOG_ADD");
                }
            }
        }
    }
}
