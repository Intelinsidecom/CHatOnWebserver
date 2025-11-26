package com.sec.chaton.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dy */
/* loaded from: classes.dex */
class C1671dy extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6222a;

    private C1671dy(ChatFragment chatFragment) {
        this.f6222a = chatFragment;
    }

    /* synthetic */ C1671dy(ChatFragment chatFragment, C1646d c1646d) {
        this(chatFragment);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
            if (C4904y.f17873c) {
                C4904y.m18641c("ACTION_USER_PRESENT received", ChatFragment.f5461a);
            }
            this.f6222a.m7846K();
        }
    }
}
