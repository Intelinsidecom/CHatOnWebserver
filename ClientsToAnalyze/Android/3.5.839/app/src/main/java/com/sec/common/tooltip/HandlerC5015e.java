package com.sec.common.tooltip;

import android.os.Handler;
import android.os.Message;

/* compiled from: ToolTipView.java */
/* renamed from: com.sec.common.tooltip.e */
/* loaded from: classes.dex */
final class HandlerC5015e extends Handler {
    HandlerC5015e() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        ToolTipView toolTipView = (ToolTipView) message.obj;
        if (toolTipView.f18280a.f18290d != null) {
            toolTipView.m19035d();
        } else {
            toolTipView.m19033c();
        }
    }
}
