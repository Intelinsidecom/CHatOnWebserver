package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.br */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0995br implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f4065a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f4066b;

    DialogInterfaceOnClickListenerC0995br(ChatFragment chatFragment, String str) {
        this.f4066b = chatFragment;
        this.f4065a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f4066b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f4065a)));
        } catch (Exception e) {
            C3250y.m11443a(e, ChatFragment.f3484a);
        }
    }
}
