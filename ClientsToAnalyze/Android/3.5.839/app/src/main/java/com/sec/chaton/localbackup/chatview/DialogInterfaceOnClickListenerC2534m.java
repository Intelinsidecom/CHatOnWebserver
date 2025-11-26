package com.sec.chaton.localbackup.chatview;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.m */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2534m implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9121a;

    /* renamed from: b */
    final /* synthetic */ ChatViewFragment f9122b;

    DialogInterfaceOnClickListenerC2534m(ChatViewFragment chatViewFragment, String str) {
        this.f9122b = chatViewFragment;
        this.f9121a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f9122b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f9121a)));
        } catch (Exception e) {
            C4904y.m18635a(e, ChatViewFragment.f9073c);
        }
    }
}
