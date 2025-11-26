package com.sec.vip.amschaton.fragment;

import android.os.Handler;
import android.os.Message;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cc */
/* loaded from: classes.dex */
class HandlerC3509cc extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12903a;

    HandlerC3509cc(AMSStampSelectionFragment aMSStampSelectionFragment) {
        this.f12903a = aMSStampSelectionFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f12903a.f12754m != 2002 && this.f12903a.f12752b != null) {
            this.f12903a.m12626f(this.f12903a.f12763v);
            this.f12903a.m12634h(this.f12903a.f12751a);
        }
        this.f12903a.m12625f();
        this.f12903a.f12756o = false;
    }
}
