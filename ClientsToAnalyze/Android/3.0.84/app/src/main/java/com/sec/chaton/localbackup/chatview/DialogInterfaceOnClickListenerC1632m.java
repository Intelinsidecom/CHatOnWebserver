package com.sec.chaton.localbackup.chatview;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.m */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1632m implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f6077a;

    /* renamed from: b */
    final /* synthetic */ ChatViewFragment f6078b;

    DialogInterfaceOnClickListenerC1632m(ChatViewFragment chatViewFragment, String str) {
        this.f6078b = chatViewFragment;
        this.f6077a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f6078b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f6077a)));
        } catch (Exception e) {
            C3250y.m11443a(e, ChatViewFragment.f6029c);
        }
    }
}
