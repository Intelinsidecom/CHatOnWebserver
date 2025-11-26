package com.sec.chaton.specialbuddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyFollowEntry;
import com.sec.chaton.util.C4904y;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.w */
/* loaded from: classes.dex */
class HandlerC4558w extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f16430a;

    HandlerC4558w(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f16430a = specialBuddyChatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f16430a.isValidActivity()) {
            switch (message.what) {
                case 0:
                    String str = (String) message.obj;
                    this.f16430a.loadUrl(str);
                    C4904y.m18639b("[OUT] RESPONSE : " + str, SpecialBuddyChatFragment.f16299l);
                    break;
                case 1:
                    String str2 = (String) message.obj;
                    this.f16430a.loadUrl(str2);
                    C4904y.m18639b("[OUT] RESPONSE : " + str2, SpecialBuddyChatFragment.f16299l);
                    this.f16430a.m17214a((SpecialBuddyFollowEntry) null);
                    break;
            }
        }
    }
}
