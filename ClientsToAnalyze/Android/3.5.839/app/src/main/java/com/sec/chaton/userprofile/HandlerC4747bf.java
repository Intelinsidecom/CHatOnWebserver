package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bf */
/* loaded from: classes.dex */
class HandlerC4747bf extends Handler {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f17411a;

    HandlerC4747bf(MyPageFragment myPageFragment) {
        this.f17411a = myPageFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f17411a.getActivity() != null && !this.f17411a.getActivity().isFinishing()) {
            int i = message.what;
        }
    }
}
