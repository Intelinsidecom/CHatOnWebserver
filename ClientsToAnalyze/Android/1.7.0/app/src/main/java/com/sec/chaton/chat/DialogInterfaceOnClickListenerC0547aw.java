package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.p032i.C0722a;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.aw */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0547aw implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1907a;

    DialogInterfaceOnClickListenerC0547aw(ChatFragment chatFragment) {
        this.f1907a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C0722a.m3116a(this.f1907a.getActivity()).m3119a(this.f1907a.getActivity(), 1);
        Intent intent = new Intent("com.sec.motions.MOTIONS_SETTINGS_CHANGED");
        intent.putExtra("isEnable", true);
        this.f1907a.getActivity().sendBroadcast(intent);
        this.f1907a.f1747H = null;
    }
}
