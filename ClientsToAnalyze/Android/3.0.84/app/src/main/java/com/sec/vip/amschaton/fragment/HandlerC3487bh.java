package com.sec.vip.amschaton.fragment;

import android.os.Handler;
import android.os.Message;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bh */
/* loaded from: classes.dex */
class HandlerC3487bh extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSListFragment f12856a;

    HandlerC3487bh(AMSListFragment aMSListFragment) {
        this.f12856a = aMSListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f12856a.isDetached()) {
            if (this.f12856a.f12728a != 2002) {
                this.f12856a.m12532a(this.f12856a.f12739u, true);
            }
            this.f12856a.f12734p = false;
        }
    }
}
