package com.sec.chaton.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.chat.translate.C1850c;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.d */
/* loaded from: classes.dex */
class C1646d extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6178a;

    C1646d(ChatFragment chatFragment) {
        this.f6178a = chatFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (this.f6178a.getActivity() != null && (extras = intent.getExtras()) != null && extras.containsKey(C2948h.f10850g) && ((EnumC2949i) extras.get(C2948h.f10850g)) == EnumC2949i.STranslator) {
            this.f6178a.f5698dm = C1850c.m9021a(this.f6178a.getActivity());
        }
    }
}
