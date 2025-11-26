package com.sec.chaton.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.chat.p024b.C0952c;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.c */
/* loaded from: classes.dex */
class C1004c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4078a;

    C1004c(ChatFragment chatFragment) {
        this.f4078a = chatFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (this.f4078a.getActivity() != null && (extras = intent.getExtras()) != null && extras.containsKey(C1954g.f7474g) && ((EnumC1955h) extras.get(C1954g.f7474g)) == EnumC1955h.STranslator) {
            this.f4078a.f3646cR = C0952c.m5141a(this.f4078a.getActivity());
        }
    }
}
