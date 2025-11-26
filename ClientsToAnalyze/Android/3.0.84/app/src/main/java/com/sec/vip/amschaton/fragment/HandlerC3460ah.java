package com.sec.vip.amschaton.fragment;

import android.os.Handler;
import android.os.Message;

/* compiled from: AMSComposerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.ah */
/* loaded from: classes.dex */
class HandlerC3460ah extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSComposerFragment f12820a;

    HandlerC3460ah(AMSComposerFragment aMSComposerFragment) {
        this.f12820a = aMSComposerFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f12820a.f12654B != null) {
            if (message.what == 1) {
                this.f12820a.f12654B.m12030k();
            } else {
                this.f12820a.f12654B.m12031l();
            }
        }
    }
}
