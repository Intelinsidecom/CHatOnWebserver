package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.k */
/* loaded from: classes.dex */
class HandlerC1099k extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4362a;

    HandlerC1099k(ChatFragment chatFragment) {
        this.f4362a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f4362a.f3656cb != null) {
            this.f4362a.f3507I = false;
            if (message.obj == null) {
                C3641ai.m13210a(CommonApplication.m11493l(), R.string.toast_error, 0).show();
            } else if (message.arg1 >= 13) {
                this.f4362a.m4915i(message.obj.toString());
            }
            this.f4362a.f3603bZ.setPressed(false);
            this.f4362a.f3655ca.setVisibility(8);
            this.f4362a.f3657cc.setVisibility(8);
            this.f4362a.f3658cd.setVisibility(8);
            if (this.f4362a.f3672cr != null) {
                this.f4362a.f3672cr.setRequestedOrientation(-1);
                this.f4362a.f3672cr.getWindow().clearFlags(128);
            }
        }
        super.handleMessage(message);
    }
}
