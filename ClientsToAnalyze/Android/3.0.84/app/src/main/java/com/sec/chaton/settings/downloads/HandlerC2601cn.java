package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;

/* compiled from: SkinListView.java */
/* renamed from: com.sec.chaton.settings.downloads.cn */
/* loaded from: classes.dex */
class HandlerC2601cn extends Handler {

    /* renamed from: a */
    final /* synthetic */ SkinListView f9828a;

    HandlerC2601cn(SkinListView skinListView) {
        this.f9828a = skinListView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == C2556aw.f9709b) {
            int i = message.arg1;
            if (this.f9828a.f9565i != null) {
                this.f9828a.m9387a(i == C2556aw.f9711d);
            }
        }
        super.handleMessage(message);
    }
}
