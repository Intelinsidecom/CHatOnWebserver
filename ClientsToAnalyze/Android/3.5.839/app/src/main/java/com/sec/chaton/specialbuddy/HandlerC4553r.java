package com.sec.chaton.specialbuddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.widget.C5179v;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.r */
/* loaded from: classes.dex */
class HandlerC4553r extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f16425a;

    HandlerC4553r(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f16425a = specialBuddyChatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f16425a.isValidActivity()) {
            if (message.what == 2) {
                C5179v.m19811a(this.f16425a.getAttachedActivity(), this.f16425a.getAttachedActivity().getString(R.string.live_unsupported_contents_message) + ".", 1).show();
                this.f16425a.getAttachedActivity().finish();
            } else if (message.what == 3) {
                C5179v.m19810a(this.f16425a.getAttachedActivity(), R.string.live_unsupported_buddy_message, 1).show();
                this.f16425a.getAttachedActivity().finish();
            }
            super.handleMessage(message);
        }
    }
}
