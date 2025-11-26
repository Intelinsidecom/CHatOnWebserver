package com.sec.chaton.calllog.view;

import android.os.Handler;
import android.os.Message;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.i */
/* loaded from: classes.dex */
public class HandlerC1478i extends Handler {

    /* renamed from: a */
    final /* synthetic */ CallLogDetailFragment f5361a;

    /* renamed from: b */
    private boolean f5362b = false;

    public HandlerC1478i(CallLogDetailFragment callLogDetailFragment) {
        this.f5361a = callLogDetailFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f5362b) {
            CallLogDetailFragment.f5199k.setParent(this.f5361a, this.f5361a.f5226n);
            this.f5361a.m7698p();
            this.f5361a.m7693k();
            this.f5361a.m7692j();
            if (message.what != 8002) {
                if (message.what == 100) {
                    this.f5361a.m7674b("EVENT_UPDATE_GROUP_INFO");
                } else if (message.what == 8004) {
                    this.f5361a.m7674b("CallLogDetailActivity--handleMessage()?EVENT_CALLLOG_ADD");
                }
            }
        }
    }
}
