package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.msgbox.C2660e;
import com.sec.chaton.msgbox.C2679x;
import com.sec.chaton.msgbox.C2680y;
import com.sec.chaton.msgsend.C2716x;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1599bg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6105a;

    DialogInterfaceOnClickListenerC1599bg(ChatFragment chatFragment) {
        this.f6105a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C2716x.m11377a(this.f6105a.f5750v);
        this.f6105a.f5735en = new C2660e(this.f6105a.getActivity(), this.f6105a.f5750v, 7);
        this.f6105a.f5735en.m11240a(new C2680y(new C2679x(this.f6105a.f5750v, this.f6105a.f5487D, null, this.f6105a.f5637ca, false), null, false), this.f6105a.f5713eB);
    }
}
