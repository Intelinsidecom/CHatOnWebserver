package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2128i;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.fn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1714fn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatInfoMoreFragment f6318a;

    DialogInterfaceOnClickListenerC1714fn(ChatInfoMoreFragment chatInfoMoreFragment) {
        this.f6318a = chatInfoMoreFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f6318a.m8339c();
        this.f6318a.f5825j.setMessage(this.f6318a.getResources().getString(R.string.wait_sending));
        new C2128i(this.f6318a.f5828m).m9512b(this.f6318a.f5822g, true);
    }
}
