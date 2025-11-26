package com.sec.chaton.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.chat.notification.C1103a;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cy */
/* loaded from: classes.dex */
class C1029cy extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4117a;

    private C1029cy(ChatFragment chatFragment) {
        this.f4117a = chatFragment;
    }

    /* synthetic */ C1029cy(ChatFragment chatFragment, C1004c c1004c) {
        this(chatFragment);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
            if (this.f4117a.f3692dl != null) {
                context.unregisterReceiver(this.f4117a.f3692dl);
                this.f4117a.f3692dl = null;
            }
            if (this.f4117a.f3672cr != null) {
                C1103a.m5432a(context).m5462b(this.f4117a.f3703r);
                this.f4117a.m4684F();
            }
        }
    }
}
