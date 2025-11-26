package com.sec.chaton.chat;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cr */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1637cr implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f6165a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f6166b;

    DialogInterfaceOnClickListenerC1637cr(ChatFragment chatFragment, String str) {
        this.f6166b = chatFragment;
        this.f6165a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f6166b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f6165a)));
        } catch (ActivityNotFoundException e) {
            C4904y.m18635a(e, ChatFragment.f5461a);
        } catch (NullPointerException e2) {
            C4904y.m18635a(e2, ChatFragment.f5461a);
        }
    }
}
