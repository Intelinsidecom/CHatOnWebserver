package com.sec.chaton.chat;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import com.sec.chaton.plugin.C2921a;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cf */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1625cf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6152a;

    DialogInterfaceOnClickListenerC1625cf(ChatFragment chatFragment) {
        this.f6152a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f6152a.f5624cN != null) {
            try {
                if (C4859bx.m18396c()) {
                    this.f6152a.startActivity(C2921a.m12141i(this.f6152a.f5624cN));
                } else {
                    this.f6152a.startActivity(C2921a.m12142j(this.f6152a.f5624cN));
                }
            } catch (ActivityNotFoundException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, ChatFragment.f5461a);
                }
            }
        }
    }
}
