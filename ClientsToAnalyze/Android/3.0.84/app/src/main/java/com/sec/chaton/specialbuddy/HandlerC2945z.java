package com.sec.chaton.specialbuddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.z */
/* loaded from: classes.dex */
class HandlerC2945z extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f10481a;

    HandlerC2945z(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f10481a = specialBuddyChatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f10481a.m6966k()) {
            if (message.what == 2) {
                C3641ai.m13211a(this.f10481a.m6961f(), this.f10481a.m6961f().getString(R.string.live_unsupported_contents_message) + ".", 1).show();
                this.f10481a.m6961f().finish();
            } else if (message.what == 3) {
                C3641ai.m13210a(this.f10481a.m6961f(), R.string.live_unsupported_buddy_message, 1).show();
                this.f10481a.m6961f().finish();
            }
            super.handleMessage(message);
        }
    }
}
