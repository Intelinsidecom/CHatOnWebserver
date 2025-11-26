package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1330h;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.dz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1057dz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatInfoMoreFragment f4167a;

    DialogInterfaceOnClickListenerC1057dz(ChatInfoMoreFragment chatInfoMoreFragment) {
        this.f4167a = chatInfoMoreFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4167a.m5071c();
        this.f4167a.f3769k.setMessage(this.f4167a.getResources().getString(R.string.wait_sending));
        new C1330h(this.f4167a.f3771m).m5734b(this.f4167a.f3766h, true);
    }
}
