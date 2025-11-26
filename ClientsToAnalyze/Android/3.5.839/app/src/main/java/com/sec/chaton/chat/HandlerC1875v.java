package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.v */
/* loaded from: classes.dex */
class HandlerC1875v extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f7093a;

    HandlerC1875v(ChatFragment chatFragment) {
        this.f7093a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws IllegalStateException {
        super.handleMessage(message);
        if (this.f7093a.f5513aF != null) {
            this.f7093a.f5513aF.dismiss();
        }
        this.f7093a.f5527aT.setItemsCanFocus(true);
        this.f7093a.f5496M = false;
        if (message.obj == null) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.toast_error, 0).show();
        } else if (message.arg1 >= 13) {
            this.f7093a.m8175k(message.obj.toString());
        }
        this.f7093a.f5662cz.setPressed(false);
        this.f7093a.f5611cA.setVisibility(8);
        this.f7093a.m8124c(true);
    }
}
